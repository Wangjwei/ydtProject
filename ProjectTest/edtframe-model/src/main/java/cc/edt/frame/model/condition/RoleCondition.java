package cc.edt.frame.model.condition;

/**
 * 权限信息查询条件
 *
 * @author 刘钢
 * @date 2017/12/18 13:14
 */
public class RoleCondition extends FindCondition {

	private static final long serialVersionUID = -4281989386227853066L;

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
