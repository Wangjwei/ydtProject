package cc.edt.frame.model.result;

import java.io.Serializable;

/**
 * 微信普通素材上传结果
 *
 * @author 刘钢
 * @date 2018/3/8 10:45
 */
public class UploadMaterialResult implements Serializable {

	private static final long serialVersionUID = -8161277831028011600L;
	private boolean success;
	private String message;
	private String mediaId;
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
