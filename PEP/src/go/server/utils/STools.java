package go.server.utils;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

public class STools {

	
	public static void outputJson(HttpServletResponse response, String jsonString) throws IOException {
		outputJson(response, jsonString, "application/json");
	}
	
	public static void outputJson(HttpServletResponse response, String jsonString, String contentType) throws IOException {
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
	    OutputStream os = response.getOutputStream();
	    jsonString = (jsonString!=null ? jsonString.replaceAll("\n", " ") : "");
	    os.write(jsonString.getBytes("UTF-8"));
		os.flush();
		os.close();
	}
	



	
	
	
}