package game;

public class PickUpAction implements Action{

	private Room room;
	private Player p;
		
	public PickUpAction(Player p) {
		this.p = p;
	}

	public void takeAction() {
		System.out.println("Pick up what?");
	}

	public void takeAction(String substring) { 
		room = p.getCurrentRoom();
		if (room.isInside(substring)) {
			Item x = room.getInside().get(substring);
			p.addToInventory(x);
			Item y = room.takeOut(substring);
			System.out.println("You picked up the " + substring);
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
