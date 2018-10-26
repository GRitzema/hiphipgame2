package game;

import java.util.Scanner;

public class UseAction implements Action {

	
	private Player p;
	private Inventory pockets;
	
	
	public UseAction(Player p) {
		this.p = p;
		this.pockets = p.getInventory();
	}

	@Override
	public void takeAction() {
		System.out.print("Use what?");
	}

	
	public void takeAction(String item) {
		if (pockets.getPockets().containsKey(item)) {
			pockets.receiveItem(item).use();
		}
		else {
			System.out.println("You can't use that :(");
		}
	}

}
