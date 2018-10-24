package game;

public class PickUpAction implements Action{

	private Room room;
	private Inventory pockets;
		
	public PickUpAction(Room room, Inventory pockets) {
		this.room = room;
		this.pockets = pockets;
	}

	public void takeAction() {
		System.out.println("Pick up what?");
	}

	public void takeAction(String substring) { 
		if (room.isInside(substring)) {
			Item x = room.getInside().get(substring);
			pockets.addToInventory(x);
		} else {
			System.out.println("There is no such thing in the room");
		}
	}

}
