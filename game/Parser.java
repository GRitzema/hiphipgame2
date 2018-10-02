package game;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

import java.util.Scanner;

public class Parser {

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;
    
    private Inventory pockets;

    /**
     * Plain constructor
     */
    public Parser() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
        // The room that the user is in.
        Room room = game.getCurrentRoom();
        pockets = game.inventory();

        System.out.println("You are in " + room.getDescription());

        System.out.print("Enter command--> ");
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
        } else if (command.equals("look")) {
        	System.out.println(room.getInRoom());
        } else if (command.equals("inventory")) {
        	System.out.println("In your pockets there are:");
        	pockets.displayInventory();
        } else if (command.equals("help")) {
        	System.out.println("Commands:");
        	System.out.println("north/south/east/west : move between rooms");
        	System.out.println("look : observe the room you're in");
        	System.out.println("inventory : check what's in your pockets");
        
        /*}else if (command.equals("use")) {
        	System.out.println("Use what?");
        	String what = keyboard.nextLine().toLowerCase();
        	if (pockets.checkInventory(what) && ) {
        		rooms.setNorth(rooms[1]);
        	}*/
        } else
            System.out.println("I do not know how to " + command + ".");

    }


}
