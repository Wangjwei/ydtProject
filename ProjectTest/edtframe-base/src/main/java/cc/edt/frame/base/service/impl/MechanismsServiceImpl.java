package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.MechanismsDao;
import cc.edt.frame.base.service.MechanismsService;
import cc.edt.frame.base.service.UserService;
import cc.edt.frame.base.service.component.ActionResultService;
import cc.edt.frame.common.constant.CommonConstant;
import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Mechanisms;
import cc.edt.frame.model.entity.base.User;
import cc.edt.frame.model.entity.base.UserMechanismsLinked;
import cc.edt.frame.model.result.ActionResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 组织机构
 * 
 * @author 刘钢
 * @date 2018/6/21 16:17
 */
@Service
public class MechanismsServiceImpl implements MechanismsService {

	@Resource
	private MechanismsDao mechanismsDao;
	@Resource
	private UserService userService;
	@Resource
	private ActionResultService actionResultService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult saveMechanisms(Mechanisms mechanisms) {
		// 机构名称不能重复
		ActionResult actionResult = checkSame(mechanisms);
		if (actionResult.isSuccess()) {
			mechanismsDao.saveMechanisms(mechanisms);
			// 给当前用户及当前用户上级所有机构赋予当前添加机构的查询权限
			// 获取所有上级机构
			List<Mechanisms> listMechanisms = mechanismsDao
					.listMechanismsParentById(
							mechanisms.getUser().getMechanisms().getId());
			for (Mechanisms mechanismsId : listMechanisms) {
				// 根据机构ID获取用户信息
				List<User> listUser = userService
						.listUserByMechanismsId(mechanismsId.getId());
				for (User user : listUser) {
					UserMechanismsLinked userMechanismsLinked = new UserMechanismsLinked();
					userMechanismsLinked.setMechanismsId(mechanisms.getId());
					userMechanismsLinked.setUserId(user.getId());
					mechanismsDao
							.saveUserMechanismsLinked(userMechanismsLinked);
				}
			}
			actionResult = actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_TRUE);
		}
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult updateMechanisms(Mechanisms mechanisms) {
		// 机构名称不能重复
		ActionResult actionResult = checkSame(mechanisms);
		if (actionResult.isSuccess()) {
			if (mechanisms.getId().equals(mechanisms.getParentId())) {
				actionResult = actionResultService.callBackResult(
						CommonConstant.ACTIONRESULT_FAIL, "所属机构不能是自己");
			} else {
				// 修改当前节点下所有直接子节点的父机构名称
				mechanismsDao.updateMechanismsByParentId(mechanisms);
				// 修改机构名称
				mechanismsDao.updateMechanisms(mechanisms);
				actionResult = actionResultService
						.callBackResult(CommonConstant.ACTIONRESULT_TRUE);
			}
		}
		return actionResult;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ActionResult deleteMechanisms(String id) {
		String mechanismsRootId = "0";
		if (mechanismsRootId.equals(id)) {
			return actionResultService.callBackResult(
					CommonConstant.ACTIONRESULT_FAIL, "机构根节点不能删除");
		}
		mechanismsDao.deleteMechanisms(id);
		mechanismsDao.deleteUserMechanismsLinked(id);
		return actionResultService
				.callBackResult(CommonConstant.ACTIONRESULT_TRUE, "机构删除成功");
	}

	@Override
	public Mechanisms getMechanismsByName(String name) {
		return mechanismsDao.getMechanismsByName(name);
	}

	@Override
	public List<Mechanisms> listMechanismByCondition(
			FindCondition findCondition) {
		PageHelper.startPage(findCondition.getPage(), findCondition.getRows());
		List<Mechanisms> listMechanisms = mechanismsDao
				.listMechanismByCondition(findCondition);
		PageInfo<Mechanisms> pageInfo = new PageInfo<>(listMechanisms);
		findCondition.setTotalRows(pageInfo.getTotal());
		return listMechanisms;
	}

	@Override
	public Mechanisms getMechanismsById(String id) {
		return mechanismsDao.getMechanismsById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteAllMechanisms() {
		mechanismsDao.deleteAllMechanisms();
	}

	@Override
	public List<Mechanisms> listMechanismsByUserId(String userId) {
		return mechanismsDao.listMechanismsByUserId(userId);
	}

	@Override
	public List<Mechanisms> getMechanismsUserTree(String id) {
		return mechanismsDao.getMechanismsUserTree(id);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveMechanismsForInit(Mechanisms mechanisms) {
		mechanismsDao.saveMechanisms(mechanisms);
	}

	/**
	 * 重复项检查
	 *
	 * @param mechanisms
	 *            mechanisms
	 * @return cc.edt.iceframe5.base.common.result.ActionResult
	 * @author 刘钢
	 * @date 2018/3/15 11:54
	 */
	private ActionResult checkSame(Mechanisms mechanisms) {
		Mechanisms mechanismsName = getMechanismsByName(mechanisms.getName());
		if (mechanismsName != null
				&& !mechanismsName.getId().equals(mechanisms.getId())) {
			return actionResultService
					.callBackResult(CommonConstant.ACTIONRESULT_FAIL, "名称不能重复");
		}
		return actionResultService
				.callBackResult(CommonConstant.ACTIONRESULT_TRUE);
	}

}
