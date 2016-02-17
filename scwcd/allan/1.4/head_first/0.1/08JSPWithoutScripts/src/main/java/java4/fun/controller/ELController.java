package java4.fun.controller;

import java.io.IOException;

import java4.fun.bean.Skater;
import java4.fun.bean.Sponsor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ELController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Sponsor adio = new Sponsor("Adio","2000");
		Sponsor almost = new Sponsor("Almost", "2004");
		
		Skater skater = new Skater("Allan", "de Queiroz", 25, adio, almost);
		
		HttpSession sessionScope = req.getSession();//session scope
		ServletContext contextScope = sessionScope.getServletContext();//application scope
		
		//resp.addHeader("skaterHeader", "Adio");//header
		
		Cookie cookie = new Cookie("skaterCookie", "Adio, Almost");
		resp.addCookie(cookie);//cookie
		
		req.setAttribute("skaterRequest", skater);
		sessionScope.setAttribute("skaterSession", skater);
		contextScope.setAttribute("skaterContext", skater);
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/elViewer.jsp?skaterParam=Sponsors");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
