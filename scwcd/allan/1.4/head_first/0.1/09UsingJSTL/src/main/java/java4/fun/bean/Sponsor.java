package java4.fun.bean;

public class Sponsor {

	private String name;
	private String creation;
	
	public Sponsor(String name, String creation) {
		super();
		this.name = name;
		this.creation = creation;
	}
	
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
