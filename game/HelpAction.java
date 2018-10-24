package game;

public class HelpAction implements Action {

	public void takeAction() {
		
		System.out.println("Possible Commands:");
    	System.out.println("go forward/backward/left/right : move between rooms");
    	System.out.println("look : observe the room you're in");
    	System.out.println("inventory : check what's in your pockets");
    	System.out.println("use : use one of the objects in your hands");
    	System.out.println("talk : speak to a being in the room with you");
    	System.out.println("fight : engage in combat with a being in the room with you");
    	System.out.println("unlock: unlock the door that is locked"); 
    	System.out.println("pick up : pick up the thing in the room");
	}

	public void takeAction(String substring) {
			//nothing happens	
	}

}
