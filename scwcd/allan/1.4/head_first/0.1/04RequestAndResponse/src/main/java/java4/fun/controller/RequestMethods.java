package java4.fun.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestMethods extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		
		Enumeration<String> headers = req.getHeaderNames();
		
		StringBuilder rest = new StringBuilder();
		rest.append("<html>");
		rest.append("<body>");
		
		//HEADERS
		rest.append("<b>Headers</b>&nbsp;:&nbsp;<br/>");
		
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
			rest.append(headerName);
			rest.append(" : \"");
			rest.append(req.getHeader(headerName));
			rest.append("\"<br/>");
		}
		
		rest.append("<hr/>");
		
		//COOKIES
		Cookie[] cookies = req.getCookies();
		rest.append("<b>Cookies</b>&nbsp;:&nbsp;<br/>");
		
		for(Cookie cookie : cookies){
			rest.append(cookie.getName());
			rest.append(" : \"");
			rest.append(cookie.getValue());
			rest.append("\"<br/>");
		}
		
		rest.append("<hr/>");
		
		//SESSION
		HttpSession session = req.getSession();
		rest.append("<b>Session</b>&nbsp;:&nbsp;<br/>");
		String creationTimeFormated = new SimpleDateFormat("h:mm:ss a").format(new Date(session.getCreationTime()));
		String lastAccessedTimeFormated = new SimpleDateFormat("h:mm:ss a").format(new Date(session.getLastAccessedTime()));
		rest.append("Creation time : " + creationTimeFormated + "<br/>");
		rest.append("Id : " + session.getId() + "<br/>");
		rest.append("Last accessed time : " + lastAccessedTimeFormated + "<br/>");
		rest.append("<hr/>");
		
		PrintWriter out = resp.getWriter();
		out.print(rest.toString());
		
		rest.append("</body>");
		rest.append("</html>");
		
		
	}
}
