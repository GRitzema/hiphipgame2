package game;

import java.util.HashMap;

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
    
    /**
     * Inventory class
     */
    private Inventory pockets;
    
    /**
     * Map of possible actions
     */
    private HashMap<String, Action> actions = new HashMap<String, Action>();
    
    private Room room;
    
    /**
     * Plain constructor
     */
    public Parser(Game game) {
    	keyboard = new Scanner (System.in);
    	room = game.getCurrentRoom();
    	pockets = game.getPockets();
        actions.put("inventory",new InventoryAction(pockets, game));
        actions.put("look", new LookAction(room));
        actions.put("help", new HelpAction());
        actions.put("go", new GoAction(game, room));
        //actions.put("use", new UseAction(pockets));
        //actions.put("hold", HoldAction());
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
        
        if (command.substring(0,2).equals("go")) {
        	actions.get("go").takeAction(command.substring(3));
        	System.out.println(command.substring(3));
        } else {
	        if (actions.containsKey(command)) {
	        	actions.get(command).takeAction();
	        } else {
	        	System.out.println("I do not know how to " + command + ".");
	        }
        }
        
        System.out.println("");
    }
}
