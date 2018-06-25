package pep.teste;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import pep.server.PgConection;
import pep.server.utils.grammar.PEPLexer;
import pep.server.utils.grammar.PEPParser;

public class Teste {
	
    public static void main(String[] args) {
    	String host = "localhost:5432";
    	String dbName = "pep";	
    	PgConection con = new PgConection(host, dbName);
        String user = "postgres";
        String pass = "postgres";
        
        try {
        	
			con.connect(user, pass);
			
			String query = "SELECT * FROM infodat.tema";
			String value = con.getJsonSQL(query, null);
			
			CharStream input = CharStreams.fromFileName("/home/anas/git/pep/PEP/src/exemplo1.txt");
	        PEPLexer lexer = new PEPLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PEPParser parser = new PEPParser(tokens);
	        ParseTree tree = parser.plano(); // begin parsing at query rule
	        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
	        
        } catch (Exception ex) {
        	
            Logger lgr = Logger.getLogger(PgConection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        
        }
    }
}
