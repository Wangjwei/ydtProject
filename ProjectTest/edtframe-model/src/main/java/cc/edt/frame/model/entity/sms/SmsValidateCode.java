package cc.edt.frame.model.entity.sms;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机验证码信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:33
 */
public class SmsValidateCode implements Serializable {

	private static final long serialVersionUID = 5382807679276245605L;
	private String id;
	private String phone;
	private String code;
	private Date validtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getValidtime() {
		return validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}
}
