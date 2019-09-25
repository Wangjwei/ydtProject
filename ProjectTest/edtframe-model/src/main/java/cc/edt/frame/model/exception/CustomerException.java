package cc.edt.frame.model.exception;

/**
 * 自定义异常信息
 * 
 * @author 刘钢
 * @date 2018/4/13 13:25
 */
public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = 6620963560235012681L;
	private String errorCode;
	private String errorMsg;

	public CustomerException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
