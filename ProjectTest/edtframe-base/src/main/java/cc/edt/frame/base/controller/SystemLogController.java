package cc.edt.frame.base.controller;


import cc.edt.frame.base.service.SystemLogService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统日志控制器
 * 
 * @author 奚艺轩
 * @date 2018/6/12 15:25
 */
@Controller
@RequestMapping("/systemLog")
public class SystemLogController extends BaseController {
	@Resource
	private SystemLogService systemLogService;

	/**
	 * 根据条件查询系统日志
	 * 
	 * @param condition
	 *            condition
	 * @author 奚艺轩
	 * @date 2018/6/12 15:51
	 */
	@RequestMapping("listSystemLogByCondition")
	@ResponseBody
	public void listSystemLogByCondition(FindCondition condition) {
		condition.setRows(condition.getLength());
		condition.setPage(condition.getStart() / condition.getLength() + 1);
		List<SystemLog> listSystemLog = systemLogService
				.listSystemLogByCondition(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("draw", condition.getDraw());
		map.put("recordsTotal", condition.getTotalRows());
		map.put("recordsFiltered", condition.getTotalRows());
		map.put("data", listSystemLog);
		writerToPageByJson(map);
	}

}
