package cc.edt.frame.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 默认拦截器
 * 
 * @author 刘钢
 * @date 2017/12/18 13:34
 */
public class DefaultInterceptor implements HandlerInterceptor {
	@Resource
	private HttpSession httpSession;
	@Resource
	private HttpServletResponse httpServletResponse;
	@Resource
	private HttpServletRequest httpServletRequest;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		return true;
	}
}
