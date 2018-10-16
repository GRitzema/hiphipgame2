package game;

import java.util.Scanner;

public class HoldAction implements Action {
	
	Inventory pockets;
	
	private Scanner keyboard;
	
	public HoldAction(Inventory pockets) {
		this.pockets = pockets;
	}


	public void takeAction() {
		System.out.println("Hold what?");
	}

	public void takeAction(String item) {
        pockets.getFrom(item);
	}

}
