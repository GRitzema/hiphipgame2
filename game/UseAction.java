package game;

import java.util.Scanner;

public class UseAction implements Action {

	Inventory pockets;
	
	private Scanner keyboard;
	
	public UseAction(Inventory pockets) {
		this.pockets = pockets;
	}

	@Override
	public void takeAction() {
		System.out.print("Use what?");
	}

	@Override
	public void takeAction(String item) {
		
	}

}
