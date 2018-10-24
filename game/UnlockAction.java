package game;

import java.util.Scanner;

public class UnlockAction implements Action {
	
	private Inventory pocket;
	
	private Room door;

	public UnlockAction(Inventory pocket, Room door) {
		this.pocket = pocket;
		this.door = door;
	}
	
	public void takeAction(String command) { }

	public void takeAction() {
		Key theKey = door.getKey();
		if (pocket.contains(theKey)) {
			theKey.use();
			System.out.println("The door is unlocked.");
		} else {
			System.out.println("You don't have the key to unlock the door.");
		}
	}

}
