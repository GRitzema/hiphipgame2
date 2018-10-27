package game;

public class LookAction implements Action {

	private Room room;
	private Player p;
	
	public LookAction(Player p) {
		this.p = p;
		
	}

	public void takeAction() {	
		room = p.getCurrentRoom();
		System.out.println(room.getInRoom());
		
		if (room.getCash().getAmount() != 0) {
			System.out.println("Also, there are " + room.getCash().getAmount() + " dollars in the room.");
		}
	}

	
	public void takeAction(String substring) { 
		System.out.println("You do not know how to do that");
	}
}
