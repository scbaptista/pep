/**
 * Grammar for PEP - Plataforma de Suporte ao Ensino da Programacao
 */
grammar pep;

plano		: 'Plano' idPlano sessoes 'Fim' 						{System.out.println("ACABEI");}
			;
sessoes		: sessao+
			;
sessao  	: 'SESSÃO' infoSessao tema  parteA parteE ordem?
			;        
infoSessao	: idSessao '-' titulo
			;
titulo		: STRING
			;
tema		: 'TEMA:' STRING
			;
linguagem	: 'LINGUAGEM:' STRING
			;
parteA		: 'PARTE A:' '{' listaA '}'
			;
parteE		: 'PARTE E:' '{' listaE '}'
			;
ordem		: 'Ordem:' ('A'|'E'){2} 
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
idExerc		: 'E'INT
            ;
WS          : [ \t\r\n]  -> skip
            ;
INT         : '0'..'9'+
            ;
            
fragment
STRING
    :  '"' ( ESC_SEQ | ~('"') )* '"'
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

