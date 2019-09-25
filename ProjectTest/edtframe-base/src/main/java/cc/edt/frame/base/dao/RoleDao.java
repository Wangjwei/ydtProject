package cc.edt.frame.base.dao;

import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Role;
import cc.edt.frame.model.entity.base.RoleMenuLinked;
import cc.edt.frame.model.entity.base.RoleRightsLinked;

import java.util.List;

/**
 * 角色信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:28
 */
public interface RoleDao {

	/**
	 * 按照条件查询所有角色
	 *
	 * @param condition
	 *            condition
	 * @return List<Role>
	 * @author 刘钢
	 * @date 2017/5/17 22:48
	 */
	List<Role> listRoleByCondition(FindCondition condition);

	/**
	 * 根据角色ID查询角色信息
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Role
	 * @author 刘钢
	 * @date 2017/5/17 22:48
	 */
	Role getRoleById(String id);

	/**
	 * 根据角色id查询权限集合
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Role
	 * @author 刘钢
	 * @date 2017/5/17 22:49
	 */
	Role getRoleByIdForRights(String id);
	/**
	 * 根据角色id查询菜单集合
	 *
	 * @param id
	 *            di
	 * @return com.edt.entity.Role
	 * @author 刘钢
	 * @date 2017/5/17 22:49
	 */
	Role getRoleByIdForMenu(String id);
}
