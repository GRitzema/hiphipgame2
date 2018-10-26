package game;

public class InventoryAction implements Action {
	
	Inventory pockets;
	Game game;
	
	public InventoryAction(Inventory pockets, Game game) {
		this.pockets = pockets;
		this.game = game;
	}

	public void takeAction() {
		System.out.println("In your pockets there are:");
    	pockets.displayInventory();
    	
	}

	public void takeAction(String substring) {
		//nothing happens
	}

}
