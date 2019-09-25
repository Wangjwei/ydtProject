package cc.edt.frame.interceptor;


import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.edt.frame.common.annotation.FormToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cc.edt.iceutils2.random.IceRandomUtils;

/**
 * 表单是否重复提交拦截器
 *
 * @author 刘钢
 * @date 2017/12/18 13:35
 */
public class FormTokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			FormToken annotation = method.getAnnotation(FormToken.class);
			if (annotation != null) {
				boolean needSaveSession = annotation.save();
				if (needSaveSession) {
					request.getSession().setAttribute("TOKEN",
							IceRandomUtils.longUUID());
				}
				boolean needRemoveSession = annotation.remove();
				if (needRemoveSession) {
					if (isRepeatSubmit(request)) {
						if (((HttpServletRequest) request)
								.getHeader("x-requested-with") != null
								&& "XMLHttpRequest".equalsIgnoreCase(
										((HttpServletRequest) request)
												.getHeader(
														"x-requested-with"))) {
							((ServletResponse) response)
									.setContentType("text/html;charset=utf-8");
							String str = "{\"success\":false,\"message\":\"表单已经提交，请不要重复提交\"}";
							PrintWriter writer = ((ServletResponse) response)
									.getWriter();
							writer.write(str);
							writer.flush();
							writer.close();
						}
						return false;
					}
				}
			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = (String) request.getSession(false)
				.getAttribute("TOKEN");
		if (serverToken == null) {
			return true;
		}
		String clinetToken = request.getParameter("token");
		return clinetToken == null || !serverToken.equals(clinetToken);
	}
}
