package game;

import java.util.Scanner;

/**
 * TalkAction.java
 * 
 * Class to implement talking to monsters and sphinxes.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class TalkAction implements Action{

	/**
	 * The room where the player is.
	 */
	private Room room;
	
	/**
	 * The player in the game.
	 */
	private Player p;
	
	/**
	 * The game being played.
	 */
	private Game game;
	
	/**
	 * User's input.
	 */
	private Scanner keyboard;
	
	/**
	 * Initializing talk action class.
	 * @param p    The player in the game.
	 * @param game The game being played.
	 */
	public TalkAction(Player p, Game game) {
		this.p = p;
		this.room = p.getCurrentRoom();
		this.game = game;
	}
	
	/**
	 * Print out an error message.
	 */
	public void takeAction() {
		System.out.println("Talk to whom?");	
	}

	/**
	 * The player talks to the monster in the room.
	 * The monster will give a riddle to the player first.
	 * If the player guesses wrongly, then there will be a fight against the monster.
	 * If the player guesses rightly, the monster will drop a key for the user to open a door.
	 * POSTCONDITION: There is a new key in the inventory.
	 */
	public void takeAction(String enemy) {
		keyboard = new Scanner(System.in);
		room = p.getCurrentRoom();
		Monster monster = room.getMonster(); // The monster in the room
		Sphinx sph = room.getSphinx();       // The sphinx in the room
		if (enemy.equals("to monster") && room.hasMonster()) {			
					
			System.out.println("\nThe monster" + monster.getDes() + ".");
			System.out.println("\"Hear my riddle! " + room.getMonster().getRiddle().getQuestion() + "\"");
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine(); // The user's guess
			
			if (guess.equals(monster.getRiddle().getAnswer())){
				if (monster.getStr()) {
					System.out.println("\"How did you know that???\"");
					System.out.println("The monster roars and the room around you fades away...");
					p.setCurrentRoom(room.getDoors("wow"));
					p.getCurrentRoom().getDoors("forward").setLocked(false);
					p.setEnding(1);
				} else {
					System.out.println("\"Hmmph, I suppose that answer will suffice.\"");
					System.out.println("The monster gave you the " +  monster.getKey().returnName()+"!");
					p.addToInventory(monster.getKey());
					room.placeMonster(null);
					System.out.println("The monster vanished into thin air!");
				}
			}
			else {
				Combat battle = new Combat(p, room.getMonster(), game); // Fight between the user and the monster
				battle.engage();
			}
		
		} else if (enemy.equals("to sphinx") && room.hasSph()) {
			System.out.println("\nThe sphinx" + sph.getDes() + ".");
			System.out.println("\"Hear my riddle, adventurer! " + room.getSphinx().getRiddle().getQuestion() + "\"");
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine().toLowerCase(); // The user's guess
			
			if (guess.equals(sph.getRiddle().getAnswer())){
				System.out.println("\"Well done, you have answered my riddle.  You may pass.\"");
				room.placeSphinx(null);
				if(sph.getKey() != null) {
					p.addToInventory(sph.getKey());
					System.out.println("The sphinx gives you a key.");
				} else {
					p.getCurrentRoom().getDoors("forward").setLocked(false);
				}
				System.out.println("The sphinx vanished into thin air!");
			} else {
				System.out.println("\"That answer is not correct... Would you like to guess again? (y/n)\"");
				
			}
		} else {
			System.out.println("There's no one here of that name!");
		} 
	}

}
