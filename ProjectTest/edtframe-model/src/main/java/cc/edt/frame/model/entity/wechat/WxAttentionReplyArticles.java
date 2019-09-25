package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注回复图文
 * 
 * @author 刘钢
 * @date 2018/3/8 14:51
 */
public class WxAttentionReplyArticles implements Serializable {
	private static final long serialVersionUID = 1557445251498442083L;
	private String id;
	private String title;
	private String digest;
	private String picUrl;
	private String url;
	private String accountId;
	private String accountName;
	private String addUser;
	private String addUserName;
	private Date addTime;
	private Integer orderBy;
	private String[] accountSelectId;
	private String thumbnailId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
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

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public String[] getAccountSelectId() {
		return accountSelectId;
	}

	public void setAccountSelectId(String[] accountSelectId) {
		this.accountSelectId = accountSelectId;
	}

	public String getThumbnailId() {
		return thumbnailId;
	}

	public void setThumbnailId(String thumbnailId) {
		this.thumbnailId = thumbnailId;
	}
}
