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
            if (nextRoom.getDescription().equals("a bedroom. Dr. Ryken's Perry is in a safe box.")) {
            	if (room.getDescription().equals("what looks like a basement.")) {
            		player.setEnding(2);
            	}
            	if (room.getDescription().equals("the living room of a small cabin.")) {
            		player.setEnding(3);
            	}
            }
            player.setCurrentRoom(nextRoom);
        }
		
	}

	public void takeAction() {
		System.out.println("Go where?");
	}
}