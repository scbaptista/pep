/**
 * Grammar for PEP - Plataforma de Suporte ao Ensino da Programacao
 */
grammar PEP;

@header{
    import java.util.*;
    import java.sql.*;
    import java.util.logging.Level;
	import java.util.logging.Logger;
    //import pep.server.PgConection;
}

@members {
    ArrayList<String> sessoes;
    StringBuilder sessao;
    int i, flagOrd;
    Connection connectionDB;
}

plano		
@init  { i = 0; sessoes = new ArrayList<String>(); 
		 try {
			Class.forName("org.postgresql.Driver").newInstance();
			String connString = "jdbc:postgresql://" + "localhost:5432" + "/" + "pep";
			connectionDB = DriverManager.getConnection(connString, "postgres", "postgres");
		
			System.out.println("Connected: " + connectionDB);
		 } catch (Exception ex) {
            Logger lgr = Logger.getLogger(Connection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        
         }
		}
			: 'Plano' idPlano sessoes 'Fim' 						
			   { 
			   	 for(int j=0; j<i; j++)
			   		System.out.println(sessoes.get(j));
			   	 //JSONParser parser = new JSONParser();
				 //JSONObject json = (JSONObject) parser.parse(stringToParse);
			   }
			;
sessoes		: sessao+
			;
sessao  	: 'SESSÃO' infoSessao tema parteA parteE ordem?
			  { 
			  	if (flagOrd == 0) {
			  		sessao.append("\"ordem\": \"E, A\"");
			  	}	
			  	sessao.append("}");
			  	sessoes.add(sessao.toString()); 
			  	i++; 
			  	flagOrd = 0; 
			  }
			;        
infoSessao	
@init  { sessao = new StringBuilder(); }
			: idSessao '-' titulo
		  	  { // {"sessao": "Introdução a Arrays",
		  	  	sessao.append("{\"sessao\": " + $titulo.text + ", "); 
		  	  }
			;
titulo		: STRING
			;
tema		: 'TEMA:' idTema
			  { 
			  	String t  = "BD";
			  	// "tema": "Arrays", 
			  	sessao.append("\"tema\": " + t + ", "); 
			  }
			;
parteA		: 'PARTE A:' { sessao.append("\"partea\": {"); } listaA { sessao.append("}, "); }
			  // "partea": {"id": "E1", "op": "no"},{"id": "E2", "op": "no"},{"id": "E3", "op": "yes"}, 
			;
parteE		: 'PARTE E:' { sessao.append("\"partee\": {"); } listaE { sessao.append("}, "); }
			  //"partee": {{"id": "E18"},{"id": "E20"}},
			;
ordem		: 'ORDEM:' x=('A'|'E') ',' y=('A'|'E')
			  { //	"ordem": "A, E" }
			  	flagOrd = 1;
			  	sessao.append("\"ordem\": \"" + $x.text + ", " + $y.text + "\""); 
			  }
			;
listaA		: ('?'? exerc)+
			;
listaE		: exerc+
			;
exerc		: idExerc ','
			| idExerc 
			;
idPlano		: 'P'INT
			;
idSessao	: 'S'INT
			;
idTema		: 'T'INT
            ;
idExerc		: 'E'INT
            ;

WS          : [ \t\r\n]  -> skip
            ;
INT         : '0'..'9'+
            ;
STRING      :  '"' ( ESC_SEQ | ~('"') )* '"'
    		;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') 
    ;

