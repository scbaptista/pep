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
import go.server.utils.SendMail;

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
					if(sqlprm.getMail() && sqlprm.getMailTo() != null &&  sqlprm.getMsgMail() != null && sqlprm.getSubjectMail() != null) {
						SendMail.send(sqlprm.getMailTo(), sqlprm.getSubjectMail(), sqlprm.getMsgMail());
					}
					
					if(sqlprm.getMailAdmin() && sqlprm.getMailToAdmin()!= null && sqlprm.getMsgMailAdmin() != null && sqlprm.getSubjectMail() != null) {
						SendMail.send(sqlprm.getMailToAdmin(), sqlprm.getSubjectMail(), sqlprm.getMsgMailAdmin());
					}
					
					STools.outputString(response, (res.get(0)!=null ? String.valueOf(res.get(0)) : "[]"));
					
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
			sql = "SELECT user_id, email, user_type, pass_word, nome, visivel, ativo, rgpd FFROM appconf.users WHERE id=? ";
			res.setParams(new Object[] {jobject.get("id").getAsInt()});
			res.setSelect(true);
			break;
		case "2":
			sql = "INSERT INTO appconf.users(name, email, user_type, username, pass_word, ativo, rgpd) values(?,?,?,?,?,?,?) RETURNING user_id ";
			res.setParams(new Object[] {				
					jobject.get("user_name").getAsString(),
					jobject.get("user_email").getAsString(),
					Integer.valueOf(jobject.get("user_type").getAsInt()),
					jobject.get("username").getAsString(),
					jobject.get("user_pass").getAsString(),
					Integer.valueOf(jobject.get("ativo").getAsInt()),
					jobject.get("rgpd").getAsBoolean()
			});
			res.setSelect(false);
			res.setMail(true);
			res.setMailTo(jobject.get("user_email").getAsString());
			res.setMsgMail("O sei registo foi efetuado com sucesso...\n\n"+(jobject.get("user_type").getAsString().equals("1")?"O seu registo está pendente de uma validação por parta da administração da plataforma.\nQuando poder utilizar a sua conta receberá outros email.":""));
			res.setSubjectMail("PEP - Novo Registo");
			res.setMailAdmin(true);
			res.setMsgMailAdmin("Caro Admin,\n\nHouve um novo registo na plataforma que necessita da sua validação.\n\nPara validar basta aceder à sua área de administração.");
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
		case "6":
			sql = "SELECT u.user_id, u.username, u.name, u.email, u.user_type as user_type_id, t.designacao as user_type FROM appconf.users AS u ";
			sql = sql + " LEFT JOIN param.type_user as t ON u.user_type = t.id ";
			sql = sql + " WHERE (email like ? or username like ?) and pass_word like ? ";
			
			res.setParams(new Object[] {
					jobject.get("user_login").getAsString(), 
					jobject.get("user_login").getAsString(), 
					jobject.get("user_pass").getAsString(),
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
