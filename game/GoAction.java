package game;

/**
 * GoAction.java
 * 
 * Class to implement the action to go another room.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class GoAction implements Action {
	
	/**
	 * The player in the game.
	 */
	private Player player;
		
	/**
	 * Initializing the go action class.
	 * @param p The player in the game.
	 */
	public GoAction(Player p) {
		player = p;
	}

	/**
	 * Moving the player to the next room.
	 * @param command The direction where the player wants to go.
	 * POSTCONDITION: The player is moving to another room.
	 */
	public void takeAction(String command) {

		Room room = player.getCurrentRoom();     // The room the player is currently in.
		Room nextRoom = room.getDoors(command);  // The room the player is going to.
				
		if (nextRoom == null) {
            System.out.println("There is no door in that direction.");
		} else if (nextRoom.getLocked() == true) {
			System.out.println("The door is locked.");
		} else {
            if (nextRoom.getDescription().equals("a bedroom. Dr. Ryken's Perry is in a safe box.")) {
            	if (room.getDescription().equals("what looks like a basement.")) {
            		player.setEnding(2);
            	}
            	if (room.getDescription().equals("the living room of a small cabin.")) {
            		player.setEnding(3);
            	}
            }
            player.setCurrentRoom(nextRoom);
        }
		
	}

	/**
	 * Printing out a message.
	 */
	public void takeAction() {
		System.out.println("Go where?");
	}
}