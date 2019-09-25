package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.UserDao;
import cc.edt.frame.base.service.RoleService;
import cc.edt.frame.base.service.UserService;
import cc.edt.frame.base.service.component.ActionResultService;
import cc.edt.frame.common.constant.CommonConstant;
import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Role;
import cc.edt.frame.model.entity.base.User;
import cc.edt.frame.model.entity.base.UserMechanismsLinked;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.security.IceEncryptionUtils;
import cc.edt.iceutils2.string.IceStringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 * 
 * @author 刘钢
 * @date 2018/6/21 11:17
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private RoleService roleService;
	@Resource
	private ActionResultService actionResultService;

	@Override
	public User login(String loginId) {
		return userDao.login(loginId);
	}

	@Override
	public List<User> listUserByCondition(FindCondition findCondition) {
		PageHelper.startPage(findCondition.getPage(), findCondition.getRows());
		List<User> listUser = userDao.listUserByCondition(findCondition);
		for (User user : listUser) {
			switch (user.getActive()) {
			case 1:
				user.setActiveName("禁用");
				break;
			case 2:
				user.setActiveName("启用");
				break;
			default:
				user.setActiveName("");
			}
			user.setRoleName(user.getRole().getName());
			user.setMechanismsName(user.getMechanisms().getName());
		}
		PageInfo<User> pageInfo = new PageInfo<>(listUser);
		findCondition.setTotalRows(pageInfo.getTotal());
		return listUser;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult saveUser(User user) {
		ActionResult actionResult = checkSame(user);
		if (actionResult.isSuccess()) {
			// 根据角色ID查询所属角色
			Role role = roleService.getRoleById(user.getRoleId());
			if (role != null) {
				// 保存用户表
				userDao.saveUser(user);
				// 保存用户机构查询关联表
				saveUserMechanismsLinked(user);
				actionResult = actionResultService
						.callBackResult(CommonConstant.ACTIONRESULT_TRUE);
			} else {
				actionResult = actionResultService.callBackResult(
						CommonConstant.ACTIONRESULT_FAIL, "关联的角色不存在");
			}
		}
		return actionResult;
	}

	/**
	 * 保存用户可查询机构中间表
	 *
	 * @param user
	 *            user
	 * @author 刘钢 2017-07-07 16:56
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveUserMechanismsLinked(User user) {
		// 保存机构关联表
		if (IceStringUtils.isNotBlank(user.getUserMechanismsRights())) {
			String[] userMechanismsRights = user.getUserMechanismsRights()
					.split(",");
			for (String mechanismsId : userMechanismsRights) {
				if (IceStringUtils.isNotEmpty(mechanismsId)) {
					UserMechanismsLinked userMechanismsLinked = new UserMechanismsLinked();
					userMechanismsLinked.setUserId(user.getId());
					userMechanismsLinked.setMechanismsId(mechanismsId);
					userDao.saveUserMechanismsLinked(userMechanismsLinked);
				}
			}
		}
	}

	@Override
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateUser(User user) {
		ActionResult actionResult;
		// 查询对应的角色信息
		Role role = roleService.getRoleById(user.getRoleId());
		if (role != null) {
			userDao.updateUser(user);
			// 保存用户机构查询关联表
			userDao.deleteUserMechanismsLinked(user.getId());
			saveUserMechanismsLinked(user);
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "修改成功");
		} else {
			actionResult = actionResultService.callBackResult(
					CommonConstant.ACTIONRESULT_FAIL, "关联角色不存在,修改失败");
		}

		return actionResult;
	}

	@Override
	public User getUserByLoginId(String loginId) {
		return userDao.getUserByLoginId(loginId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult deleteUser(String id) {
		ActionResult actionResult;
		// 删除用户可查询机构的中间表
		userDao.deleteUserMechanismsLinked(id);
		// 删除用户信息
		userDao.deleteUser(id);
		actionResult = actionResultService
				.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "用户删除成功");
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateState(User user) {
		ActionResult actionResult;
		userDao.updateState(user);
		if (user.getActive() == 1) {
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "禁用成功");
		} else {
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "启用成功");
		}
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateLoginPassword(User user) {
		ActionResult actionResult;
		user = userDao.getUserById(user.getId());
		user.setLoginPassword(IceEncryptionUtils.md5Hex(user.getLoginId()));
		userDao.updateLoginPassword(user);
		actionResult = actionResultService.callBackResult(
				CommonConstant.ACTIONRESULT_TRUE,
				"密码重置成功，已经将密码重置为" + user.getLoginId());
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateUserByUserInfo(User user) {
		ActionResult actionResult;
		userDao.updateUserInfo(user);
		actionResult = actionResultService
				.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "修改个人信息成功");
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateUserPassword(User user) {
		ActionResult actionResult;
		User userId = userDao.getUserById(user.getId());
		if (IceEncryptionUtils.md5Hex(user.getOldPassword())
				.equals(userId.getLoginPassword())) {
			user.setLoginPassword(
					IceEncryptionUtils.md5Hex(user.getLoginPassword()));
			userDao.updateLoginPassword(user);
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "修改密码成功");
		} else {
			actionResult = actionResultService.callBackResult(
					CommonConstant.ACTIONRESULT_FAIL, "旧密码输入错误，请重新输入!");
		}
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateUserDeleteFlag(User user) {
		ActionResult actionResult;
		userDao.updateDeleteFlag(user);
		if (user.getDeleteFlag() == 1) {
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "删除用户成功");
		} else {
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "找回用户成功");
		}
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteAllUserInfo() {
		userDao.deleteAllUserInfo();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<UserMechanismsLinked> listUserMechanismsLinkedByUserId(
			String userId) {
		return userDao.listUserMechanismsLinkedByUserId(userId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteUserMechanismsLinkedByAll() {
		userDao.deleteUserMechanismsLinkedByAll();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveUserMechanismsLinked(
			UserMechanismsLinked userMechanismsLinked) {
		userDao.saveUserMechanismsLinked(userMechanismsLinked);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<User> listUserByMechanismsId(String mechanismsId) {
		return userDao.listUserByMechanismsId(mechanismsId);
	}

	/**
	 * 重复内容检查
	 *
	 * @param user
	 *            user
	 * @return cc.edt.iceframe5.base.common.result.ActionResult
	 * @author 刘钢
	 * @date 2018/3/15 11:52
	 */
	private ActionResult checkSame(User user) {
		User userLoginId = getUserByLoginId(user.getLoginId());
		if (userLoginId != null && !userLoginId.getId().equals(user.getId())) {
			return actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_FAIL, "账号不能重复");
		}
		return actionResultService
				.callBackResult(CommonConstant.ACTIONRESULT_TRUE);
	}
}
