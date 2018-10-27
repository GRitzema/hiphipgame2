package game;

/**
 * ReadAction.java
 * 
 * Class to implement reading scrolls
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class ReadAction implements Action {

	/**
	 * the current player
	 */
	private Player p;
	
	/**
	 * The player's inventory
	 */
	private Inventory pockets;
	
	/**
	 * Constructor
	 * @param p: the current player
	 */
	public ReadAction(Player p) {
		this.p = p;
		this.pockets = p.getInventory();
	}

	/**
	 * Prints an error message
	 */
	public void takeAction() {
		System.out.print("Read what?");
	}

	/**
	 * Reads a scroll's message
	 * If the second word is scroll and it is in the inventory, the message is read
	 * Calls the use method to do so
	 */
	public void takeAction(String item) {
		String hold = item.substring(item.indexOf(' ') + 1);    //the second word and on of item
		if (hold.equals("scroll") && pockets.contains(pockets.receiveItem(item))) {
			pockets.receiveItem(item).use();
		}
		else {
			System.out.println("You can't read that.");
		}
	}
}
