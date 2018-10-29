package game;

/**
 * PickUpAction.java
 * 
 * Class to implement the action to pick up items and money in a room.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class PickUpAction implements Action{

	/**
	 * The room where the item that wants to be picked up is.
	 */
	private Room room;
	
	/**
	 * The player in the game.
	 */
	private Player p;
		
	/**
	 * Initializing the pick up action class.
	 * @param p The player in the game.
	 */
	public PickUpAction(Player p) {
		this.p = p;
	}

	/**
	 * Printing out a message.
	 */
	public void takeAction() {
		System.out.println("Pick up what?");
	}

	/**
	 * Picking up an item.
	 * PRECONDITION: The item is in the room.
	 * POSTCONDITION: The item is in the inventory.
	 */
	public void takeAction(String substring) { 
		room = p.getCurrentRoom();
		if (room.isInside(substring)) {
			Item x = room.getInside().get(substring); // The item that wants to be picked up.
			p.addToInventory(x);
			System.out.println("You picked up the " + substring);
			room.takeOut(substring);
		}
		else if (substring.equals("money") && room.getCash().getAmount() != 0) {
			p.setWealth(p.getWealth() + room.getCash().getAmount());
			System.out.println("You picked up " + room.getCash().getAmount() + " dollars. You now have " + p.getWealth() + " dollars");
			room.setCash(new Money(0));
			
		}
		 else {
			System.out.println("There is no such thing in the room.");
		}  
		
		
	}

}
