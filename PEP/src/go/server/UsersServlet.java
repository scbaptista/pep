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

@WebServlet("/serv/user")
public class UsersServlet extends HttpServlet{

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
		
		String op = request.getParameter("op");
		String token = request.getParameter("token");
		
		SqlParams sqlprm = getSqlToList(request, op, token);
		
		
		PgConection con = null;
		try {
			con = PgConection.getDBCon();
			if(sqlprm.getSelect()){
				String sql = "SELECT array_to_json(array_agg(row_to_json(t)))::text FROM (" + sqlprm.getSql() + ") t";
				
				ArrayList<Object> res = con.getObjectsSQL(sql, sqlprm.getParams());
				if (res!=null && res.size()>0) {
					STools.outputJson(response, (res.get(0)!=null ? (String)res.get(0) : "[]"));
				}
			}else{
				ArrayList<Object> res = con.getObjectsSQL(sqlprm.getSql(), sqlprm.getParams());
				if (res!=null && res.size()>0) {
					STools.outputString(response, (res.get(0)!=null ? (String)res.get(0) : "[]"));
				}
			}
			
			if(con != null){
				con.destroy();
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
			sql = "SELECT user_id, email, user_type, pass_word, nome, visivel, ativo FFROM appconf.users WHERE id=? ";
			res.setParams(new Object[] {jobject.get("id").getAsInt()});
			res.setSelect(true);
			break;
		case "2":
			sql = "INSERT INTO appconf.users(name, username, email, pass_word) values(?,?,?,?) RETURNING user_id ";
			res.setParams(new Object[] {
					jobject.get("name").getAsString(),
					jobject.get("username").getAsString(),
					jobject.get("email").getAsString(),
					jobject.get("pass").getAsString()
			});
			res.setSelect(false);
			break;
		case "3":
			sql = "UPDATE appconf.users SET nome=?, email=? WHERE id=? RETURNING user_id";
			res.setParams(new Object[] {
					jobject.get("nome").getAsString(), 
					jobject.get("email").getAsString(), 
					jobject.get("id").getAsInt()
			});
			res.setSelect(false);
			break;
		case "4":
			sql = "DELETE FROM appconf.users WHERE user_id=?";
			res.setParams(new Object[]{jobject.get("id").getAsInt()});
			res.setSelect(false);
			break;
		case "5":
			sql = "SELECT user_id, email, user_type, pass_word, nome, visivel, ativo FROM appconf.users";
			res.setSelect(true);
			break;
		default:
			break;
		}
		
		res.setSql(sql);
		return res;
	}


	
	
	
	
}
