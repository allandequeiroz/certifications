package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java4.fun.vo.Skater;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAttributeServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Skater skater = new Skater();
		skater.setAge(23);
		skater.setName("Corey Duffel");
		skater.setSponsors(new String[]{"Foundation","Emerica","..."});
		
		HttpSession session = req.getSession();
		session.setAttribute("skater", skater);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><body>");
		out.print("Add attribute skater in the session : " + session.getId() + "<br/>");
		out.print(skater.toStringNotDefault("</br>"));
		out.print("</body></html>");
		
		skater.setSponsors("Globe", "Trasher");
		session.setAttribute("skater", skater);
		
		session.removeAttribute("skater");
		
		
	}
}
