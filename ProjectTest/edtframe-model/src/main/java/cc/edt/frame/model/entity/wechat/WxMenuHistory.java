package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;

/**
 * 微信自定义菜单历史表实体
 *
 * @author 刘艳柔
 * @date 2017/12/20 8:41
 */
public class WxMenuHistory implements Serializable {

	private static final long serialVersionUID = -5785191576306087382L;
	private String id;
	private String accountId;
	private String menuId;
	private String name;
	private String type;
	private String typeName;
	private String key;
	private Integer rank;
	private String rankName;
	private Double order;
	private String pid;
	private String bakname;
	private String rankDisplay;
	private String accountName;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getOrder() {
		return order;
	}

	public void setOrder(Double order) {
		this.order = order;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getRankDisplay() {
		return rankDisplay;
	}

	public void setRankDisplay(String rankDisplay) {
		this.rankDisplay = rankDisplay;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getBakname() {
		return bakname;
	}

	public void setBakname(String bakname) {
		this.bakname = bakname;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
}
