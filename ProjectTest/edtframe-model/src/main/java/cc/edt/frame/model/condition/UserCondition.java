package cc.edt.frame.model.condition;

/**
 * 用户查询条件
 *
 * @author 刘钢
 * @date 2017/12/18 13:14
 */
public class UserCondition extends FindCondition {

	private static final long serialVersionUID = -8441535925204681321L;

	private String name;

	private Integer deleteFlag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "UserCondition{" + "name='" + name + '\'' + ", deleteFlag="
				+ deleteFlag + '}';
	}
}
