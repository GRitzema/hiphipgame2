package game;

public class UseAction implements Action {

	/**
	 * The player's inventory.
	 */
	private Inventory pockets;
	
	/**
	 * Initializing use action class.
	 * @param p The player in the game.
	 */
	public UseAction(Player p) {
		this.pockets = p.getInventory();
	}

	/**
	 * Printing out a message.
	 */
	public void takeAction() {
		System.out.print("Use what?");
	}

	/**
	 * Using an item.
	 * POSTCONDITION: The player is using the item if there is one.
	 */
	public void takeAction(String item) {
		if (pockets.getPockets().containsKey(item)) {
			pockets.receiveItem(item).use();
		}
		else {
			System.out.println("You don't have that :(");
		}
	}

}
