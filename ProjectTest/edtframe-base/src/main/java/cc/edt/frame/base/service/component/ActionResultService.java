package cc.edt.frame.base.service.component;

import cc.edt.frame.model.result.ActionResult;
import org.springframework.stereotype.Component;

/**
 * 前台页面结果
 *
 * @author 刘钢
 * @date 2017/12/18 11:19
 */
@Component
public class ActionResultService {

	/**
	 * 封装统一前台页面返回
	 *
	 * @param success
	 *            success
	 * @param msg
	 *            msg
	 * @param resultList
	 *            resultList
	 * @param code
	 *            code
	 * @return com.edt.common.bean.ActionResult
	 * @author 刘钢
	 * @date 2017-08-07 8:47
	 */

	public ActionResult callBackResult(boolean success, String msg,
			Object resultList, Integer code) {
		ActionResult actionResult = new ActionResult();
		actionResult.setSuccess(success);
		actionResult.setMessage(msg);
		actionResult.setCode(code);
		actionResult.setResultList(resultList);
		return actionResult;
	}

	/**
	 * 封装统一前台页面返回
	 *
	 * @param success
	 *            success
	 * @param msg
	 *            msg
	 * @return cc.edt.iceframe5.base.common.result.ActionResult
	 * @author 刘钢
	 * @date 2018/3/15 11:27
	 */
	public ActionResult callBackResult(boolean success, String msg) {
		return callBackResult(success, msg, null, 0);
	}

	/**
	 * 封装统一前台页面返回
	 *
	 * @param success
	 *            success
	 * @return cc.edt.iceframe5.base.common.result.ActionResult
	 * @author 刘钢
	 * @date 2018/3/15 11:27
	 */
	public ActionResult callBackResult(boolean success) {
		return callBackResult(success, null, null, 0);
	}
}
