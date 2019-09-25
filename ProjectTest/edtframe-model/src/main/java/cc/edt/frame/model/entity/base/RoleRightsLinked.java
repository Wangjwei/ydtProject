package cc.edt.frame.model.entity.base;

import java.io.Serializable;

/**
 * 角色权限信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:33
 */
public class RoleRightsLinked implements Serializable {

	private static final long serialVersionUID = -6656506076247277659L;
	private Rights rights;
	private Role role;

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleRightsLinked{" + "rights=" + rights + ", role=" + role
				+ '}';
	}
}
