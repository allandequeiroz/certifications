package java4.fun.controller;

import java.io.IOException;
import java4.fun.bean.Skater;
import java4.fun.bean.Sponsor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSTLController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Sponsor adio = new Sponsor("Adio","2000");
		Sponsor almost = new Sponsor("Almost", "2004");
		Sponsor tensor = new Sponsor("Tensor", "2002");
		
		Skater skater = new Skater("Allan", "de Queiroz", 25, adio, almost, tensor);
		
		req.setAttribute("skater", skater);
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/jstl.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
