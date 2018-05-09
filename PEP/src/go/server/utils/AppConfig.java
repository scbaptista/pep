package go.server.utils;

public class AppConfig {
	
	public static String MAIL_SUBJ;
	/*** ALGORITMO DE ENCRIPTACAO **/
	public static String ALG_ENCRYPT;
	
	public static String INVALID_SESSION = "Invalid Session";
	public static Integer NumTentativasLog = Integer.valueOf(6);
	
	public static String DBSERVER;
	public static String DBNAME;
	public static String DBUSER;
	public static String DBPASS;
	
	public static String SMTP_FROM;
	public static String SMTP_HOST;
	public static String SMTP_USER;
	public static String SMTP_PASS;
	public static String SMTP_PORT;
	public static String SMTP_NAME;
	
	public static String GEOSERVER;
	public static String URLPAGE;
	public static String URLAPI;
	public static String GESTAOEMAIL;
	public static String DEVEMAIL;
	public static String SUPORTEEMAIL;
	public static String APIFONTE;
	
	public static String PLATAFORMANAME;
	public static String PAGENAME;
	public static String MENSAGEM;
	public static String ERROSERVIDOR;
	
	public static String CLIENETNAME;
	public static String URLCLIENTE;
	public static String URLCLIENTECONTATOS;
	
	public static String TITLECOLORDEFAULT;
	public static String TITLECOLORDARK;
	public static String TEXTCOLORDEFAULT;
	public static String TEXTCOLORDARK;
	
	public static String DATASOFTWARE;
	public static String VERSAOSOFTWARE;
	
	public static String IMGRODAPE_EMAIL;
	
	public static String InvalidSesssion = "Sessão inválida";
	
	public static String socialParam = "gbuid_";
	
	
	/*** WebServices **/
	public static String wsNoResult = "no result";
	public static String wsError = "internal error";
	public static String wsInvalidInvocation = "invalid invocation";
    public static String wsUser = "cartago.geral";
    public static String wsPass = "cartago.goapp";
    
    
    /**** Lys ***/
    public static String lyrParcela;
    public static String lyrParcelaPrint;
    public static String lyrLimites;
    public static String lyrEspacos;
    public static String lyrEspacosPrint;
    
    /****** vista de rua ***/
    public static String lonVistaRua;
    public static String latVistaRua;
    
    
    /****** lyr PDM ***/
    public static String lyrNamePDM;
    public static String linkPDM;
	public static String bufferLimites;
}