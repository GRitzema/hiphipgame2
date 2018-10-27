package game;

public interface Item {
	
	/**
	 * Getting the description of the item.
	 * @return
	 */
	public String getDescription();
		
	/**
	 * Returning the name of the object.
	 * @return
	 */
	public String returnName();
	
	/**
	 * Checking whether the item is edible.
	 * @return Whether the item is edible.
	 */
	public boolean isEdible();
	
	/**
	 * Using the item.
	 */
	public void use();
		
}
