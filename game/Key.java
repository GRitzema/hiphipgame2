package game;

public class Key implements Item{

	private String name;
	private String description;
	private Room door;
	private Room currentRoom;
	private String type = "key";
	
	public Key(String name, String description, Room door) {		
		this.name = name;
		this.description = description;
		this.door = door;
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
	
	public void use() {

	}

	
	public String returnType() {
		return type;
	}


}