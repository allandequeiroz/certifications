package java4.fun.controller;

import java.io.IOException;
import java4.fun.bean.Skater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkaterFormController extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String surename = req.getParameter("surename");
		int age = Integer.valueOf(req.getParameter("age"));
		String sponsors = req.getParameter("sponsors");
		
		Skater skater = new Skater(name, surename, age, null);
		skater.setSponsors(sponsors);
		
		req.setAttribute("skater", skater);
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/viewerResults.jsp");
		rd.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
