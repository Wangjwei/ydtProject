package cc.edt.frame.base.dao;


import cc.edt.frame.model.entity.base.Rights;

import java.util.List;

/**
 * 权限信息
 * 
 * @author 刘钢
 * @date 2017/12/18 13:28
 */
public interface RightsDao {
	/**
	 * 获取所有权限
	 *
	 * @return java.util.List<com.edt.entity.Rights>
	 * @author 刘钢
	 * @date 2017/5/17 22:47
	 */
	List<Rights> listRights();

	/**
	 * 保存权限信息
	 *
	 * @param rights
	 *            rights
	 * @author 刘钢
	 * @date 2017/5/17 22:47
	 */
	void saveRights(Rights rights);

	/**
	 * 删除所有权限
	 *
	 * @author 刘钢
	 * @date 2017/5/17 22:47
	 */
	void deleteAllRights();
}
