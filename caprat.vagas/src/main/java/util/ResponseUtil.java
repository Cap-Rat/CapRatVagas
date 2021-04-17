package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	
	public void outputResponse(HttpServletResponse response, String conteudo, int status) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		response.setStatus(status);
		response.setCharacterEncoding("UTF-8");
		
		
		writer.write(conteudo);
		writer.close();
	}
}
