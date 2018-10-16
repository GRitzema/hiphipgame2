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
		
		if(doors.containsKey(command)){
			nextRoom = doors.get(command);
		} else {
			System.out.println("Go where?");
			nextRoom = null;
		}
		
		if (nextRoom == null) 
            System.out.println("There is no door in that direction.");
        else
            game.setCurrentRoom(nextRoom);

        
		/**if (command.equals("forward") || command.equals("backward") 
	            || command.equals("left") || command.equals("right")) {
	            Room nextRoom;
	            if (command.equals("north"))
	                nextRoom = room.getNorth();
	            else if (command.equals("south"))
	                nextRoom = room.getSouth();
	            else if (command.equals("west"))
	                nextRoom = room.getWest();
	            else if (command.equals("east"))
	                nextRoom = room.getEast();
	            else if (command.equals("up"))
	            	nextRoom = room.getUp();
	            else if (command.equals("down"))
	            	nextRoom = room.getDown();
	            else
	            	nextRoom = room.getTunnel();
		}
		if (nextRoom == null) 
            System.out.println("There is no door in that direction.");
        else
            game.setCurrentRoom(nextRoom);
	            
	            */
	}

	public void takeAction() {
		System.out.println("Go where?");
	}
}
