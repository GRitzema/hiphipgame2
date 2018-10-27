package game;

/**
 * Scroll.java
 * 
 * Class to represent the scroll item
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Scroll implements Item {

	/**
	 * The name of the scroll
	 */
	private String name;
	
	/**
	 * The description of the scroll
	 */
	private String description;
	
	/**
	 * What the scroll says
	 */
	private String hint;
	private String type;
	
	/**
	 * Constructor
	 * Refer to instance variables
	 * @param name
	 * @param description
	 * @param hint
	 */
	public Scroll(String name, String description, String hint) {
		this.name = name;
		this.description = description;
		this.hint = hint;
	}
	
	/**
	 * Getter method for the description
	 * @return the description of the scroll
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter method for the name
	 * @return the name of the scroll
	 */
	public String returnName() {		
		return name;
	}

	/**
	 * Determines if the scroll is edible
	 * @return false (since it is not edible)
	 */
	public boolean isEdible() {
		return false;
	}

	/**
	 * Lets the player read the scroll
	 * Prints out the scroll's hint
	 */
	public void use() {
		System.out.println("The scroll reads:");
		System.out.println(hint);
		
	}

	public String returnType() {
		return null;
	}
}
