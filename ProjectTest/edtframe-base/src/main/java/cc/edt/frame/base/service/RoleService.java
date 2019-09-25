package cc.edt.frame.base.service;

import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Role;
import cc.edt.frame.model.entity.base.RoleMenuLinked;
import cc.edt.frame.model.entity.base.RoleRightsLinked;
import cc.edt.frame.model.result.ActionResult;

import java.util.List;

/**
 * 权限信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:59
 */
public interface RoleService {
	/**
	 * 按照条件查询角色信息
	 *
	 * @param findCondition
	 *            findCondition
	 * @return java.util.List<com.edt.entity.Role>
	 * @author 刘钢
	 * @date 2017-05-18 11:46
	 */

	List<Role> listRoleByCondition(FindCondition findCondition);
	/**
	 * 根据角色ID查询角色信息
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Role
	 * @author 刘钢
	 * @date 2017-05-18 11:46
	 */

	Role getRoleById(String id);

	/**
	 * 根据角色id查询权限集合
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Role
	 * @author 刘钢 2017-05-18 11:47
	 */

	Role getRoleByIdForRights(String id);
	/**
	 * 根据角色id查询菜单集合
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Role
	 * @author 刘钢 2017-05-18 11:47
	 */

	Role getRoleByIdForMenu(String id);
}
