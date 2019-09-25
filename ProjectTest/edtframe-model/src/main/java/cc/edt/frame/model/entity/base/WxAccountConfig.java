package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信账号配置表实体
 *
 * @author 刘艳柔
 * @date 2017/12/20 8:41
 */
public class WxAccountConfig implements Serializable {

	private static final long serialVersionUID = -3859869149908451286L;
	private String id;
	private String mechanismsId;
	private String mechanismsName;
	private String originalId;
	private String appId;
	private String appSecret;
	private String shopId;
	private String shopKey;
	private String certificatePath;
	private String token;
	private String tokenFlag;
	private String name;
	private Integer type;
	private String addUser;
	private Date addTime;
	private String typeDisplay;
	private String userName;
	private Mechanisms mechanisms;
	private String picPath;
	/**
	 * 历史图片路径
	 */
	private String oldPicPath;
	/**
	 * 历史证书路径
	 */
	private String oldCertPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeDisplay() {
		return typeDisplay;
	}

	public void setTypeDisplay(String typeDisplay) {
		this.typeDisplay = typeDisplay;
	}

	public String getOriginalId() {
		return originalId;
	}

	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenFlag() {
		return tokenFlag;
	}

	public void setTokenFlag(String tokenFlag) {
		this.tokenFlag = tokenFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopKey() {
		return shopKey;
	}

	public void setShopKey(String shopKey) {
		this.shopKey = shopKey;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}

	public String getMechanismsId() {
		return mechanismsId;
	}

	public void setMechanismsId(String mechanismsId) {
		this.mechanismsId = mechanismsId;
	}

	public String getMechanismsName() {
		return mechanismsName;
	}

	public void setMechanismsName(String mechanismsName) {
		this.mechanismsName = mechanismsName;
	}

	public Mechanisms getMechanisms() {
		return mechanisms;
	}

	public void setMechanisms(Mechanisms mechanisms) {
		this.mechanisms = mechanisms;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getOldPicPath() {
		return oldPicPath;
	}

	public void setOldPicPath(String oldPicPath) {
		this.oldPicPath = oldPicPath;
	}

	public String getOldCertPath() {
		return oldCertPath;
	}

	public void setOldCertPath(String oldCertPath) {
		this.oldCertPath = oldCertPath;
	}
}
