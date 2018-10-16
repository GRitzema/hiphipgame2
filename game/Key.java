package game;

public class Key implements Item{

	private Inventory pockets;
	private String name;
	private String description;
	
	public Key(Inventory pockets, String name, String description) {		
		this.pockets = pockets;
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}
	
	public void pickUp() {
		pockets.addToInventory(new Key(pockets, name, description));
	}
	
}