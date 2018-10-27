package game;

public class CheckAction implements Action{

	/**
	 * The player in the game.
	 */
	private Player p;
	
	/**
	 * The pockets that the player has.
	 */
	private Inventory pockets;
	
	public CheckAction(Player p) {
		this.p = p;
		this.pockets = p.getPockets();
	}

	
	public void takeAction() {
		System.out.println("Check what?");
		
	}

	/**
	 * Giving the description of the item.
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
