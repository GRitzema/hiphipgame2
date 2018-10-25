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
		} else {
			System.out.println("There is no such thing in the room");
		}  
	}

}
