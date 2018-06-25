package pep.teste;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import pep.server.GrammarService;
import pep.server.PgConection;


public class Teste {
	
    public static void main(String[] args) {
    	String host = "localhost:5432";
    	String dbName = "pep";	
    	PgConection con = new PgConection(host, dbName);
        String user = "postgres";
        String pass = "postgres";
        
        try {
			con.connect(user, pass);
			
			CharStream input = CharStreams.fromFileName("/home/anas/git/pep/PEP/src/exemplo1.txt");
			String x = GrammarService.parse(con, input.toString());
			
			System.out.println("---" + x);
			
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(PgConection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
