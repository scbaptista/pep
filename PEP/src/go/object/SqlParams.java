package go.object;

public class SqlParams {

	String sql;
	Object[] params;
	Integer privilegeType;
	Boolean select;
	String msg;
	Boolean Mail;
	String MailTo;
	String MsgMail;
	String SubjectMail;
	String MailToAdmin;
	Boolean MailAdmin;
	String MsgMailAdmin;
	
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

	public Boolean getMail() {
		return Mail;
	}

	public void setMail(Boolean mail) {
		Mail = mail;
	}

	public String getMailTo() {
		return MailTo;
	}

	public void setMailTo(String mailTo) {
		MailTo = mailTo;
	}

	public String getMsgMail() {
		return MsgMail;
	}

	public void setMsgMail(String msgMail) {
		MsgMail = msgMail;
	}

	public String getSubjectMail() {
		return SubjectMail;
	}

	public void setSubjectMail(String subjectMail) {
		SubjectMail = subjectMail;
	}

	public String getMailToAdmin() {
		return MailToAdmin;
	}

	public void setMailToAdmin(String mailToAdmin) {
		MailToAdmin = mailToAdmin;
	}

	public Boolean getMailAdmin() {
		return MailAdmin;
	}

	public void setMailAdmin(Boolean mailAdmin) {
		MailAdmin = mailAdmin;
	}

	public String getMsgMailAdmin() {
		return MsgMailAdmin;
	}

	public void setMsgMailAdmin(String msgMailAdmin) {
		MsgMailAdmin = msgMailAdmin;
	}

}
