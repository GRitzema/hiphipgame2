package game;

/**
 * EquipAction.java
 * 
 * Class to equip swords.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class EquipAction implements Action {

	/**
	 * The player's inventory.
	 */
	private Inventory pockets;
	
	/**
	 * Constructor.
	 * @param p: the current player.
	 */
	public EquipAction(Player p) {
		this.pockets = p.getInventory();
	}

	/**
	 * Prints an error message.
	 */
	public void takeAction() {
		System.out.print("Equip what?");
	}

	/**
	 * Equips a sword.
	 * If the second word is blade and it is in the inventory, the message is read.
	 * Calls the use method to do so.
	 * POSTCONDITION: Showing the content of the scroll.
	 */
	public void takeAction(String item) {
		String hold = item.substring(item.indexOf(' ') + 1);    //the second word and on of item
		if (hold.equals("blade") && pockets.contains(pockets.receiveItem(item))) {
			pockets.receiveItem(item).use();
		}
		else {
			System.out.println("You can't equip that.");
		}
	}
}
