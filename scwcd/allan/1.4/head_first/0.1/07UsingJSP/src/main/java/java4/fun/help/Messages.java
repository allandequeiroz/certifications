package java4.fun.help;

import java.util.ArrayList;

public class Messages {
	
	private static ArrayList<String> messages = new ArrayList<String>();
	private static int count = 0;
	
	static{
		
		messages.add("Hi! I'm a message from Messages class :D");
		messages.add("Hey man! Leave parents' house!!!");
	}
	
	public static String getMessage(){
		switch(count){
		case 0 :
			count++;
			return messages.get(0);
		case 1 :
			count--;
			return messages.get(1);
		default :
			return null;
		}
	}
}
