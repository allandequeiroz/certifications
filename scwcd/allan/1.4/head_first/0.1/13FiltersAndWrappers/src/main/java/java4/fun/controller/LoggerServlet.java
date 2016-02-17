package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html; charset=UTF-8");
		
		StringBuilder code = new StringBuilder();
		code.append("<html></body>");
		code.append(new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()));
		code.append(" - This is the Filter logger test!");
		code.append("</body></html>");
		
		PrintWriter out = resp.getWriter();
		out.write(code.toString());
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

}
