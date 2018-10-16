package game;

public class Monster {

	private String name;
	private Riddle riddle;
	private int health;
	private Inventory pockets;
	private Item item;
	private Key key;
	
	public Monster(String name, int health, Riddle riddle, Inventory pockets, Item item, Key key) {
		this.health = health;
		this.riddle = riddle;
		this.pockets = pockets;
		this.item = item;
		this.key = key;
	}
		
	public String getName() {
		return name;
	}
	public void defeat() {
		if (this.health <= 0)
		System.out.println("You defeated " + name + "! You received the " + key + "and the "+ item + ".");	
		pockets.addToInventory(item);
		pockets.addToInventory(key);
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = (int) health;
	}

	public Riddle getRiddle() {
		return riddle;
	}
	
	public Key getKey() {
		return key;
	}

	
	
}
