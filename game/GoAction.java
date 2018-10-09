package game;

import java.util.Scanner;

public class GoAction implements Action {

	private Scanner keyboard;
	
	Room room;
	
	Game game;

	public GoAction(Game game, Room room) {
		keyboard = new Scanner (System.in);
		this.game = game;
		this.room = room;
	}

	@Override
	public void takeAction() {
		
		System.out.print("Which direction do you want to go? --> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command
        
		if (command.equals("north") || command.equals("south") 
	            || command.equals("west") || command.equals("east")) {
	            Room nextRoom;   // the room we're moving to
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
	            if (nextRoom == null) 
	                System.out.println("There is no door in that direction.");
	            else
	                game.setCurrentRoom(nextRoom);
		}
	}

}
