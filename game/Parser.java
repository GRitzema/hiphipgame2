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
     * Inventory class.
     */
    private Inventory pockets;
    
    /**
     * Map of possible actions.
     */
    private HashMap<String, Action> actions = new HashMap<String, Action>();
    
    /**
     * Room class.
     */
    private Room room;
    
    /**
     * Player class.
     */
    private Player player;
    
    /**
     * Monster class.
     */
    private Monster monster;
    
    /**
     * Plain constructor.
     */
    public Parser(Game game) {
    	player = game.getPlayer();
    	keyboard = new Scanner (System.in);
    	pockets = player.getPockets();
        actions.put("inventory",new InventoryAction(pockets, game));
        actions.put("look", new LookAction(player));
        actions.put("help", new HelpAction());
        actions.put("go", new GoAction(player));
        actions.put("use", new UseAction(pockets));
        actions.put("talk", new TalkAction(player));
        actions.put("fight", new FightAction(player, monster));
        actions.put("unlock", new UnlockAction(player));
        actions.put("pickup", new PickUpAction(player));
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
        // The room that the user is in.
        Room room = player.getCurrentRoom();
        pockets = player.getPockets();
        
        System.out.println("You are in " + room.getDescription());

        System.out.print("Enter command--> ");
        String command;
        String extra = "ahem";
        
        String full = keyboard.nextLine().toLowerCase();  // user's command
        if (full.indexOf(' ') != -1) {
	        command = full.substring(0, full.indexOf(' '));
	        extra = full.substring(full.indexOf(' ') + 1);
        } else {
        	command = full;
        }
        
        if (actions.containsKey(command) && extra.equals("ahem")) {
        	actions.get(command).takeAction();
        } else if (actions.containsKey(command) && !extra.equals("ahem")){
        	actions.get(command).takeAction(extra);
        } else {
        	System.out.println("You do not know how to " + command + ".");
        }
                
        System.out.println("");
        
    }
}
