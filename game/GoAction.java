package game;

import java.util.HashMap;
import java.util.Scanner;

public class GoAction implements Action {
	
	private Player player;
	
	private HashMap<String,Room> doors;
	
	public GoAction(Player p) {
		player = p;
	}

	public void takeAction(String command) {

		Room room = player.getCurrentRoom();
		Room nextRoom = room.getDoors(command);
				
		if (nextRoom == null) {
            System.out.println("There is no door in that direction.");
		} else {
            player.setCurrentRoom(nextRoom);
        }
	}

	public void takeAction() {
		System.out.println("Go where?");
	}
}
