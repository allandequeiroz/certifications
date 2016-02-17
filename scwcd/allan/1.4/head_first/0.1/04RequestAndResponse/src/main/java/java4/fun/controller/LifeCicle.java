package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCicle extends HttpServlet{
	
	private static int initRequestNumber = 0;
	private static int serviceRequestNumber = 0;
	private static int doGetRequestNumber = 0;
	private static int doPostRequestNumber = 0;
	private static int destroyRequestNumber = 0;
	
	public void init() throws ServletException{
		initRequestNumber++;
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		serviceRequestNumber++;
		super.service(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGetRequestNumber++;
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println(getRequestsNumber("</br>"));
		out.print("<a href=\"" + req.getContextPath() + "/lifeCicle" + "\">Back</a>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPostRequestNumber++;
		doGet(req, resp);
	}
	
	public void destroy(){
		destroyRequestNumber++;
		System.out.print(getRequestsNumber("\n"));
	}
	
	private String getRequestsNumber(String breakLine){
		return "init() - " + initRequestNumber + breakLine +
			"service() - " + serviceRequestNumber + breakLine +
			"doGet() - " + doGetRequestNumber + breakLine +
			"doPost() - " + doPostRequestNumber + breakLine +
			"destroy() - " + destroyRequestNumber + breakLine;
	}

}
