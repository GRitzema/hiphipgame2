package game;

/**
 * LookAction.java
 * 
 * Class to implement the action to look for items and money in a room
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class LookAction implements Action {

	/**
	 * The room of interest
	 */
	private Room room;
	
	/**
	 * The current player
	 */
	private Player p;
	
	/**
	 * Constructor
	 * @param p: the current player
	 */
	public LookAction(Player p) {
		this.p = p;		
	}

	/**
	 * Performs the look action to find money and items in the current room
	 * Calls method getInRoom() in room class to print the existing items in the room
	 * Prints current money in the room if any exists
	 */
	public void takeAction() {	
		room = p.getCurrentRoom();            //sets the room to the current room the player is in
		System.out.println(room.getInRoom());
		
		if (room.getCash().getAmount() != 0) {
			System.out.println("Also, there are " + room.getCash().getAmount() + " dollars in the room.");
		}
	}

	/**
	 * Prints a given error message
	 */
	public void takeAction(String substring) { 
		System.out.println("You do not know how to do that");
	}
}
