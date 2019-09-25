package cc.edt.frame.base.dao;


import cc.edt.frame.model.entity.base.Menu;

import java.util.List;

/**
 * 菜单信息
 * 
 * @author 刘钢
 * @date 2018/1/12 13:36
 */
public interface MenuDao {
	/**
	 * 查询所有的菜单
	 *
	 * @return List<Menu>
	 * @author 刘钢
	 * @date 2017/5/17 22:43
	 */
	List<Menu> listMenu();

	/**
	 * 保存菜单
	 *
	 * @param menu
	 *            menu
	 * @author 刘钢
	 * @date 2017/5/17 22:43
	 */
	void saveMenu(Menu menu);

	/**
	 * 删除所有菜单
	 *
	 * @author 刘钢
	 * @date 2017/5/17 22:43
	 */
	void deleteAllMenu();
}
