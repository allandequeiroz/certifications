package java4.fun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String surename = req.getParameter("surename");
		
		HttpSession session = req.getSession();
		
		session.setAttribute("name", name);
		session.setAttribute("surename", surename);
		
		String encodedURL = resp.encodeRedirectURL("showServlet");
		
		RequestDispatcher rd = req.getRequestDispatcher(encodedURL);
		rd.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
