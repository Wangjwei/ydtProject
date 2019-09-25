package cc.edt.frame.base.controller;

import cc.edt.frame.base.service.RightsService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.entity.base.Rights;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限信息
 *
 * @author 刘钢
 * @date 2017/12/18 11:59
 */
@Controller
@RequestMapping("/rights")
public class RightsController extends BaseController {

	@Resource
	private RightsService rightsService;

	/**
	 * 获取所有权限
	 *
	 * @author 奚艺轩
	 * @date 2017/12/18 11:59
	 */
	@RequestMapping("getAllRights")
	@ResponseBody
	public void getAllRights() {
		List<Rights> listRights = rightsService.listRights();
		writerToPageByJson(listRights);
	}
}
