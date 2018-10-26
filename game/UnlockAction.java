package game;

import java.util.Scanner;

public class UnlockAction implements Action {
	
	private Player p;
	
	private Room door;

	public UnlockAction(Player p) {
		this.p = p;
	}
	
	public void takeAction(String command) { }

	public void takeAction() {
		this.door = p.getCurrentRoom().getDoors("forward");
		Key theKey = door.getKey();
		System.out.println(theKey.returnName());
		
		if (p.getInventory().contains(theKey)) {
			door.setLocked(false);
			System.out.println("The door is unlocked.");
		} else {
			System.out.println("You don't have the key to unlock the door.");
		}
	}

}