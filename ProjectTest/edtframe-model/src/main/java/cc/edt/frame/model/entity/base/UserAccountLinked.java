package cc.edt.frame.model.entity.base;


import java.io.Serializable;

/**
 * 用户微信关联表实体
 *
 * @author 刘艳柔
 * @date 2017/12/20 8:41
 */
public class UserAccountLinked implements Serializable {

	private static final long serialVersionUID = -4380345556645541027L;
	private User user;
	private WxAccountConfig wxAccount;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WxAccountConfig getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(WxAccountConfig wxAccount) {
		this.wxAccount = wxAccount;
	}

}
