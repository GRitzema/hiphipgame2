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
    	
    	System.out.println("In your hands you are holding:");
    	if (game.getLeft() != null) {
    		System.out.println(game.getLeft().returnName() + " in your left hand");
    	}
    	if (game.getRight() != null) {
    		System.out.println(game.getRight().returnName() + " in your right hand");
    	}
    	if(game.getRight() == null && game.getLeft() == null) {
    		System.out.println("nothing");
    	}
	}

}
