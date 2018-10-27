package game;

/**
 * InventoryAction.java
 * 
 * Class to implement checking the items and money in your inventory.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class InventoryAction implements Action {
	
	/**
	 * The current player.
	 */
	private Player p;
	
	/**
	 * The player's inventory.
	 */
	private Inventory pockets;
	
	/**
	 * Constructor.
	 * @param p: the current player.
	 */
	public InventoryAction(Player p) {
		this.p = p;
		this.pockets = p.getPockets();
	}

	/**
	 * Displays the contents of your inventory and your wealth.
	 * Calls a method in the inventory class that prints out the contents.
	 * POSTCONDITION: The list of items in the inventory is printed out.
	 */
	public void takeAction() {
		System.out.println("In your pockets there are:");
    	pockets.displayInventory();
    	System.out.println("Also, you have " + p.getWealth() + " dollars.");
    	
	}

	/**
	 * Prints an error message.
	 */
	public void takeAction(String substring) {
		System.out.println("You do not know how to do that.");
	}

}
