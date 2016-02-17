package java4.fun.listener;

import java4.fun.vo.Skater;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent event){
		System.out.println("\nHey! I'm the Session Attribute Listener");
		System.out.println("Attribute Added!");
		printInformations(event);
	}
	
	public void attributeRemoved(HttpSessionBindingEvent event){
		System.out.println("\nHey! I'm the Session Attribute Listener");
		System.out.println("Attribute Removed!");
		printInformations(event);
	}
	
	public void attributeReplaced(HttpSessionBindingEvent event){
		System.out.println("\nHey! I'm the Session Attribute Listener");
		System.out.println("Attribute Replaced!");
		printInformations(event);
	}
	
	private synchronized void printInformations(HttpSessionBindingEvent event){
		System.out.println("From Session : " + event.getSession().getId());
		System.out.println("Attribute name : " + event.getName());
		System.out.println("Attribute value : ");
		System.out.println(event.getValue().toString());
	}
}
