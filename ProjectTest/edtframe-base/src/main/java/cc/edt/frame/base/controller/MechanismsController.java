package cc.edt.frame.base.controller;

import cc.edt.frame.base.service.MechanismsService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.condition.MechanismsCondition;
import cc.edt.frame.model.entity.base.Mechanisms;
import cc.edt.frame.model.entity.base.User;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.random.IceRandomUtils;
import cc.edt.iceutils2.string.IceStringUtils;
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
 * 组织机构
 *
 * @author 刘钢
 * @date 2017/12/18 14:11
 */
@Controller
@RequestMapping("/mechanisms")
public class MechanismsController extends BaseController {
	@Resource
	private MechanismsService mechanismsService;

	/**
	 * 获取机构树
	 *
	 * @author 刘钢
	 * @date 2017/12/18 11:55
	 */
	@RequestMapping("/getMechanismsTree")
	@ResponseBody
	public void getMechanismsTree(MechanismsCondition condition) {
		User user = (User) httpSession.getAttribute("USER");
		condition.setMechanismsId(user.getMechanisms().getId());
		condition.setRows(0);
		condition.setPage(1);
		condition.setAddUser(user.getId());
		List<Mechanisms> listMechanisms = mechanismsService
				.listMechanismByCondition(condition);
		writerToPageByJson(listMechanisms);
	}

	/**
	 * 获取当前登录用户所在机构树
	 *
	 * @author 刘钢
	 * @date 2017/12/18 11:55
	 */
	@RequestMapping("/getMechanismsUserTree")
	@ResponseBody
	public void getMechanismsUserTree() {
		User user = (User) httpSession.getAttribute("USER");
		List<Mechanisms> listMechanisms = mechanismsService
				.getMechanismsUserTree(user.getMechanisms().getId());
		writerToPageByJson(listMechanisms);
	}

	/**
	 * 获取查询条件获取机构信息
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:55
	 */
	@RequestMapping("getListMechanismByCondition")
	@ResponseBody
	public void getListMechanismByCondition(MechanismsCondition condition) {
		User user = (User) httpSession.getAttribute("USER");
		condition.setMechanismsId(user.getMechanisms().getId());
		condition.setRows(condition.getLength());
		condition.setPage(condition.getStart() / condition.getLength() + 1);
		condition.setUserId(user.getId());
		condition.setAddUser(user.getId());
		// 根据机构名称查询
		if (IceStringUtils.isNotBlank(condition.getMechanismsName())) {
			condition.setMechanismsName(condition.getMechanismsName());
		}
		List<Mechanisms> listMechanisms = mechanismsService
				.listMechanismByCondition(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("draw", condition.getDraw());
		map.put("recordsTotal", condition.getTotalRows());
		map.put("recordsFiltered", condition.getTotalRows());
		map.put("data", listMechanisms);
		writerToPageByJson(map);
	}

	/**
	 * 根据机构菜单选择的机构条件进行查询
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:55
	 */
	@RequestMapping("getListMechanismByMechanismsFlag")
	@ResponseBody
	public void getListMechanismByMechanismsFlag(
			MechanismsCondition condition) {
		condition.setRows(condition.getLength());
		condition.setPage(condition.getStart() / condition.getLength() + 1);
		List<Mechanisms> listMechanisms = mechanismsService
				.listMechanismByCondition(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("draw", condition.getDraw());
		map.put("recordsTotal", condition.getTotalRows());
		map.put("recordsFiltered", condition.getTotalRows());
		map.put("data", listMechanisms);
		writerToPageByJson(map);
	}

	/**
	 * 保存组织机构信息
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:55
	 */
	@RequestMapping("saveMechanisms")
	@ResponseBody
	public void saveMechanisms(Mechanisms mechanisms) {
		User user = (User) httpSession.getAttribute("USER");
		mechanisms.setId(IceRandomUtils.longUUID());
		mechanisms.setAddTime(new Date());
		mechanisms.setAddUser(user.getId());
		mechanisms.setUser(user);
		ActionResult actionResult = mechanismsService
				.saveMechanisms(mechanisms);
		writerToPageByJson(actionResult);
	}

	/**
	 * 修改组织机构
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:56
	 */
	@RequestMapping("updateMechanisms")
	@ResponseBody
	public void updateMechanisms(Mechanisms mechanisms) {
		ActionResult actionResult = mechanismsService
				.updateMechanisms(mechanisms);
		writerToPageByJson(actionResult);
	}

	/**
	 * 获得要修改的组织机构信息
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:56
	 */
	@RequestMapping("toUpdateMechanisms")
	public String toUpdateMechanisms(Mechanisms mechanisms, Model model) {
		mechanisms = mechanismsService.getMechanismsById(mechanisms.getId());
		if (mechanisms != null) {
			model.addAttribute(mechanisms);
			return "mechanisms/mechanismsUpdate";
		} else {
			return "none";
		}
	}

	/**
	 * 删除组织机构信息
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:56
	 */
	@RequestMapping("deleteMechanisms")
	@ResponseBody
	public void deleteMechanisms(Mechanisms mechanisms) {
		ActionResult actionResult = mechanismsService
				.deleteMechanisms(mechanisms.getId());
		writerToPageByJson(actionResult);
	}

}
