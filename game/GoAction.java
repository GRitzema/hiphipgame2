package game;

public class GoAction implements Action {
	
	private Player player;
		
	public GoAction(Player p) {
		player = p;
	}

	public void takeAction(String command) {

		Room room = player.getCurrentRoom();
		Room nextRoom = room.getDoors(command);
				
		if (nextRoom == null) {
            System.out.println("There is no door in that direction.");
		} else if (nextRoom.getLocked() == true) {
			System.out.println("The door is locked.");
		} else {
            player.setCurrentRoom(nextRoom);
        }
	}

	public void takeAction() {
		System.out.println("Go where?");
	}
}