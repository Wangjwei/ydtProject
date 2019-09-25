package cc.edt.frame.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;

/**
 * 基础controller，需要所有controller继承
 *
 * @author 刘钢
 * @date 2017/12/18 10:37
 */
@Controller
@RequestMapping("/")
public class CommonController extends BaseController {


	/**
	 * 页面跳转公共controller
	 *
	 * @author 刘钢
	 * @date 2017/12/18 11:24
	 */
	@RequestMapping("redirect")
	public String redirect() {
		return httpServletRequest.getParameter("page");
	}

	/**
	 * session超时处理页
	 *
	 * @author 刘钢
	 * @date 2017/12/18 11:24
	 */
	@RequestMapping("timeout")
	public String timeout() {
		try {
			// 如果是ajax请求响应头会有，x-requested-with
			if (httpServletRequest.getHeader("x-requested-with") != null
					&& "XMLHttpRequest".equalsIgnoreCase(
							httpServletRequest.getHeader("x-requested-with"))) {
				// 在响应头设置session状态
				httpServletResponse.setHeader("sessionstatus", "timeout");
				httpServletResponse.setContentType("text/html;charset=utf-8");
				String str = "{\"success\":false,\"message\":\"用户登陆超时,请重新登录\"}";
				PrintWriter writer = httpServletResponse.getWriter();
				writer.write(str);
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "timeout";
	}

	/**
	 * 获取UE后台配置的config.json配置
	 *
	 * @author 刘钢
	 * @date 2017/12/18 11:24
	 */
	@RequestMapping("/getUEConfig")
	@ResponseBody
	public void config() {
		httpServletResponse.setContentType("application/json");
		String rootPath = httpServletRequest.getSession().getServletContext()
				.getRealPath("/");
		String exec = new ActionEnter(httpServletRequest, rootPath).exec();
		writerToPageByString(exec);
	}

	@RequestMapping("ue")
	public String ue() {
		return "ueditor";
	}
}
