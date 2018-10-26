package game;

public class Key implements Item{

	private String name;
	private String description;
	private String type = "key";
	
	public Key(String name, String description) {		
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}

	public boolean isEdible() {
		return false;
	}

	public String returnType() {
		return type;
	}

	public void use() {	}


}