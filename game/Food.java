package game;

public class Food implements Item {

	private int hp;
	private String description;
	private String name;
	private Player eater;
	private int price;
	private String type;
	
	public Food(int hp, String name, String description, Player eater, int price, String type) {
		this.hp = hp;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.eater = eater;

	}
	
	public int getHp() {
		return hp;
	}

	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

	public void use() {
		if ((hp + eater.getHealth()) <= eater.getMaxHealth()) {
			eater.setHealth(hp + eater.getHealth());
			eater.removeFromInventory(this);
			System.out.println("You ate the " + name + "! You gained " + hp);
			System.out.println("You now have " + eater.getHealth() + " health!");
		}
		else {
			eater.setHealth(eater.getMaxHealth());
			System.out.println("You maxed out your health to " + eater.getMaxHealth() + "hp!");
			eater.removeFromInventory(this);
		}
	}
	
	public boolean isEdible() {
		return true;
	}

	@Override
	public String returnType() {
		return type;
	}
}
