package cc.edt.frame.model.result;

import java.io.Serializable;

/**
 * 前台页面返回结果类
 *
 * @author 刘钢
 * @date 2017/12/18 11:00
 */
public class ActionResult implements Serializable {

	private static final long serialVersionUID = 7271810509315302832L;
	private boolean success;
	private Integer code;
	private String message;
	private Object resultList;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResultList() {
		return resultList;
	}

	public void setResultList(Object resultList) {
		this.resultList = resultList;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ActionResult{" + "success=" + success + ", code='" + code + '\''
				+ ", message='" + message + '\'' + ", resultList=" + resultList
				+ '}';
	}
}
