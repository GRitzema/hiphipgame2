package game;

public class Food implements Item {

	private int hp;
	private String description;
	private String name;
	private Player eater;
	private String type;
	
	public Food(int hp, String name, String description, Player eater, String type) {
		this.hp = hp;
		this.name = name;
		this.description = description;
		this.type = type;
		this.eater = eater;

	}
	
	public String getDescription() {
		return description;
	}

	
	public String returnName() {
		return name;
	}

	
	public void use() {
		eater.setHealth(hp + eater.getHealth());
		eater.removeFromInventory(this);
		System.out.println("You ate the " + name + "! You gained " + hp);
		System.out.println("You now have " + eater.getHealth() + "health!");
	}
	
	public boolean isEdible() {
		return true;
	}

	@Override
	public String returnType() {
		return type;
	}
}
