package java4.fun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java4.fun.model.RSSReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.cnpi.rss.elements.Item;

public class CompressServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		StringBuilder code = new StringBuilder();
		code.append("<html></body>");
		code.append("<b>");
		code.append(new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()));
		code.append("</b>");
		code.append("<b> - This is the Compress response Filter test! </b><br/>");
		code.append("<b>And this news are the compressed content : </b>");
		code.append("<hr/>");
		
		List<Item> rssItems = new RSSReader().readURL("http://www.dicas-l.com.br/index.xml");
		for(Item item : rssItems){
			
			code.append("<b><a href=\"");
			code.append(item.getLink());
			code.append(">");
			code.append(item.getTitle());
			code.append("</a></b><br/>");
			code.append(item.getDescription());
			code.append("<hr/>");
			
		}
		
		code.append("</body></html>");
		
		PrintWriter out = resp.getWriter();
		out.write(code.toString());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
