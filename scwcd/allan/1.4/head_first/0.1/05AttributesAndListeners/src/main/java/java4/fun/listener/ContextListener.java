package java4.fun.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event){
		
		ServletContext context = event.getServletContext();
		System.out.println("\nContext Listener Initialized!\n");
		context.setAttribute("Initialized", "By Your Context Listener!");
	}
	
	public void contextDestroyed(ServletContextEvent event){
		System.out.println("\nContext Listener Destroyed!\n");
	}
}
