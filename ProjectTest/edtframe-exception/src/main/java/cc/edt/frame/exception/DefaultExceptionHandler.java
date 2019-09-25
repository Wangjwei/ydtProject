package cc.edt.frame.exception;

import cc.edt.frame.common.constant.CommonConstant;
import cc.edt.frame.common.constant.DictionaryConstant;
import cc.edt.frame.model.exception.CustomerException;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.json.IceJsonUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常处理
 *
 * @author 刘钢
 * @date 2017/12/18 13:34
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		if (ex instanceof DataIntegrityViolationException) {
			return processException(request, response, "操作失败，违反数据约束");
		}
		if (ex instanceof CustomerException) {
			return processException(request, response,
					((CustomerException) ex).getErrorCode() + "，"
							+ ((CustomerException) ex).getErrorMsg());
		}
		return processException(request, response,
				DictionaryConstant.ERROR_MSG);
	}

	private ModelAndView processException(HttpServletRequest request,
			HttpServletResponse response, String msg) {
		ActionResult actionResult = new ActionResult();
		// 不是ajax请求，直接返回错误页面
		if (!(request.getHeader("accept").contains("application/json")
				|| (request.getHeader("X-Requested-With") != null
						&& request.getHeader("X-Requested-With")
								.contains("XMLHttpRequest")))) {
			return new ModelAndView("error");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			actionResult.setSuccess(false);
			actionResult.setMessage(msg);
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.write(IceJsonUtils.toJsonString(actionResult));
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("error");
	}
}
