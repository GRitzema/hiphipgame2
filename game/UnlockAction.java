package game;

import java.util.Scanner;

public class UnlockAction implements Action {
	
	private Player p;
	
	private Room door;

	public UnlockAction(Player p, Room door) {
		this.p = p;
		this.door = door;
	}
	
	public void takeAction(String command) { }

	public void takeAction() {
		Key theKey = door.getKey();
		System.out.println(theKey.returnName());
		if (p.getInventory().contains(theKey)) {
			theKey.use();
			System.out.println("The door is unlocked.");
		} else {
			System.out.println("You don't have the key to unlock the door.");
		}
	}

}