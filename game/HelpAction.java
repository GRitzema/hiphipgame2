package game;

public class HelpAction implements Action {

	public void takeAction() {
		
		System.out.println("Commands:");
    	System.out.println("go : move between rooms");
    	System.out.println("look : observe the room you're in");
    	System.out.println("inventory : check what's in your pockets");
    	System.out.println("use : use one of the objects in your hands");
    	System.out.println("hold : hold an item in your inventory in your hands");
    	
	}

}
