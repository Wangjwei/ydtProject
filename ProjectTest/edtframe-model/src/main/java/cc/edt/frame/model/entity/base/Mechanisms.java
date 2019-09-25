package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:30
 */
public class Mechanisms implements Serializable {
	private static final long serialVersionUID = -144190076622140757L;
	private String id;
	private String parentId;
	private String name;
	private String code;
	private String linkName;
	private String linkPhone;
	private String addressInfo;
	private String phone;
	private String parentName;
	private String remark;
	private String addUser;
	private Date addTime;
	private User user;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Mechanisms{" + "id='" + id + '\'' + ", parentId='" + parentId
				+ '\'' + ", name='" + name + '\'' + ", code='" + code + '\''
				+ ", linkName='" + linkName + '\'' + ", linkPhone='" + linkPhone
				+ '\'' + ", addressInfo='" + addressInfo + '\'' + ", phone='"
				+ phone + '\'' + ", parentName='" + parentName + '\''
				+ ", remark='" + remark + '\'' + ", addUser='" + addUser + '\''
				+ ", addTime=" + addTime + ", user=" + user + '}';
	}
}
