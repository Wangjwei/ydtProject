package cc.edt.frame.model.condition;

import java.io.Serializable;
import java.util.Date;

/**
 * 条件查询基础类
 *
 * @author 刘钢
 * @date 2017/12/18 10:57
 */
public class FindCondition implements Serializable {
	private static final long serialVersionUID = 2132944047590456924L;
	private Integer page;
	private Integer rows;
	private String draw;
	private Integer length;
	private Integer start;
	private Long totalRows;
	private String userId;
	private String addUser;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
}
