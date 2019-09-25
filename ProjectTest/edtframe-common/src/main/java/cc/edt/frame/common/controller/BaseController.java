package cc.edt.frame.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import cc.edt.iceutils2.json.IceJsonUtils;
import org.springframework.stereotype.Controller;

/**
 * 基础controller
 *
 * @author 刘钢
 * @date 2017/12/18 15:15
 */
@Controller
public class BaseController {
	@Resource
	protected HttpSession httpSession;
	@Resource
	protected HttpServletResponse httpServletResponse;
	@Resource
	protected HttpServletRequest httpServletRequest;

	/**
	 * 转换成JSON字符串回写到页面
	 *
	 * @param object
	 *            object
	 * @author 刘钢
	 * @date 2017-05-18 11:28
	 */

	public void writerToPageByJson(Object object) {
		writerToPageByString(toJsonString(object));
	}

	/**
	 * 转换成JSON字符串回写到页面
	 *
	 * @param object
	 *            object
	 * @param dateformate
	 *            dateformate
	 * @author 刘钢
	 * @date 2017-05-18 11:29
	 */

	public void writerToPageByJson(Object object, String dateformate) {
		writerToPageByString(toJsonString(object, dateformate));
	}

	/**
	 * 转换成JSON字符串回写到页面,不打印null属性
	 *
	 * @param object
	 *            object
	 * @author 刘钢
	 * @date 2017-05-18 11:29
	 */

	public void writerToPageByJsonNoNull(Object object) {
		writerToPageByString(toJsonStringNoNull(object));
	}

	/**
	 * 转换成JSON字符串回写到页面,不打印null属性
	 *
	 * @param object
	 *            object
	 * @param dateformate
	 *            dateformate
	 * @author 刘钢
	 * @date 2017-05-18 11:29
	 */

	public void writerToPageByJsonNoNull(Object object, String dateformate) {
		writerToPageByString(toJsonStringNoNull(object, dateformate));
	}

	/**
	 * 根据属性过滤器，转换成JSON字符串回写到页面
	 *
	 * @param object
	 *            object
	 * @param filter
	 *            filter
	 * @param dateformate
	 *            dateformate
	 * @author 刘钢
	 * @date 2017-05-18 11:29
	 */

	public void writerToPageByJsonByFilter(Object object,
			SimplePropertyPreFilter filter, String dateformate) {
		writerToPageByString(toJsonStringByFilter(object, filter, dateformate));
	}

	/**
	 * 根据属性过滤器，转换成JSON字符串回写到页面
	 *
	 * @param object
	 *            object
	 * @param filter
	 *            filter
	 * @author 刘钢
	 * @date 2017-05-18 11:30
	 */

	public void writerToPageByJsonByFilter(Object object,
			SimplePropertyPreFilter filter) {
		writerToPageByString(toJsonStringByFilter(object, filter));
	}

	/**
	 * 根据属性过滤器，转换成JSON字符串回写到页面
	 *
	 * @param object
	 *            object
	 * @author 刘钢
	 * @date 2017-05-18 11:30
	 */

	public void writerToPageByJsonByFilter(Object object) {
		writerToPageByString(toJsonStringNoNull(object));
	}

	/**
	 * 根据属性过滤器，转换成JSON字符串回写到页面,不显示null属性
	 *
	 * @param object
	 *            object
	 * @param filter
	 *            filter
	 * @author 刘钢
	 * @date 2017-05-18 11:30
	 */

	public void writerToPageByJsonByFilterNoNull(Object object,
			SimplePropertyPreFilter filter) {
		writerToPageByString(toJsonStringByFilter(object, filter));
	}

	/**
	 * 将字符串回写到页面
	 *
	 * @param str
	 *            str
	 * @author 刘钢
	 * @date 2017-05-18 11:31
	 */

	public void writerToPageByString(String str) {
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		try (PrintWriter writer = httpServletResponse.getWriter()) {
			writer.write(str);
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * JSON字符串处理
	 *
	 */
	private String toJsonString(Object object) {
		return IceJsonUtils.toJsonString(object);
	}

	private String toJsonString(Object object, String dateFormate) {
		return IceJsonUtils.toJsonString(object, dateFormate);
	}

	private String toJsonStringNoNull(Object object) {
		return IceJsonUtils.toJsonStringNoNull(object);
	}

	private String toJsonStringNoNull(Object object, String dateFormate) {
		return IceJsonUtils.toJsonStringNoNull(object, dateFormate);
	}

	private String toJsonStringByFilter(Object object,
			SimplePropertyPreFilter filter) {
		return IceJsonUtils.toJsonStringByFilter(object, filter);
	}

	private String toJsonStringByFilter(Object object,
			SimplePropertyPreFilter filter, String dateFormate) {
		return IceJsonUtils.toJsonStringByFilter(object, filter, dateFormate);
	}
}
