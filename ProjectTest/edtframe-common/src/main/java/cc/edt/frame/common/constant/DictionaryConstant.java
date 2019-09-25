package cc.edt.frame.common.constant;

import java.io.Serializable;

/**
 * 数据字典常量
 *
 * @author 刘钢
 * @date 2018/6/2111:22
 */
public final class DictionaryConstant implements Serializable {

	private static final long serialVersionUID = 2853620539285810507L;
	/**
	 * 文件上传磁盘路径
	 */
	public final static String UPLOAD_PATH_DISK = StaticDictionary.configMap
			.get("upload.path.disk") + "/";
	/**
	 * 批量保存单次数量
	 */
	public final static String SAVE_BATCH = StaticDictionary.configMap
			.get("save.batch");
	/**
	 * 批量修改单次数量
	 */
	public final static String UPDATE_BATCH = StaticDictionary.configMap
			.get("update.batch");
	/**
	 * 批量删除单次数量
	 */
	public final static String DELETE_BATCH = StaticDictionary.configMap
			.get("delete.batch");
	/**
	 * 资源文件访问路径
	 */
	public final static String UPLOAD_PATH_WEB = StaticDictionary.configMap
			.get("upload.path.web") + "/";
	/**
	 * 错误信息
	 */
	public final static String ERROR_MSG = StaticDictionary.configMap
			.get("error.msg");
	/**
	 * 线程可拉取最大粉丝数
	 */
	public final static String FANS_THREAD_NUM = StaticDictionary.configMap
			.get("fans.thread.num");
	/**
	 * 前台项目web根路径
	 */
	public final static String PROJECT_REAL_PATH_WEB = StaticDictionary.configMap
			.get("project.real.path.web") + "/";
	/**
	 * 后台项目web根路径
	 */
	public final static String PROJECT_REAL_PATH_ADMIN = StaticDictionary.configMap
			.get("project.real.path.admin") + "/";
}
