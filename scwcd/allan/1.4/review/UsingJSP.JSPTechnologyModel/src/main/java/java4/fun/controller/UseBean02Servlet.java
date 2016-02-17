package java4.fun.controller;

import java.io.IOException;
import java4.fun.bean.People;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UseBean02Servlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String surename = req.getParameter("surename");
		int age = Integer.parseInt(req.getParameter("age"));
		
		People people = new People();
		people.setName(name);
		people.setSurename(surename);
		people.setAge(age);
		
		HttpSession session = req.getSession();
		session.setAttribute("people", people);
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/useBean02.jsp");
		rd.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

}
