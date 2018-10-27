package game;

public class EatAction implements Action{
	
	/**
	 * The player in the game.
	 */
	private Player p;
	
	/**
	 * The pocket that the player has.
	 */
	private Inventory pockets;
	
	/**
	 * Initializing eat action class.
	 * @param p The player in the game
	 */
	public EatAction(Player p) {
		this.p = p;
		this.pockets = p.getInventory();
	}

	public void takeAction() {
		System.out.print("Eat what?");
	}

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
