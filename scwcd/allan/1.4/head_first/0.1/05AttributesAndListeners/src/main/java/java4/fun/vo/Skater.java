package java4.fun.vo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Skater implements HttpSessionBindingListener{

	private String name;
	private int age;
	private String[] sponsors;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSponsors() {
		return sponsors;
	}
	public void setSponsors(String... sponsors) {
		this.sponsors = sponsors;
	}
	
	public void valueBound(HttpSessionBindingEvent event){
		System.out.println("\nHey! I'm the Attribute!");
		System.out.println("value bound in the session : " + event.getSession().getId());
	}
	
	public void valueUnbound(HttpSessionBindingEvent event){
		System.out.println("\nHey! I'm the Attribute!");
		System.out.println("value unbound from session : " + event.getSession().getId());
	}
	
	public String toString(){
		return toStringNotDefault("\n");
	}
	
	public String toStringNotDefault(String breakLine){
		StringBuilder skaterAttributes = new StringBuilder();
		skaterAttributes.append("Name : " + this.getName() + breakLine);
		skaterAttributes.append("Age : " + this.getAge() + breakLine);
		skaterAttributes.append("Sponsors : " + breakLine);	
		
		for(String sponsor : sponsors){
				skaterAttributes.append("\t- " + sponsor + breakLine);
		}
		
		return skaterAttributes.toString();
	}
}
