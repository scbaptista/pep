package go.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import go.server.utils.grammar.PEPLexer;
import go.server.utils.grammar.PEPParser;
import go.server.utils.grammar.PEPParser.PlanoContext;



public class GrammarService {
	
	private final static String jsonErr = "{\"id\": 1, \"msg\": \"";
	private final static String jsonOk = "{\"id\": 0, \"msg\": \"";
	private final static String jsonFim = "\"}";
    
	@SuppressWarnings("rawtypes")
	public String parse(String plano, String id, String op, String user_id) throws Exception {
		System.out.println("teste0");
		String queryEx = "SELECT id FROM infodat.exercicio";
		String queryTm = "SELECT id FROM infodat.tema";
		
		PgConection con = PgConection.getDBCon();
		
		if (con.getConn() != null) {
			String exer = con.getJsonSQL(queryEx, null).toString().trim();
			String exs  = exer.replace("{id:","").replace("}", "").replace("[","").replace("]","");
			ArrayList<String> exers = new ArrayList<String>(Arrays.asList(exs.split(",")));
			
			String tem = con.getJsonSQL(queryTm, null).toString().trim();
			String tems = tem.replace("{id:","").replace("}", "").replace("[","").replace("]","");
			ArrayList<String> temas = new ArrayList<String>(Arrays.asList(tems.split(",")));
			
			CharStream input = CharStreams.fromString(plano);
			PEPLexer lexer = new PEPLexer(input);			
			CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PEPParser parser = new PEPParser(tokens);    
	        
	        try {
	        	
	        	System.out.println("teste1");
	        	System.out.println("temas: " +temas);
	        	System.out.println("exers: "+exers);
	        	// Invocar AnTLR
	        	PlanoContext pContext = parser.plano(exers,temas);
	        	System.out.println("teste2  ->1");
	        	String cons = pContext.console;
	        	System.out.println("teste2  ->2");
	        	int err = pContext.error;
	        	
	        	System.out.println("teste2  ->");
	        	
	        	if(err == 0 && cons.trim().isEmpty()) {
	        		HashMap<String, String> sessoes = pContext.sessions;
	        		
	        		Set set = sessoes.entrySet();
	        	    Iterator iterator = (Iterator) set.iterator();
	        	    while(iterator.hasNext()) {
	        	    	Map.Entry mentry = (Map.Entry)iterator.next();
	        	    	String query = null;
	        	    	System.out.println("teste2");
	        	    	switch (op) {
	        			case "1":
	        				query = "INSERT INTO infodat.sessao (designacao, info_sessao, user_id) VALUES ('" + mentry.getKey() + "', '" + mentry.getValue() + "',"+Integer.valueOf(user_id.toString())+")";
			        	    System.out.println(query);
	        				con.executeSQL(query);
	        				break;
	        			case "2":
	        				query = "UPDATE infodat.sessao SET designacao="+mentry.getKey()+", info_sessao="+ mentry.getValue()+" Where id="+id+" RETURNING id";
			        	    con.executeSQL(query);
	        				break;
	        			
	        			default:
	        				break;
	        			}
	        	    	
	        	      }		 
	        	    
	        	    if(con != null){
	        	    	con.destroy();
	        	    }
	        		return jsonOk + "SessÃ£o/SessÃµes registada(s) com sucesso!" + jsonFim;
	        	} else {
	        		return jsonErr + cons + jsonFim;
	        	}
	        } catch (Exception ex) {
			    
	        	return jsonErr + "Erro GrammarService: " + ex.toString() + jsonFim;
	        }
		}
		
		return jsonErr + "Erro ao estabelecer ligaÃ§Ã£o Ã  base de dados." + jsonFim;
	}
}
