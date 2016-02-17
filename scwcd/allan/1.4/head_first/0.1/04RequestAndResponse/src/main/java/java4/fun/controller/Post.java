package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Post extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String surename = req.getParameter("surename");
		String[] colors = req.getParameterValues("colors");
		
		StringBuilder rest = new StringBuilder();
		rest.append("<html>");
		rest.append("<body>");
		rest.append("Hi ");
		rest.append(surename);
		rest.append(", ");
		rest.append(name);
		rest.append("!</br>");
		rest.append("Your chooses : </br>");
		
		for(String color : colors){
			rest.append("&nbsp;&nbsp;- ");
			rest.append(color);
			rest.append("</br>");
		}
		
		rest.append("<a href=\"");
		rest.append(req.getContextPath());
		rest.append("/jsp/usingPost.jsp");
		rest.append("\">Back</a>");
		rest.append("</body>");
		rest.append("</html>");
		
		out.print(rest.toString());
	}
}
