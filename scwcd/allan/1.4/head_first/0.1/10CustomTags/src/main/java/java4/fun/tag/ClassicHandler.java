package java4.fun.tag;

import java.io.IOException;
import java.util.List;
import java4.fun.model.RSSReader;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sun.cnpi.rss.elements.Item;

public class ClassicHandler extends TagSupport{

	private String url;
	private String user;
	private String publisher;
	private int cursorPosition = 0;
	List<Item> items = null;

	public int doStartTag() throws JspException{

		cursorPosition = 0;
		try {
			items = new RSSReader().readURL(this.url);
		} catch (IOException e) {
			throw new JspException(e);
		}

		if(items.isEmpty())
			return SKIP_BODY;
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException{

		JspWriter out = pageContext.getOut();
		try {
			StringBuilder content = new StringBuilder();
			Item item = items.get(cursorPosition);
			content.append("<b>");
			content.append("<a href=\"");
			content.append(item.getLink());
			content.append("\">");
			content.append(item.getTitle());
			content.append("</a></b><br/>");
			content.append(item.getDescription());
			content.append("<hr/>");
			out.write(content.toString());
			cursorPosition++;
		} catch (IOException e) {
			throw new JspException(e);
		}

		if(cursorPosition < items.size())
			return EVAL_BODY_AGAIN;
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException{
		return EVAL_PAGE;
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
