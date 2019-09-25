package cc.edt.frame.model.entity.wechat;

import cc.edt.frame.model.entity.base.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 图文模板
 * 
 * @author 刘艳柔
 * @date 2018/4/3 14:20
 */
public class WxMpnewsTemplate implements Serializable {
	private static final long serialVersionUID = -5252405853535610687L;
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
	private User user;

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPathPreview() {
		return picPathPreview;
	}

	public void setPicPathPreview(String picPathPreview) {
		this.picPathPreview = picPathPreview;
	}
}
