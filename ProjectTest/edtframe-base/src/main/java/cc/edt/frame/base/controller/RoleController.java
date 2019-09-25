package cc.edt.frame.base.controller;

import cc.edt.frame.base.service.RoleService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.condition.RoleCondition;
import cc.edt.frame.model.entity.base.Role;
import cc.edt.frame.model.entity.base.User;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.random.IceRandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限信息
 *
 * @author 刘钢
 * @date 2017/12/18 12:00
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Resource
	private RoleService roleService;


	/**
	 * 获取所有角色信息
	 *
	 * @param condition
	 *            condition
	 * @author 奚艺轩
	 * @date 2017/12/18 12:00
	 */
	@RequestMapping("getRoleByAll")
	@ResponseBody
	public void getRoleByNoRowsByAll(RoleCondition condition) {
		User user = (User) httpSession.getAttribute("USER");
		condition.setUserId(user.getId());
		condition.setRows(0);
		condition.setPage(1);
		List<Role> listRole = roleService.listRoleByCondition(condition);
		writerToPageByJson(listRole);
	}


}
