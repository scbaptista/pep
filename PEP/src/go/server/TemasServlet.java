package go.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import go.server.utils.STools;

@WebServlet("/serv/tema")
public class TemasServlet extends HttpServlet{

	/**
	 * note: servlet response by administrator temas
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String token = request.getParameter("token");
		
		SqlParams sqlprm = getSqlToList(request, op, token);
		String sql = "SELECT array_to_json(array_agg(row_to_json(t)))::text FROM (" + sqlprm.getSql() + ") t";
		
		PgConection con = null;
		try {
			con = PgConection.getDBCon();
			ArrayList<Object> res = con.getObjectsSQL(sql, sqlprm.getParams());
			if (res!=null && res.size()>0) {
				STools.outputJson(response, (res.get(0)!=null ? (String)res.get(0) : "[]"));
			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		} finally {
			if (con != null)
				con.destroy();
		}
		
		
	}
	
	
	private SqlParams getSqlToList(HttpServletRequest request, String op, String token) throws UnsupportedEncodingException {
		
		String dToken = (new String(Base64.getDecoder().decode(token), "UTF-8"));
		
		System.out.println("dToken -> "+dToken);
		
		JsonElement jelement = new JsonParser().parse(dToken);
	    JsonObject jobject = jelement.getAsJsonObject();
	    
	    
	    
		SqlParams res = new SqlParams();
		String sql = "";
		
		switch (op) {
		case "1":
//			sql = "SELE-....";

//			res.setParams(new Object[] {jobject.get('id')});
//			res.setPrivilegeType(2);
			break;
		case "2":
			break;
		case "3":
			break;
		default:
			break;
		}
		
		res.setSql(sql);
		return res;
	}


	
	
	public class SqlParams {
		String sql;
		Object[] params;
		Integer privilegeType;
		
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
	}
	
}
