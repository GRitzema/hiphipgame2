package game;

public class Key implements Item{

	private Inventory pockets;
	private String name;
	private String description;
	private Room door;
	private Room currentRoom;
	private boolean isLocked;
	
	public Key(String name, String description, Room door) {		
		this.pockets = pockets;
		this.name = name;
		this.description = description;
		this.door = door;
		this.currentRoom = currentRoom;
		this.isLocked = true;
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
		if (currentRoom == door) {
			isLocked = false;
		}
	}


}