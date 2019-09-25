package cc.edt.frame.base.controller;

import cc.edt.frame.base.service.UserService;
import cc.edt.frame.common.annotation.Log;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.condition.UserCondition;
import cc.edt.frame.model.entity.base.User;
import cc.edt.frame.model.entity.base.UserMechanismsLinked;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.random.IceRandomUtils;
import cc.edt.iceutils2.security.IceEncryptionUtils;
import cc.edt.iceutils2.string.IceStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:14
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * 验证用户登录
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:04
	 */
	@RequestMapping("login")
	@ResponseBody
	public void login(User user, @RequestParam String validateCode) {
		ActionResult actionResult = new ActionResult();
		// 验证session中的验证码
		String sessionCode = (String) httpSession.getAttribute("VALIDATECODE");
		if ((sessionCode != null)
				&& (sessionCode.equalsIgnoreCase(validateCode))) {
			user.setLoginPassword(
					IceEncryptionUtils.md5Hex(user.getLoginPassword()));
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
					user.getLoginId(), user.getLoginPassword());
			// usernamePasswordToken.setRememberMe(true);
			Subject currentUser = SecurityUtils.getSubject();
			try {
				currentUser.login(usernamePasswordToken);
				actionResult.setSuccess(true);
			} catch (UnknownAccountException uae) {
				actionResult.setSuccess(false);
				actionResult.setMessage("未知账号");
			} catch (IncorrectCredentialsException ice) {
				actionResult.setSuccess(false);
				actionResult.setMessage("用户名或密码不正确");
			} catch (LockedAccountException lae) {
				actionResult.setSuccess(false);
				actionResult.setMessage("账号已锁定");
			} catch (ExcessiveAttemptsException eae) {
				actionResult.setSuccess(false);
				actionResult.setMessage("用户名或密码错误次数过多");
			} catch (DisabledAccountException dae) {
				actionResult.setSuccess(false);
				actionResult.setMessage("账号已停用");
			} catch (AuthenticationException ae) {
				actionResult.setSuccess(false);
				actionResult.setMessage("用户名或密码不正确");
			}
			// 验证是否登录成功
			if (!currentUser.isAuthenticated()) {
				usernamePasswordToken.clear();
			}
		} else {
			actionResult.setSuccess(false);
			actionResult.setMessage("验证码错误");
		}
		writerToPageByJson(actionResult);
	}

	/**
	 * 用户退出
	 *
	 * @return org.springframework.web.servlet.ModelAndView
	 * @author 刘钢
	 * @date 2017/6/11 22:05
	 */
	@RequestMapping("logout")
	public ModelAndView logoutAction() {
		httpSession.removeAttribute("USER");
		SecurityUtils.getSubject().logout();
		return new ModelAndView("redirect:/login");
	}

	/**
	 * 进入个人信息
	 *
	 * @param user
	 *            user
	 * @return java.lang.String
	 * @author 刘钢
	 * @date 2017/6/11 22:05
	 */
	@RequestMapping("toUserInfo")
	public String toUserInfo(User user, Model model) {
		user = userService.getUserById(user.getId());
		model.addAttribute(user);
		return "user/userInfo";
	}

	/**
	 * 修改密码
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:05
	 */
	@RequestMapping("updatePassword")
	@ResponseBody
	public void updatePassword(User user) {
		ActionResult actionResult = userService.updateUserPassword(user);
		writerToPageByJson(actionResult);
	}

	/**
	 * 修改个人信息
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:05
	 */
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public void updateUserInfo(User user) {
		ActionResult actionResult = userService.updateUserByUserInfo(user);
		writerToPageByJson(actionResult);
	}

	/**
	 * 获取所有用户信息
	 *
	 * @param condition
	 *            condition
	 * @author 刘钢
	 * @date 2017/6/11 22:06
	 */
	@RequestMapping("getUserByConditon")
	@ResponseBody
	public void getUserByConditon(UserCondition condition) {
		User user = (User) httpSession.getAttribute("USER");
		condition.setUserId(user.getId());
		condition.setRows(condition.getLength());
		condition.setPage(condition.getStart() / condition.getLength() + 1);
		List<User> listRole = userService.listUserByCondition(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("draw", condition.getDraw());
		map.put("recordsTotal", condition.getTotalRows());
		map.put("recordsFiltered", condition.getTotalRows());
		map.put("data", listRole);
		writerToPageByJson(map);

	}

	/**
	 * 保存用户
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:06
	 */

	@RequestMapping("saveUser")
	@ResponseBody
	@Log(operationType = "添加用户", operationName = "用户管理")
	public void saveUser(User user) {
		User sessionUser = (User) httpSession.getAttribute("USER");
		user.setId(IceRandomUtils.longUUID());
		user.setLoginPassword(
				IceEncryptionUtils.md5Hex(user.getLoginPassword()));
		user.setDeleteFlag(2);
		user.setActive(2);
		user.setAddTime(new Date());
		user.setAddUser(sessionUser.getLoginId());
		writerToPageByJson(userService.saveUser(user));
	}

	/**
	 * 根据用户userId查询用户信息，用于修改页面的跳转
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 13:16
	 */
	@RequestMapping("toUpdateUser")
	public String toUpdateUser(User user, Model model) {
		user = userService.getUserById(user.getId());
		List<String> listStr = new ArrayList<>();
		if (user != null) {
			List<UserMechanismsLinked> listUserMechanismsLinked = userService
					.listUserMechanismsLinkedByUserId(user.getId());
			for (UserMechanismsLinked userMechanismsLinked : listUserMechanismsLinked) {
				listStr.add(userMechanismsLinked.getMechanismsId());
			}
			model.addAttribute("userMechanismsRights",
					IceStringUtils.join(listStr, ","));
			user.setRoleId(user.getRole().getId());
			model.addAttribute(user);
			return "user/userUpdate";
		}
		return "/none";
	}

	/**
	 * 修改用户信息
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:06
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	@Log(operationType = "修改用户", operationName = "用户管理")
	public void updateUser(User user) {
		writerToPageByJson(userService.updateUser(user));
	}

	/**
	 * 删除/找回用户
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:06
	 */
	@RequestMapping("updateDeleteFlag")
	@ResponseBody
	@Log(operationType = "删除用户", operationName = "用户管理")
	public void updateDeleteFlag(User user) {
		writerToPageByJson(userService.updateUserDeleteFlag(user));
	}

	/**
	 * 启用/禁用用户
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 13:16
	 */
	@RequestMapping("updateState")
	@ResponseBody
	@Log(operationType = "启用/禁用用户", operationName = "用户管理")
	public void updateState(User user) {
		writerToPageByJson(userService.updateState(user));
	}

	/**
	 * 重置密码
	 *
	 * @param user
	 *            user
	 * @author 刘钢
	 * @date 2017/6/11 22:06
	 */
	@RequestMapping("resetLoginPassword")
	@ResponseBody
	@Log(operationType = "重置用户密码", operationName = "用户管理")
	public void resetLoginPassword(User user) {
		writerToPageByJson(userService.updateLoginPassword(user));
	}

}
