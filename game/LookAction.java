package game;

public class LookAction implements Action {

	Room room;
	Player player;
	
	public LookAction(Player player) {
		this.player = player;
	}

	public void takeAction() {
		room = player.getCurrentRoom();
		System.out.println(room.getInRoom());
	}

	
	public void takeAction(String substring) { }

}
