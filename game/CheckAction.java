package game;

/**
 * CheckAction.java
 * 
 * Class to implement the action to check an item.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class CheckAction implements Action{

	/**
	 * The pockets that the player has.
	 */
	private Inventory pockets;
	
	public CheckAction(Player p) {
		this.pockets = p.getPockets();
	}

	/**
	 * Prints out a message.
	 */
	public void takeAction() {
		System.out.println("Check what?");
	}

	/**
	 * Giving the description of the item.
	 * POSTCONDITION: Printing out the description of the item.
	 */
	public void takeAction(String substring) {
		if (pockets.receiveItem(substring) != null) {
			System.out.println(pockets.receiveItem(substring).getDescription());
		}
		else {
			System.out.println("You do not have that item");
		}
	}
	
	
}
