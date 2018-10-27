package game;

/**
 * HelpAction.java
 * 
 * Class to implement the help action.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class HelpAction implements Action {
	/**
	 * Prints out the list of possible commands and their descriptions
	 */
	public void takeAction() {
		
		System.out.println("Possible Commands:");
    	System.out.println("go forward/backward/left/right : move between rooms");
    	System.out.println("look : observe the room you're in");
    	System.out.println("inventory : check what's in your pockets");
    	System.out.println("use : use one of the objects in your hands");
    	System.out.println("talk to: speak to a being in the room with you");
    	System.out.println("fight : engage in combat with a being in the room with you");
    	System.out.println("unlock: unlock the door that is locked"); 
    	System.out.println("pickup : pickup the thing in the room");
    	System.out.println("eat : eat a food item in your inventory");
    	System.out.println("shop : shop in a shop in in the room");

	}
	/**
	 * Prints an error message
	 */
	public void takeAction(String substring) {
		System.out.println("You do not know how to do that.");
	}

}
