package cc.edt.frame.base.service;

import java.util.List;

import cc.edt.frame.model.entity.base.Menu;

/**
 * 菜单信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:54
 */
public interface MenuService {

	/**
	 * 查询所有的菜单
	 *
	 * @return List<Menu>
	 * @author 刘钢
	 * @date 2017-05-18 11:42
	 */

	List<Menu> listMenu();

	/**
	 * 保存菜单
	 *
	 * @param menu
	 *            menu
	 * @author 刘钢
	 * @date 2017-05-18 11:42
	 */

	void saveMenu(Menu menu);

	/**
	 * 删除所有菜单
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:42
	 */

	void deleteAllMenu();

}
