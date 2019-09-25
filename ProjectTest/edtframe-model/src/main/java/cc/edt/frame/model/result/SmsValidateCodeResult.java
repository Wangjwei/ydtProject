package cc.edt.frame.model.result;

/**
 * 短信验证码返回
 *
 * @author 刘钢
 * @date 2017/12/18 11:09
 */
public class SmsValidateCodeResult {
	private Boolean success;
	private String message;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
