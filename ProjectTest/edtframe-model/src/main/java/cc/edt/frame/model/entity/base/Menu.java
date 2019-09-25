package cc.edt.frame.model.entity.base;

import java.io.Serializable;

/**
 * 菜单信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:30
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 5023532722766811272L;
	private String id;
	private String name;
	private String openUrl;
	private String parentId;

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

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	@Override
	public String toString() {
		return "Menu{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", openUrl='" + openUrl + '\'' + ", parentId='" + parentId
				+ '\'' + '}';
	}
}
