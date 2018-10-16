package game;

public class Food implements Item {

	private int hp;
	private String description;
	private String name;
	private Inventory pockets;
	private Player p;
	
	public Food(int hp, String name, String description, Inventory pockets, Player p) {
		this.hp = hp;
		this.name = name;
		this. description = description;
		this.pockets = pockets;
	}
	
	public String getDescription() {
		return description;
	}

	
	public String returnName() {
		return name;
	}

	
	public void pickUp() {
		pockets.addToInventory(this);	
	}
	
	public void eat() {
		p.setHealth(hp + p.getHealth());
		System.out.println("You ate the " + name + "! You gained " + hp);
		System.out.println("You now have " + p.getHealth());
	}
	
}
