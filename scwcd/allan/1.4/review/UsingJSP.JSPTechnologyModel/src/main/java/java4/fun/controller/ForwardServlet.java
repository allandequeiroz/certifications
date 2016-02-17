package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java4.fun.bean.People;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForwardServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String surename = req.getParameter("surename");
		int age = Integer.parseInt(req.getParameter("age"));
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		StringBuilder code = new StringBuilder();
		code.append("<html><body>");
		code.append("Parameters from forward!<br/>");
		code.append(name);
		code.append(surename);
		code.append(age);
		code.append("</body></html>");
		
		out.write(code.toString());
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

}
