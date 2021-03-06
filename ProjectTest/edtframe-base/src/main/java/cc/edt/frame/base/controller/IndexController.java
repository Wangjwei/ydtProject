package cc.edt.frame.base.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.edt.frame.common.constant.CommonConstant;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.entity.base.Menu;
import cc.edt.frame.model.entity.base.Role;
import cc.edt.frame.model.entity.base.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.edt.iceutils2.image.IceValidateImage;
import cc.edt.iceutils2.random.IceValidateCodeUtils;

/**
 * 系统主页
 *
 * @author 刘钢
 * @date 2017/12/18 10:49
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

	private List<IndexRoleMenu> listIndexRoleMenu = new ArrayList<>();
	private final static String MENU_ROOT_NODE = "0";

	/**
	 * 系统登录页
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 系统主页
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	@RequestMapping("index")
	public String index(Model model) {
		listIndexRoleMenu.clear();
		User user = (User) httpSession.getAttribute("USER");
		if (user != null) {
			Role role = user.getRole();
			IndexRoleMenu indexRoleMenu = new IndexRoleMenu();
			indexRoleMenu.setId("0");
			indexRoleMenu.setPid("0");
			IndexRoleMenu indexRoleMenuFather = new IndexRoleMenu();
			List<IndexRoleMenu> listIndexRoleMenuFather = new ArrayList<>();
			indexRoleMenuFather.setId("0");
			indexRoleMenuFather.setPid("0");
			indexRoleMenuFather.setListMenuChild(listIndexRoleMenuFather);
			getIndexRoleMenuChilds(role.getListMenu(), indexRoleMenu,
					indexRoleMenuFather);
			model.addAttribute(user);
			model.addAttribute("listIndexRoleMenu", listIndexRoleMenu);
			return "index";
		} else {
			return "login";
		}
	}

	/**
	 * 功能菜单-将子节点挂载到父节点上
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	private void getIndexRoleMenuChilds(List<Menu> listMenu,
			IndexRoleMenu indexRoleMenu, IndexRoleMenu indexRoleMenuFather) {
		// 含有子节点
		if (hasChildNode(listMenu, indexRoleMenu)) {
			// 获取当前节点下的子节点
			List<IndexRoleMenu> listIndexRoleMenuChild = getIndexRoleMenuChild(
					listMenu, indexRoleMenu);
			indexRoleMenu.setListMenuChild(listIndexRoleMenuChild);
			// 遍历父节点，加入到父节点的集合中
			for (int i = 0; i < indexRoleMenuFather.getListMenuChild()
					.size(); i++) {
				if (indexRoleMenu.getId().equals(indexRoleMenuFather
						.getListMenuChild().get(i).getId())) {
					indexRoleMenuFather.getListMenuChild().get(i)
							.setListMenuChild(listIndexRoleMenuChild);
				}
			}
			// 根节点不放到里面
			if (MENU_ROOT_NODE.equals(indexRoleMenu.getPid())
					&& !MENU_ROOT_NODE.equals(indexRoleMenu.getId())) {
				indexRoleMenuFather.setListMenuChild(listIndexRoleMenuChild);
				listIndexRoleMenu.add(indexRoleMenu);
			}
			for (int i = 0; i < listIndexRoleMenuChild.size(); i++) {
				getIndexRoleMenuChilds(listMenu,
						indexRoleMenu.getListMenuChild().get(i),
						indexRoleMenuFather);
			}

		}
	}

	/**
	 * 功能菜单-返回当前节点下的所有子节点
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	private List<IndexRoleMenu> getIndexRoleMenuChild(List<Menu> listMenu,
			IndexRoleMenu indexRoleMenu) {
		List<IndexRoleMenu> listIndexRoleMenuChild = new ArrayList<>();
		for (Menu menu : listMenu) {
			IndexRoleMenu indexRoleMenuChild = new IndexRoleMenu();
			// 如果父节点等于当前ID
			if (menu.getParentId().equals(indexRoleMenu.getId())) {
				indexRoleMenuChild.setId(menu.getId());
				indexRoleMenuChild.setPid(menu.getParentId());
				indexRoleMenuChild.setName(menu.getName());
				indexRoleMenuChild.setOpenUrl(menu.getOpenUrl());
				listIndexRoleMenuChild.add(indexRoleMenuChild);
			}
		}
		return listIndexRoleMenuChild;

	}

	/**
	 * 功能菜单-是否存在子节点
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	private boolean hasChildNode(List<Menu> listMenu,
			IndexRoleMenu indexRoleMenu) {
		return getIndexRoleMenuChild(listMenu, indexRoleMenu).size() > 0;
	}

	/**
	 * 验证码生成
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:24
	 */
	@RequestMapping("getValidateCode")
	@ResponseBody
	public void getValidateCodeAction() {
		httpServletResponse.reset();
		// 禁止图像缓存。
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		String code = IceValidateCodeUtils.getValidateCode();
		ServletOutputStream servletOutputStream = null;
		try {
			servletOutputStream = httpServletResponse.getOutputStream();
			BufferedImage buffImg = IceValidateImage
					.getImageAsBufferedImage(code);
			ImageIO.write(buffImg, "png", servletOutputStream);
			servletOutputStream.flush();
			servletOutputStream.close();
			httpServletResponse.flushBuffer();
			httpSession.setAttribute("VALIDATECODE", code);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
