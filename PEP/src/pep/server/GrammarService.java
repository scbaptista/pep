package pep.server;

import java.util.ArrayList;
import java.util.Arrays;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pep.server.utils.grammar.PEPLexer;
import pep.server.utils.grammar.PEPParser;

public class GrammarService {
	
	public static String parse(PgConection con, String plano) {
		String query = "SELECT id FROM infodat.exercicio";
		
		if (con.getConn() != null) {
			String value = con.getJsonSQL(query, null).toString().trim().replace("{id:","").replace("}", "").replace("[", "").replaceAll("]","");
			ArrayList<String> values = new ArrayList<String>(Arrays.asList(value.split(",")));
			
			CharStream input = CharStreams.fromString(plano);
			PEPLexer lexer = new PEPLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PEPParser parser = new PEPParser(tokens);
	        
	        try {
	        	ParseTree tree = parser.plano(values); // begin parsing at query rule
	        	
	        	return tree.toStringTree(parser);
	        } catch (Exception ex) {
	        	//System.out.println(tree.toStringTree(parser)); // print LISP-style tree
	        	return "{\"erro\": \"Verifique o id dos exercicios\"}";
	        }
		}
		
		return "{\"erro\": \"Ligacao invalida\"}";
	}
}
