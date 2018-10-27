package game;

/**
 * Item.java
 * 
 * Interface for item classes.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public interface Item {
	
	/**
	 * Getting the description of the item.
	 * @return The description of the item.
	 */
	public String getDescription();
		
	/**
	 * Returning the name of the object.
	 * @return The name of the object.
	 */
	public String returnName();
	
	/**
	 * Checking whether the item is edible.
	 * @return Whether the item is edible.
	 */
	public boolean isEdible();
	
	/**
	 * Using the item.
	 * POSTCONDITION: The item is used.
	 */
	public void use();
		
}
