package game;

/**
 * Key.java
 * 
 * Class to represent the key item
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Key implements Item{

	/**
	 * The name of the key
	 */
	private String name;
	
	/**
	 * The description of the key
	 */
	private String description;
	
	
	/**
	 * Constructor
	 * @param name: the name of the key
	 * @param description: the description of the key
	 */
	public Key(String name, String description) {		
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Getter method for the description
	 * @return the description of the scroll
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter method for the name of the scroll
	 * @return the name of the scroll
	 */
	public String returnName() {
		return name;
	}

	/**
	 * Returns whether or not it is edible
	 * @return false (since it is not edible)
	 */
	public boolean isEdible() {
		return false;
	}
	
	
	/**
	 * Empty method.
	 */
	public void use() {	}


}