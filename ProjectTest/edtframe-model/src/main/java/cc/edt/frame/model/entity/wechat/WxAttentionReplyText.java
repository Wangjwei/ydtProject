package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注回复文本
 * 
 * @author 刘钢
 * @date 2018/4/8 10:29
 */
public class WxAttentionReplyText implements Serializable {
	private static final long serialVersionUID = 1251341466980595660L;
	private String id;
	private String content;
	private String accountId;
	private String addUser;
	private Date addTime;
	private String states;
	private String accountName;
	private String showStates;
	private String[] accountIds;
	private String addUserName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getShowStates() {
		return showStates;
	}

	public void setShowStates(String showStates) {
		this.showStates = showStates;
	}

	public String[] getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(String[] accountIds) {
		this.accountIds = accountIds;
	}

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
}
