package cc.edt.frame.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author 刘钢
 * @date 2018/4/19 15:12
 */
public class ParamsFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 只是我们自己写的param参数去除空格并写回的类
		ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(
				request);
		filterChain.doFilter(requestWrapper, response);
	}
}
