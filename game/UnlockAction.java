package game;

/**
 * UnlockAction.java
 * 
 * Class to set up rooms for refactoring
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class UnlockAction implements Action {
	
	/**
	 * The current player
	 */
	private Player p;
	
	/**
	 * the room to unlock
	 */
	private Room door;

	/**
	 * Constructor
	 * @param p: the current player
	 */
	public UnlockAction(Player p) {
		this.p = p;
	}
	
	/**
	 * Prints an error message
	 */
	public void takeAction(String substring) { 
		System.out.println("There is no " + substring.toLowerCase() + " to unlock.");
	}

	/**
	 * Unlocks the door with the corresponding key
	 * Unlocks a door by calling a method from the Room Class to make a connection
	 * POSTCONDITION: the door is now unlocked and the connection between rooms is made
	 */
	public void takeAction() {
		this.door = p.getCurrentRoom().getDoors("forward");
		if (door.getLocked()) {
			Key theKey = door.getKey();     //the needed key to unlock the room
			
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