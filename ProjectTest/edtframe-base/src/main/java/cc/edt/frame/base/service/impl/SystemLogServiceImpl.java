package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.SystemLogDao;
import cc.edt.frame.base.service.SystemLogService;
import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.SystemLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统日志
 * 
 * @author 奚艺轩
 * @date 2018/6/12 15:46
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {
	@Resource
	private SystemLogDao systemLogDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveSystemLog(SystemLog systemLog) {
		systemLogDao.saveSystemLog(systemLog);
	}

	@Override
	public List<SystemLog> listSystemLogByCondition(FindCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getRows());
		List<SystemLog> listSystemLog = systemLogDao
				.listSystemLogByCondition(condition);
		PageInfo<SystemLog> pageInfo = new PageInfo<>(listSystemLog);
		condition.setTotalRows(pageInfo.getTotal());
		return listSystemLog;
	}
}
