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

@WebServlet("/serv/sessao")
public class SessoesServlet extends HttpServlet{

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
			sql = "SELECT id, designacao, cod_tema, cod_user, cod_ling, descricao  FROM infodat.sessao WHERE id=?";
			res.setParams(new Object[] {jobject.get("id").getAsInt()});
			res.setSelect(true);
			break;
		case "2":
			try {
				res.setMsg(new GrammarService().parse(jobject.get("").getAsString(), null, String.valueOf("1")));
				res.setSelect(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "3":
			try {
				res.setMsg(new GrammarService().parse(jobject.get("").getAsString(), null, String.valueOf("2")));
				res.setSelect(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "4":
			sql = "DELETE FROM infodat.sessao WHERE id=?";
			res.setParams(new Object[]{jobject.get("id").getAsInt()});
			res.setSelect(false);
			break;
		case "5":
			sql = "SELECT id, designacao, cod_tema, cod_user, cod_ling, descricao  FROM infodat.sessao";
			res.setSelect(true);
			break;
		default:
			break;
		}
		
		res.setSql(sql);
		return res;
	}

	
}
