package game;

public class Food implements Item {

	private int hp;
	private String description;
	private String name;
	private Inventory pockets;
	private Player p;
	private String type;
	
	public Food(int hp, String name, String description, Inventory pockets, Player p, String type) {
		this.hp = hp;
		this.name = name;
		this.description = description;
		this.pockets = pockets;
		this.type = type;
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
	
	public void use() {
		p.setHealth(hp + p.getHealth());
		pockets.removeFromInventory(this);
		System.out.println("You ate the " + name + "! You gained " + hp);
		System.out.println("You now have " + p.getHealth() + "health!");
	}
	
	public boolean isEdible() {
		return true;
	}

	@Override
	public String returnType() {
		return type;
	}
}
