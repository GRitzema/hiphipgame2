package game;

/**
 * Sword.java
 * 
 * Class to represent the sword item
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Sword implements Item{
	
	/**
	 * the material of the sword.
	 */
	private String material;
	
	/**
	 * The name of the sword.
	 */
	private String name;
	
	/**
	 * A description of the sword.
	 */
	private String description;

	/**
	 * The player that wields the sword.
	 */
	private Player wielder;


	/**
	 * Constructor.
	 * Refer to instance variables.
	 * @param material
	 * @param name
	 * @param description
	 * @param wielder
	 */
	public Sword(String material, String name, String description, Player wielder) {
		this.material = material;
		this.name = name;
		this.description = description;
		this.wielder = wielder;	
	}
	
	/**
	 * Getter method for the description.
	 * @return: the description of the sword.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter method for name.
	 * @return the name of the sword.
	 */
	public String returnName() {
		return name;
	}
	
	/**
	 * Getter method for the material. 	
	 * @return the material of the sword.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Method lets you equipped the sword to change your damage in combat.
	 * Method from the player class is called.
	 * POSTCONDITION: the player's sword is now changed.
	 */
	public void use() {	
		wielder.setSword(this);
		System.out.println("You have equipped " + this.returnName() + "!");
	}
	
	/**
	 * Determines if the sword is edible.
	 * @return false (since it is not edible).
	 */
	public boolean isEdible() {
		return false;
	}

	
}
