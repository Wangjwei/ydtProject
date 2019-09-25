package cc.edt.frame.base.service;

import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.SystemLog;

import java.util.List;

/**
 * 系统日志接口
 * 
 * @author 奚艺轩
 * @date 2018/6/12 15:46
 */
public interface SystemLogService {

	/**
	 * 保存
	 * 
	 * @param systemLog
	 *            systemLog
	 * @author 刘钢
	 * @date 2018/6/21 10:55
	 */
	void saveSystemLog(SystemLog systemLog);

	/**
	 * 根据条件查询系统日志
	 *
	 * @param condition
	 *            condition
	 * @return java.util.List<cc.edt.iceframe5.model.entity.base.SystemLog>
	 * @author 奚艺轩
	 * @date 2018/6/12 15:30
	 */
	List<SystemLog> listSystemLogByCondition(FindCondition condition);
}
