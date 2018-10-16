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

	
	public void takeAction(String item) {
		
		Item thing = pockets.getFrom(item);
		
		if (thing.returnType().equals(null)) {
			System.out.println("You do not have that item in your inventory.");
		} else {
			//insert code here
			//implement items/ use them here
		}
	}

}
