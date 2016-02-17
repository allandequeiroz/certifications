package java4.fun.tag;

import java.io.IOException;
import java.util.List;
import java4.fun.model.RSSReader;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.cnpi.rss.elements.Item;

public class SimpleTagHandler extends SimpleTagSupport{
	
	private String user;
	private String publisher;
	private String url;

	public void doTag() throws JspException, IOException{
		
		getJspBody().invoke(null);
		
		List<Item> items = new RSSReader().readURL(this.url);
		
		JspWriter out = getJspContext().getOut();
		out.write("<hr/>");
		for(Item item : items){
			StringBuilder content = new StringBuilder();
			content.append("<b>");
			content.append("<a href=\"");
			content.append(item.getLink());
			content.append("\">");
			content.append(item.getTitle());
			content.append("</a></b><br/>");
			content.append(item.getDescription());
			content.append("<hr/>");
			out.write(content.toString());
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
