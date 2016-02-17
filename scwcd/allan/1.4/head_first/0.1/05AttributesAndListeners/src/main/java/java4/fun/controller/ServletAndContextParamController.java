package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAndContextParamController extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		ServletConfig servletConfig = this.getServletConfig();
		ServletContext servletContext = this.getServletContext();
		
		String initParameter = servletConfig.getInitParameter("Init param");
		String contextParameter = servletContext.getInitParameter("Context param");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		out.print("<html><body>");
		out.print("<b>Servlet and Context parameters : </b><br/>");
		out.print("Init param : " + initParameter + "<br/>");
		out.print("Context param : " + contextParameter + "<br/>");
		out.print("<hr/>");
		
		out.print("<b>Context attributes : </b><br/>");
		Enumeration<String> contextParameters = servletContext.getAttributeNames();
		while(contextParameters.hasMoreElements()){
			String attributeName = contextParameters.nextElement();
			if(attributeName.equals("Initialized")){
				out.println("<b>" + attributeName + " : " + servletContext.getAttribute(attributeName) + "</b>");
			}else{
				out.println(attributeName + " : " + servletContext.getAttribute(attributeName));
			}
			out.println("<br/>");
		}
		
		out.print("</body></html>");
	}
}
