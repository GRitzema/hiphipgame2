package game;

/**
 * EatAction.java
 * 
 * Class to implement the action to eat foods.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class EatAction implements Action{

	/**
	 * The pocket that the player has.
	 */
	private Inventory pockets;
	
	/**
	 * Initializing eat action class.
	 * @param p The player in the game.
	 */
	public EatAction(Player p) {
		this.pockets = p.getInventory();
	}

	/**
	 * Print out a message.
	 */
	public void takeAction() {
		System.out.print("Eat what?");
	}

	/**
	 * Eat foods that the player has.
	 * Prevents player from eating an item that is not edible.
	 * PRECONDITION: The food is in the player's pocket.
	 * POSTCONDITION: The player ate the food.
	 */
	public void takeAction(String item) {
		if (pockets.getPockets().containsKey(item)) {
			if(pockets.receiveItem(item).isEdible()) {
				pockets.receiveItem(item).use();
			} else {
				System.out.println("You can't eat that.");
			}
		}
		else {
			System.out.println("You don't have that :(");
		}
	}
}
