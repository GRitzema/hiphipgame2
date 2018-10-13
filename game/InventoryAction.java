package game;

public class InventoryAction implements Action {
	
	Inventory pockets;
	Game game;
	
	public InventoryAction(Inventory pockets, Game game) {
		this.pockets = pockets;
		this.game = game;
	}

	public void takeAction() {
		System.out.println("\nIn your pockets there are:");
    	pockets.displayInventory();
    	
    	System.out.print("\nYou are holding ");
    	if (game.getLeft() != null) {
    		System.out.print(game.getLeft().returnName() + " in your left hand and ");
    	}
    	if (game.getRight() != null) {
    		System.out.println(game.getRight().returnName() + " in your right hand.\n");
    	}
	}

}
