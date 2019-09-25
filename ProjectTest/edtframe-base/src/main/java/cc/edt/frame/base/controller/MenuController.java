package cc.edt.frame.base.controller;


import cc.edt.frame.base.service.MenuService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.entity.base.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能菜单
 *
 * @author 刘钢
 * @date 2017/12/18 14:17
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Resource
	private MenuService menuService;

	/**
	 * 查询所有的菜单
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:56
	 */
	@RequestMapping("getListMenu")
	@ResponseBody
	public void getAllMenu() {
		List<Menu> listMenu = menuService.listMenu();
		writerToPageByJson(listMenu);
	}

}
