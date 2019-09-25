package cc.edt.frame.model.entity.wechat;

import java.io.Serializable;

/**
 * 微信openid临时表实体
 *
 * @author 刘艳柔
 * @date 2017/12/20 8:41
 */
public class WxFansList implements Serializable {

	private static final long serialVersionUID = 1651774754020341797L;
	private String openId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
