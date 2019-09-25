package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;

/**
 * 关键字回复
 * 
 * @author 刘钢
 * @date 2018/4/25 9:21
 */
public class WxMessageKey implements Serializable {

	private static final long serialVersionUID = -1198317506443771712L;

	private String id;
	private String content;
	private String accountId;
	private int type;
	private String mpId;
	private String keyValue;
	private String code;
	private String menuName;
	private String[] mpIds;
	private WxMpNews wxMpNews;
	private String accountName;
	private String title;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMpId() {
		return mpId;
	}

	public void setMpId(String mpId) {
		this.mpId = mpId;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public WxMpNews getWxMpNews() {
		return wxMpNews;
	}

	public void setWxMpNews(WxMpNews wxMpNews) {
		this.wxMpNews = wxMpNews;
	}

	public String[] getMpIds() {
		return mpIds;
	}

	public void setMpIds(String[] mpIds) {
		this.mpIds = mpIds;
	}
}
