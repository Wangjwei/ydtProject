package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:33
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8764745528293684510L;
	private String id;
	private String mechanismsId;
	private String roleId;
	private String loginId;
	private String loginPassword;
	private String name;
	private Integer active;
	private String activeName;
	private Integer deleteFlag;
	private String addUser;
	private Date addTime;
	private Role role;
	private Mechanisms mechanisms;
	private String userMechanismsRights;
	private List<String> listMechanisms;
	private String roleName;
	private String mechanismsName;
	private String oldPassword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMechanismsId() {
		return mechanismsId;
	}

	public void setMechanismsId(String mechanismsId) {
		this.mechanismsId = mechanismsId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Mechanisms getMechanisms() {
		return mechanisms;
	}

	public void setMechanisms(Mechanisms mechanisms) {
		this.mechanisms = mechanisms;
	}

	public String getUserMechanismsRights() {
		return userMechanismsRights;
	}

	public void setUserMechanismsRights(String userMechanismsRights) {
		this.userMechanismsRights = userMechanismsRights;
	}

	public List<String> getListMechanisms() {
		return listMechanisms;
	}

	public void setListMechanisms(List<String> listMechanisms) {
		this.listMechanisms = listMechanisms;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMechanismsName() {
		return mechanismsName;
	}

	public void setMechanismsName(String mechanismsName) {
		this.mechanismsName = mechanismsName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@Override
	public String toString() {
		return "User{" + "id='" + id + '\'' + ", mechanismsId='" + mechanismsId
				+ '\'' + ", roleId='" + roleId + '\'' + ", loginId='" + loginId
				+ '\'' + ", loginPassword='" + loginPassword + '\'' + ", name='"
				+ name + '\'' + ", active=" + active + ", activeName='"
				+ activeName + '\'' + ", deleteFlag=" + deleteFlag
				+ ", addUser='" + addUser + '\'' + ", addTime=" + addTime
				+ ", role=" + role + ", mechanisms=" + mechanisms
				+ ", userMechanismsRights='" + userMechanismsRights + '\''
				+ ", listMechanisms=" + listMechanisms + ", roleName='"
				+ roleName + '\'' + ", mechanismsName='" + mechanismsName + '\''
				+ ", oldPassword='" + oldPassword + '\'' + '}';
	}
}
