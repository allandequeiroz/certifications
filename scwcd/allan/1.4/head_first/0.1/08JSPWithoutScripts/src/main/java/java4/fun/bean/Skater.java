package java4.fun.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Skater implements People{

	private String name = "default name";
	private String surename = "default surename";
	private int age = 0;
	private Sponsor[] sponsorsArray;
	private Map<String, Sponsor> sponsorsMap;
	
	public Skater(){
		super();
		sponsorsArray = new Sponsor[5];
		sponsorsMap = new HashMap<String, Sponsor>();
	}
	
	public Skater(String name, String surename, 
			int age, Sponsor... sponsors) {
		super();
		this.name = name;
		this.surename = surename;
		this.age = age;
		
		if(sponsors!=null){
			sponsorsArray = new Sponsor[sponsors.length];
			sponsorsMap = new HashMap<String, Sponsor>();
			this.setSponsors(sponsors);
		}else{
			sponsorsArray = new Sponsor[5];
			sponsorsMap = new HashMap<String, Sponsor>();
		}
	}
	
	public int addSponsor(Sponsor sponsor){
		sponsorsMap.put(sponsor.getName(), sponsor);
		sponsorsArray = new Sponsor[sponsorsMap.size()];
		
		Set<String> keys = sponsorsMap.keySet();
		for(String key : keys){
			sponsorsArray[sponsorsMap.size()-1] = sponsorsMap.get(key);
		}
		
		return sponsorsMap.size();
	}
	
	public void setSponsors(Sponsor...sponsors){
		this.sponsorsArray = sponsors;
		for(Sponsor sponsor : sponsors){
			sponsorsMap.put(sponsor.getName(), sponsor);
			sponsorsArray[sponsorsMap.size()-1] = sponsor;
		}
	}
	
	public void setSponsors(String sponsors){
		StringTokenizer token = new StringTokenizer(sponsors,";");
		while(token.hasMoreElements()){
			String sponsorName = token.nextElement().toString();
			Sponsor sponsor = new Sponsor(sponsorName,null);
			this.sponsorsMap.put(sponsorName, sponsor);
			this.sponsorsArray[sponsorsMap.size()-1] = sponsor;
		}
	}
	
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
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public Sponsor[] getSponsorsArray() {
		return sponsorsArray;
	}
	public void setSponsorsArray(Sponsor[] sponsorsArray) {
		this.sponsorsArray = sponsorsArray;
	}
	public Map<String, Sponsor> getSponsorsMap() {
		return sponsorsMap;
	}
	public void setSponsorsMap(Map<String, Sponsor> sponsorsMap) {
		this.sponsorsMap = sponsorsMap;
	}
	
}
