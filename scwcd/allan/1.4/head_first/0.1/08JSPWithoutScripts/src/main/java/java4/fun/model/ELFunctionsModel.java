package java4.fun.model;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import com.sun.cnpi.rss.elements.Item;
import com.sun.cnpi.rss.elements.Rss;
import com.sun.cnpi.rss.parser.RssParser;
import com.sun.cnpi.rss.parser.RssParserFactory;

public class ELFunctionsModel {

	public static String readRSSDocument() throws Exception{

		RssParser parser = RssParserFactory.createDefault();
		Rss rss = parser.parse(new URL("http://www.noticiaslinux.com.br/rss.php?v=2"));
		
		//Get all XML elements in the feed
		Collection items = rss.getChannel().getItems();
		StringBuilder result = new StringBuilder();
		if(items != null && !items.isEmpty()){
			
			//Iterate over our main elements. Should have one for each article
			for(Iterator i = items.iterator(); i.hasNext(); result.append("<br/>")){
				Item item = (Item)i.next();
				result.append("<b>Title: </b>" + item.getTitle() + "<br/>");
				result.append("<b>Link: </b>" + item.getLink() + "<br/>");
				result.append("<b>Description: </b>" + item.getDescription() + "<hr/>");
			}

		}
		
		//Iterate over categories if we are provided with any
		/*Collection categories = rss.getChannel().getCategories();
		if(categories != null && !categories.isEmpty()){
			Category cat;
			for(Iterator i = categories.iterator(); i.hasNext(); 
			result.append("<b>Category Domain: </b>" + cat.getDomain())){
				cat = (Category)i.next();
				result.append("<b>Category: </b>" + cat + "<hr/>");
			}

		}*/
		
		return result.toString();
	}
}
