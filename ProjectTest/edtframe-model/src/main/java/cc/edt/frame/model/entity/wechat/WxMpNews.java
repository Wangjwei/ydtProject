package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信图文素材
 *
 * @author 刘艳柔
 * @date 2018/4/3 15:58
 */
public class WxMpNews implements Serializable {

	private static final long serialVersionUID = 8892797038109552094L;
	private String id;
	private String title;
	private String author;
	private String digest;
	private String content;
	private String contentSourceUrl;
	private String picPath;
	private String picPathPreview;
	private String addUser;
	private String addUserName;
	private Date addTime;
	private String accountId;
	private String accountName;
	private String type;
	private String typeName;
	private String orderBy;
	private String thumbnailId;
	private String[] accountIds;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String[] getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(String[] accountIds) {
		this.accountIds = accountIds;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getPicPathPreview() {
		return picPathPreview;
	}

	public void setPicPathPreview(String picPathPreview) {
		this.picPathPreview = picPathPreview;
	}

	public String getThumbnailId() {
		return thumbnailId;
	}

	public void setThumbnailId(String thumbnailId) {
		this.thumbnailId = thumbnailId;
	}
}
