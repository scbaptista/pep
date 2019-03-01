package go.server.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerUtil {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validateEmailAddress(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email.trim());
		boolean b = matcher.matches();
		return b;
	}

	public static String getSignature() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><meta http-equiv=\"content-type\" content=\"text/html;charset=ISO-8859-1\"><title></title></head><body text=\"#000000\" bgcolor=\"#FFFFFF\">");
		sb.append("<div style=\"color: #999999; font-family: Calibri; font-size: 10pt; margin: 0px; line-height: 10pt; text-align: justify; width: 862px;\">");
		sb.append("<p style=\"margin: 15px 0px 15px 0px;\">A equipa da plataforma PEP </p><p style=\"margin: 0px\">");
//		sb.append("<img width=\"200\" height=\"25\" src=\""+AppConfig.IMGRODAPE_EMAIL+"\" />");
		sb.append("</p><p style=\"margin: 0px 0px 3px 0px;\">&nbsp;</p><p style=\"color: #306CAD; font-size: 8pt; margin: 0px;\" lang=\"pt-pt\">AVISO</p>");
		sb.append("<p style=\"color: #999999; font-size: 8pt; margin: 0px;\">Esta &eacute; uma mensagem autom&aacute;tica da plataforma PEP.</p></div></body></html>");
	
		return sb.toString();
	}



}
