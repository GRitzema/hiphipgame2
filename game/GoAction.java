package game;

import java.util.HashMap;
import java.util.Scanner;

public class GoAction implements Action {
	
	private Room room;
	
	private Game game;
	
	private HashMap<String,Room> doors;
	
	public GoAction(Game game, Room room) {
		this.game = game;
		this.room = room;
		this.doors = room.getDoors();
	}

	public void takeAction(String command) {
		
		Room nextRoom;
		
		if (nextRoom == null) 
            System.out.println("There is no door in that direction.");
        else
            game.setCurrentRoom(nextRoom);
	}

	public void takeAction() {
		System.out.println("Go where?");
	}
}
