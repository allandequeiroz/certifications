package java4.fun.model;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.cnpi.rss.elements.Item;
import com.sun.cnpi.rss.elements.Rss;
import com.sun.cnpi.rss.parser.RssParser;
import com.sun.cnpi.rss.parser.RssParserException;
import com.sun.cnpi.rss.parser.RssParserFactory;

public class RSSReader extends SimpleTagSupport{

	private String url;
	private String user;
	private String publisher;

	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();

		out.write("<h4>" + this.user + ", this is the notices from :" + this.url + "</h4>");
		out.write("<hr/>");

		RssParser parser = null;
		Rss rss = null;
		try {
			parser = RssParserFactory.createDefault();
			rss = parser.parse(new URL(this.url));
		} catch (RssParserException e) {
			throw new JspException(e);
		}

		Collection items = rss.getChannel().getItems();
		if(items != null && !items.isEmpty()){

			int row = 0;
			
			out.write("<table>");
			
			for(Iterator i = items.iterator(); i.hasNext(); row++){
				if((row%2)==0){
					out.write("<tr bgcolor=\"#DCDCDC\"><td>");
				}else{
					out.write("<tr><td>");
				}
				Item item = (Item)i.next();
				out.write("<b><a href=\"" + item.getLink() + "\">"  + item.getTitle() + "</a></b><br/>");
				out.write("<i>" + item.getDescription() + "</i>");
				out.write("</tr></td>");
			}
			
			out.write("</table>");

		}
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
