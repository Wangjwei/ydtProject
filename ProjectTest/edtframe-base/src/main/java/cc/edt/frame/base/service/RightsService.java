package cc.edt.frame.base.service;

import cc.edt.frame.model.entity.base.Rights;

import java.util.List;

/**
 * 权限信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:59
 */
public interface RightsService {

	/**
	 * 获取所有权限
	 *
	 * @return java.util.List<com.edt.entity.Rights>
	 * @author 刘钢
	 * @date 2017-05-18 11:46
	 */

	List<Rights> listRights();

	/**
	 * 保存权限信息
	 *
	 * @param rights
	 *            rights
	 * @author 刘钢
	 * @date 2017-05-18 11:46
	 */

	void saveRights(Rights rights);

	/**
	 * 删除所有权限
	 *
	 * @author 刘钢
	 * @date 2017-05-18 11:46
	 */

	void deleteAllRights();
}
