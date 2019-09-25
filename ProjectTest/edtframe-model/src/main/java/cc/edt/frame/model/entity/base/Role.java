package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:31
 */
public class Role implements Serializable {
	private static final long serialVersionUID = -2505372373474014298L;
	private String id;
	private String name;
	private String reMark;
	private String addUser;
	private Date addTime;
	private List<User> listUser = new ArrayList<>();
	private List<Menu> listMenu = new ArrayList<>();
	private List<Rights> listRights = new ArrayList<>();

	private String menuId;
	private String rightsId;
	private String addUserDisplay;

	public List<User> getListUser() {
		return listUser;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getRightsId() {
		return rightsId;
	}

	public void setRightsId(String rightsId) {
		this.rightsId = rightsId;
	}

	public List<Menu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
	}

	public List<Rights> getListRights() {
		return listRights;
	}

	public void setListRights(List<Rights> listRights) {
		this.listRights = listRights;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark = reMark;
	}

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getAddUserDisplay() {
		return addUserDisplay;
	}

	public void setAddUserDisplay(String addUserDisplay) {
		this.addUserDisplay = addUserDisplay;
	}
}
