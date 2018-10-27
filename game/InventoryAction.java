package game;

public class InventoryAction implements Action {
	
	private Player p;
	private Inventory pockets;
	
	public InventoryAction(Player p) {
		this.p = p;
		this.pockets = p.getPockets();
	}

	public void takeAction() {
		System.out.println("In your pockets there are:");
    	pockets.displayInventory();
    	System.out.println("Also, you have " + p.getWealth() + " dollars.");
    	
	}

	public void takeAction(String substring) {
		System.out.println("You do not know how to do that.");
	}

}
