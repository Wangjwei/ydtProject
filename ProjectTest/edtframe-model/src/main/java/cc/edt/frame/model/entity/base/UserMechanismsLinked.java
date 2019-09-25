package cc.edt.frame.model.entity.base;

import java.io.Serializable;

/**
 * 用户组织机构信息
 * 
 * @author 刘钢
 * @date 2017-07-06
 */
public class UserMechanismsLinked implements Serializable {

	private static final long serialVersionUID = -6135553015058755870L;
	private String userId;
	private String mechanismsId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMechanismsId() {
		return mechanismsId;
	}

	public void setMechanismsId(String mechanismsId) {
		this.mechanismsId = mechanismsId;
	}

	@Override
	public String toString() {
		return "UserMechanismsLinked{" + "userId='" + userId + '\''
				+ ", mechanismsId='" + mechanismsId + '\'' + '}';
	}
}
