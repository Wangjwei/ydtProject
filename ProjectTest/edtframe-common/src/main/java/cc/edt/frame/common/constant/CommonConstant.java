package cc.edt.frame.common.constant;

import java.io.Serializable;

/**
 * 系统常量
 *
 * @author 刘钢
 * @date 2017/12/18 11:09
 */
public final class CommonConstant implements Serializable {

	public static final long serialVersionUID = -7828091876232562024L;
	public final static String DATEFORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public final static String DATEFORMAT_YYYY_MM = "yyyy-MM";
	public final static String DATEFORMAT_YYYY = "yyyy";
	/**
	 * 一分钟秒数
	 */
	public final static int ONE_MINUTE_SECOND = 60;
	/**
	 * 一小时秒数
	 */
	public final static int ONE_HOUR_SECOND = 3600;
	/**
	 * 前台返回-成功
	 */
	public final static boolean ACTIONRESULT_TRUE = true;
	/**
	 * 前台返回-失败
	 */
	public final static boolean ACTIONRESULT_FAIL = false;
	/**
	 * 短信验证码超时时间
	 */
	public final static int VERIFICATION_CODE = 180;

}
