/**
 * Grammar for PEP - Plataforma de Suporte ao Ensino da Programacao
 */
grammar PEP;

@header{
    import java.util.*;
    import java.util.List;
	import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.HashMap;
	import java.util.Map;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
}

@members {
	int i, err;
    HashMap<String, String> sessoes;
    ArrayList<String> exs, tms;
    ByteArrayOutputStream baos;
    PrintStream ps, oldOut, oldErr;
    String descr;
    StringBuilder sessao;
}

plano[ArrayList<String> exercs, ArrayList<String> temas]	
returns [ String console, int error, HashMap<String, String> sessions]	
@init  { i = 0; err = 0;
	     //sessoes = new ArrayList<String>();
		 exs = exercs;
		 tms = temas;
		 sessoes = new HashMap<String, String>();
		 
		 // Alterar stream de erros e output
		 baos = new ByteArrayOutputStream();
		 ps = new PrintStream(baos);
		 oldOut = System.out;
		 oldErr = System.err;
		 System.setOut(ps);
		 System.setErr(ps);
		}
			: ('P'|'p')('L'|'l')('A'|'a')('N'|'n')('O'|'o') idPlano sessoes ('F'|'f')('I'|'i')('M'|'m') 						
			   { 
			     $sessions = sessoes;
			   	 $error = err;
			   	 $console = baos.toString();
			   	 
			   	 // Repor stream de erros e output
			     System.out.flush();
			     System.setOut(oldOut);
			     System.setErr(oldErr);
			   }
			;
sessoes		: sessao+
			;
sessao		: ('S'|'s')('E'|'e')('S'|'s')('S'|'s')('Ã'|'ã'|'A'|'a')('O'|'o') infoSessao tema parteA parteE ordem?
			  { 
			  	try {
			  		//String value = new String(sessao.toString().getBytes("UTF-8"));
			  		sessoes.put(descr, sessao.toString()); 
			  	} catch (Exception ex) {
			  		System.out.println("AnTLR error!");
			  	}
			  	i++;  
			  	descr = new String();
			  }
			;        
infoSessao	
@init  { sessao = new StringBuilder(); }
			: idSessao '-' titulo
		  	  { // {"sessao": "Introdução a Arrays",
		  	  	sessao.append("{\"sessao\": " + $titulo.text + ", "); 
		  	  	descr = $titulo.text;
		  	  }
			;
titulo		: STRING
			;
tema		: ('T'|'t')('E'|'e')('M'|'m')('A'|'a')':' idTema
			;
parteA		: ('P'|'p')('A'|'a')('R'|'r')('T'|'t')('E'|'e') ('A'|'a')':' { sessao.append("\"partea\": {"); } listaA { sessao.append("}, "); }
			  // "partea": {"id": "E1", "op": "no"},{"id": "E2", "op": "no"},{"id": "E3", "op": "yes"}, 
			;
parteE		:  ('P'|'p')('A'|'a')('R'|'r')('T'|'t')('E'|'e') ('E'|'e')':' { sessao.append("\"partee\": {"); } listaE { sessao.append("}, "); }
			  //"partee": {{"id": "E18"},{"id": "E20"}},
			;
ordem		: ('O'|'o')('R'|'r')('D'|'d')('E'|'e')('M'|'m')':' x=('A'|'E') ',' y=('A'|'E')
			  { //	"ordem": "A, E" }
			  	sessao.append("\"ordem\": \"" + $x.text + ", " + $y.text + "\""); 
			  }
			;
listaA		: ('?'? exerc)+
			;
listaE		: exerc+
			;
exerc 		: idExerc ',' { sessao.append(","); }
			| idExerc 
			;
idPlano		: 'P'INT
			;
idSessao	: 'S'INT
			;
idTema		: 'T' t=INT
			{ 
				if(tms.contains($t.text)) {
			  		// "tema": "Arrays", 
			  		sessao.append("\"tema\": " + $t.text + ", "); 
				} else {
					err = 1;
					System.out.println("ERRO: O tema 'T" + $t.text + "' não existe!");
				}
			}
            ;
idExerc		: 'E' e=INT 
			{ 
				if(exs.contains($e.text)) {
					sessao.append("{\"id\": \"E" + $e.text + "\"}");
				} else {
					err = 1;
					System.out.println("ERRO: O exercício 'E" + $e.text + "' não existe!");
				}
			}
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
