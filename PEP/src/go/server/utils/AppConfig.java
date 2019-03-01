package go.server.utils;

public class AppConfig {
	
	public static String MAIL_SUBJ;
	/*** ALGORITMO DE ENCRIPTACAO **/
	public static String ALG_ENCRYPT;
	
	public static String INVALID_SESSION = "Invalid Session";
	public static Integer NumTentativasLog = Integer.valueOf(6);
	
	public static String DBSERVER = "192.168.85.219:5432";
	public static String DBNAME = "pep";
	public static String DBUSER = "postgres";
	public static String DBPASS = "sandra";
	
}