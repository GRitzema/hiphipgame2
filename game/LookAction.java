package game;

public class LookAction implements Action {

	Room room;
	
	public LookAction(Room room) {
		this.room = room;
	}

	public void takeAction() {
		System.out.println(room.getInRoom());
	}

	@Override
	public void takeAction(String substring) {
		// TODO Auto-generated method stub
		
	}

}
