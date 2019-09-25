package cc.edt.frame.model.condition;

/**
 * 组织机构查询条件
 *
 * @author 刘钢
 * @date 2017/12/18 11:54
 */
public class MechanismsCondition extends FindCondition {
	private static final long serialVersionUID = 170730431738695628L;

	private String mechanismsId;
	private String mechanismsName;
	private String mechanismsParentName;
	private String mechanismsParentId;

	public String getMechanismsName() {
		return mechanismsName;
	}

	public void setMechanismsName(String mechanismsName) {
		this.mechanismsName = mechanismsName;
	}

	public String getMechanismsParentName() {
		return mechanismsParentName;
	}

	public void setMechanismsParentName(String mechanismsParentName) {
		this.mechanismsParentName = mechanismsParentName;
	}

	public String getMechanismsParentId() {
		return mechanismsParentId;
	}

	public void setMechanismsParentId(String mechanismsParentId) {
		this.mechanismsParentId = mechanismsParentId;
	}

	public String getMechanismsId() {
		return mechanismsId;
	}

	public void setMechanismsId(String mechanismsId) {
		this.mechanismsId = mechanismsId;
	}

	@Override
	public String toString() {
		return "MechanismsCondition{" + "mechanismsId='" + mechanismsId + '\''
				+ ", mechanismsName='" + mechanismsName + '\''
				+ ", mechanismsParentName='" + mechanismsParentName + '\''
				+ ", mechanismsParentId='" + mechanismsParentId + '\'' + '}';
	}
}
