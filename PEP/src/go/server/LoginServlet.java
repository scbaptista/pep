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

import go.object.SqlParams;
import go.server.utils.STools;

@WebServlet("/serv/login")
public class LoginServlet extends HttpServlet{

	/**
	 * note: servlet response by administrator temas
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ola1");
		String op = request.getParameter("op");
		String token = request.getParameter("token");
		
		SqlParams sqlprm = getSqlToList(request, op, token);
		
		PgConection con = null;
		try {
			
			if(sqlprm.getSelect()){
				String sql = "SELECT array_to_json(array_agg(row_to_json(t)))::text FROM (" + sqlprm.getSql() + ") t";
				con = PgConection.getDBCon();
				ArrayList<Object> res = con.getObjectsSQL(sql, sqlprm.getParams());
				if (res!=null && res.size()>0) {
					STools.outputJson(response, (res.get(0)!=null ? (String)res.get(0) : "[]"));
				}
			}else{
				con = PgConection.getDBCon();
				ArrayList<Object> res = con.getObjectsSQL(sqlprm.getSql(), sqlprm.getParams());
				if (res!=null && res.size()>0) {
					STools.outputJson(response, (res.get(0)!=null ? (String)res.get(0) : "[]"));
				}
			}
		
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		} finally {
			if (con != null)
				con.destroy();
		}
		
		
	}
	
	
	private SqlParams getSqlToList(HttpServletRequest request, String op, String token) throws UnsupportedEncodingException {
		
		String dToken = null;
		JsonElement jelement = null;
		JsonObject jobject = null;
		
		if(token != null) {
			dToken = (new String(Base64.getDecoder().decode(token), "UTF-8"));
			
			System.out.println("dToken -> "+dToken);
			
			jelement = new JsonParser().parse(dToken);
		    jobject = jelement.getAsJsonObject();
		}
	    
	    
	    
		SqlParams res = new SqlParams();
		String sql = "";
		
		switch (op) {
		case "1":
			sql = "SELECT u.user_id, u.username, u.name, u.email, u.user_type as user_type_id, t.designacao as user_type, u.pass_word, u.rgpd, u.ativo FROM appconf.users AS u ";
			sql = sql + " LEFT JOIN param.type_user as t ON u.user_type = t.id ";
			sql = sql + " WHERE (email like ? or username like ?) ";
			
			res.setParams(new Object[] {
					jobject.get("user_login").getAsString(), 
					jobject.get("user_login").getAsString(), 
//					jobject.get("user_pass").getAsString(),
			});
			res.setSelect(true);
			break;
		default:
			break;
		}
		
		res.setSql(sql);
		return res;
	}

}
