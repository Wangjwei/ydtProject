package cc.edt.frame.model.entity.base;

import java.io.Serializable;

/**
 * 角色菜单信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:32
 */
public class RoleMenuLinked implements Serializable {
	private static final long serialVersionUID = -7882381883582590212L;
	private Role role;
	private Menu menu;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "RoleMenuLinked{" + "role=" + role + ", menu=" + menu + '}';
	}
}
