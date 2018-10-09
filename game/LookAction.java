package game;

public class LookAction implements Action {

	Room room;
	
	public LookAction(Room room) {
		this.room = room;
	}

	public void takeAction() {
		System.out.println(room.getInRoom());
	}

}
