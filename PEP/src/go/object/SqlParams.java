package go.object;

public class SqlParams {

	String sql;
	Object[] params;
	Integer privilegeType;
	Boolean select;
	String msg;
	
	public SqlParams(){ 
		this.setPrivilegeType(4);
	}
	
	public Integer getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(Integer privilegeType) {
		this.privilegeType = privilegeType;
	}

	public SqlParams (String sql, Object[] params) {
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
