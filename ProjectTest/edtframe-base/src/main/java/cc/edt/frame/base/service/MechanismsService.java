package cc.edt.frame.base.service;

import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Mechanisms;
import cc.edt.frame.model.result.ActionResult;

import java.util.List;

/**
 * 组织机构信息
 *
 * @author 刘钢
 * @date 2017/12/18 13:54
 */
public interface MechanismsService {
	/**
	 * 保存机构信息
	 *
	 * @param mechanisms
	 *            mechanisms
	 * @return com.edt.common.bean.ActionResult
	 * @author 刘钢 2017-05-18 9:22
	 */

	ActionResult saveMechanisms(Mechanisms mechanisms);

	/**
	 * 初始化保存机构根
	 *
	 * @param mechanisms
	 *            mechanisms
	 * @author 刘钢 2017-05-18 9:22
	 */

	void saveMechanismsForInit(Mechanisms mechanisms);

	/**
	 * 修改机构信息
	 *
	 * @param mechanisms
	 *            mechanisms
	 * @return com.edt.common.bean.ActionResult
	 * @author 刘钢 2017-05-18 9:22
	 */

	ActionResult updateMechanisms(Mechanisms mechanisms);

	/**
	 * 删除机构信息
	 *
	 * @param id
	 *            id
	 * @return com.edt.common.bean.ActionResult
	 * @author 刘钢 2017-05-18 9:22
	 */

	ActionResult deleteMechanisms(String id);

	/**
	 * 根据机构名称查询机构信息
	 *
	 * @param name
	 *            name
	 * @return com.edt.entity.Mechanisms
	 * @author 刘钢 2017-05-18 9:23
	 */

	Mechanisms getMechanismsByName(String name);

	/**
	 * 分页查询组织机构
	 *
	 * @param findCondition
	 *            findCondition
	 * @return java.util.List<com.edt.entity.Mechanisms>
	 * @author 刘钢 2017-05-18 9:23
	 */

	List<Mechanisms> listMechanismByCondition(FindCondition findCondition);

	/**
	 * 根据组织机构ID查询机构信息
	 *
	 * @param id
	 *            id
	 * @return com.edt.entity.Mechanisms
	 * @author 刘钢 2017-05-18 9:23
	 */

	Mechanisms getMechanismsById(String id);

	/**
	 * 删除所有组织机构
	 *
	 * @author 刘钢 2017-05-18 9:23
	 */

	void deleteAllMechanisms();

	/**
	 * 根据UserId获取可显示的组织机构信息
	 *
	 * @param userId
	 *            userId
	 * @return java.util.List<com.edt.entity.Mechanisms>
	 * @author 刘钢 2017/7/8 21:49
	 */
	List<Mechanisms> listMechanismsByUserId(String userId);

	/**
	 * 获取用户所在机构树
	 *
	 * @param id
	 *            id
	 * @return java.util.List<com.edt.entity.Mechanisms>
	 * @author 刘钢 2017/10/19 16:08
	 */
	List<Mechanisms> getMechanismsUserTree(String id);
}
