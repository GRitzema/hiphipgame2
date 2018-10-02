package game;

public class Key implements Item{

	private Inventory pockets;
	private String name;
	
	public Key(Inventory pockets, String name) {
		this.pockets = pockets;
		this.name = name;
	}
	
	public String description() {
		return "Unlocks a mystery door";
	}
	
	public String returnName() {
		return name;
	}
	
	public void use() {
		if ()
	}
}