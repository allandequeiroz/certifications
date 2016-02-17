package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		String name = session.getAttribute("name").toString();
		String surename = session.getAttribute("surename").toString();
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html");
		
		out.print("<html><body>");
		out.print("Session id : " + session.getId());
		out.print("<br/>");
		out.print("Query string : " + req.getQueryString());
		out.print("<br/>");
		out.print("Name : " + name);
		out.print("<br/>");
		out.print("Surename : " + surename);
		out.print("</body></html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
