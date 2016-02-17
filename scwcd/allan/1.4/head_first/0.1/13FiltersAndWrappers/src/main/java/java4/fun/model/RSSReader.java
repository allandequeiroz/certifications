package java4.fun.model;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sun.cnpi.rss.elements.Item;
import com.sun.cnpi.rss.elements.Rss;
import com.sun.cnpi.rss.parser.RssParser;
import com.sun.cnpi.rss.parser.RssParserException;
import com.sun.cnpi.rss.parser.RssParserFactory;

public class RSSReader{

	public List<Item> readURL(String url) throws IOException{

		RssParser parser = null;
		Rss rss = null;
		try {
			parser = RssParserFactory.createDefault();
			rss = parser.parse(new URL(url));
		} catch (RssParserException e) {
			throw new IOException(e);
		}
		
		Collection items = rss.getChannel().getItems();
		List<Item> itemsList = new LinkedList<Item>();
		if(items != null && !items.isEmpty()){
			
			for(Object item : items){
				itemsList.add((Item)item);
			}
			
		}
		
		return itemsList;
	}

}
