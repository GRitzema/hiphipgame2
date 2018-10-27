package game;
/**
 * Food.java
 * 
 * Class to represent food in the game
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class Food implements Item {

	/**
	 * The amount of hp the food can heal
	 */
	private int hp;
	
	/**
	 * The description of the food
	 */
	private String description;
	
	/**
	 * The name of the food
	 */
	private String name;
	
	/**
	 * The player in the game
	 */
	private Player eater;
	
	/**
	 * The price of the food in a shop
	 */
	private int price;
	
	/**
	 * The type of the item
	 */
	private String type;
	
	/**
	 * Constructor
	 * Refer to above instance variable comments
	 * @param hp
	 * @param name
	 * @param description
	 * @param eater
	 * @param price
	 */
	public Food(int hp, String name, String description, Player eater, int price) {
		this.hp = hp;
		this.name = name;
		this.description = description;
		this.price = price;
		this.eater = eater;
	}
	
	/**
	 * Getter method for hp
	 * @return the amount of hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Getter method for description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter method for name
	 * @return the name
	 */
	public String returnName() {
		return name;
	}
	
	/**
	 * Getter method for price
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Lets you eat the food
	 * If the new health exceeds the max health, it sets it to the max health
	 * POSTCONDITION: The food is removed from the inventory
	 * POSTCONDITION: The player's health increased
	 */
	public void use() {
		if ((hp + eater.getHealth()) <= eater.getMaxHealth()) {
			eater.setHealth(hp + eater.getHealth());
			eater.removeFromInventory(this);
			System.out.println("You ate the " + name + "! You gained " + hp);
			System.out.println("You now have " + eater.getHealth() + "health!");
		}
		else {
			eater.setHealth(eater.getMaxHealth());
			System.out.println("You maxed out your health to " + eater.getMaxHealth() + "hp!");
			eater.removeFromInventory(this);
		}
	}
	
	/**
	 * Returns a boolean if you can eat it
	 * @return false
	 */
	public boolean isEdible() {
		return true;
	}
	
	/**
	 * Getter method for the type
	 * @return type
	 */
	public String returnType() {
		return type;
	}

}
