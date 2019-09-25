package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:29
 */
public class SystemLog implements Serializable {
	private static final long serialVersionUID = 8370877976213359128L;
	private String id;
	private String operationType;
	private String operationName;
	private String userId;
	private String content;
	private Date addTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SystemLog{" + "id='" + id + '\'' + ", operationType='"
				+ operationType + '\'' + ", operationName='" + operationName
				+ '\'' + ", userId='" + userId + '\'' + ", content='" + content
				+ '\'' + ", addTime=" + addTime + '}';
	}
}
