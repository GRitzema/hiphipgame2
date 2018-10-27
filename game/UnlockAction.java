package game;

public class UnlockAction implements Action {
	
	private Player p;
	
	private Room door;

	public UnlockAction(Player p) {
		this.p = p;
	}
	
	public void takeAction(String substring) { 
		System.out.println("There is no " + substring.toLowerCase() + " to unlock.");
	}

	public void takeAction() {
		this.door = p.getCurrentRoom().getDoors("forward");
		if (door.getLocked()) {
			Key theKey = door.getKey();
			
			if (p.getInventory().contains(theKey)) {
				door.setLocked(false);
				System.out.println("The door is unlocked.");
			} else {
				System.out.println("You don't have the key to unlock the door.");
			}
		} else {
			System.out.println("There is nothing to unlock");
		}
	}

}