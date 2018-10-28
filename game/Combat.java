package game;

/**
 * Combat.java
 * 
 * Class to implement the action to fight a monster.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

import java.util.Scanner;

public class Combat {

	/**
	 * The player in the game.
	 */
	private Player p;
	
	/**
	 * The monster to fight.
	 */
	private Monster m;
	
	/**
	 * The game being played.
	 */
	private Game game;

	/**
	 * The input from user.
	 */
	private Scanner keyboard;
	
	/**
	 * Constructor.
	 * @param p    The player in the game.
	 * @param m    The monster in the game.
	 * @param game The game being played.
	 */
	public Combat(Player p, Monster m, Game game) {
		this.p = p;
		this.m = m;
		this.game = game;
	}
	
	/**
	 * The monster attacks the player.
	 * POSTCONDITION: Decreasing the player's health point and print out the result of the fight.
	 */
	public void monsterCombat() {		
		if (m.getHealth() >= 0) {
			double damage = Math.round(Math.random()*10);
			p.setHealth(p.getHealth()-damage);
		System.out.println("The monster inflicted " + damage + " damage!");
		System.out.println("You now have " + p.getHealth() + " hp!");
		}
	}
	
	/**
	 * The player's action toward the monster:
	 * Prints out the items in the inventory, fight the monster in the room, 
	 * print out a "help" instruction, or print out an error message.
	 * POSTCONDITION: Printing out instructions or descriptions based on the user's choice.
	 */
	public void playerCombat() {
		
		System.out.println("It is your turn! What will you do?");
		keyboard = new Scanner(System.in);		
		
		
		boolean done = false;
		
		while (!done) {
			String turn = keyboard.nextLine().toLowerCase();
			Item item = null;
			
			if (turn.length()>4) {
				item = p.getPockets().receiveItem(turn.substring(4));
			}
			if (turn.equals("inventory")) {
				p.getPockets().displayInventory();
			}
		
			else if (turn.length() > 3 && turn.substring(0,3).equals("eat") && item != null && item.isEdible()) {
				item.use();
				done = true;
			}
		
			else if(turn.equals("fight")) {
				fight(p.getSword());
				done = true;
			}
			
			else if(turn.equals("help")) {
				System.out.println("In combat, you can use inventory, take a turn with eat (an item) or fight");
			}
			
			else {
				System.out.println("The monster is confused at what you are doing. You miss and it hits you anyway.");
				done = true;
			}
		}
	}
	
	/**
	 * The player fights the monster.
	 * The sword being used in the combat has different material options that give different damage points.
	 * @param sword The sword used for fighting.
	 * POSTCONDITION: Decreasing the monster's health point.
	 */
	public void fight(Sword sword) {
		double damage = 0;
		if (Math.random()<=0.2) {
			System.out.println("You missed the monster!");
		}
		else {
			if (sword == null) {
				damage = Math.round(5 + Math.random()*10);
				m.setHealth(m.getHealth()-damage);
				System.out.println("Your fists inflicted " + damage + " damage on the monster!");
			}			
			else {
				if (sword.getMaterial().equals("wood")) {
					damage = Math.round(10 + Math.random()*10);
				}
				else if (sword.getMaterial().equals("iron")) {
					damage = Math.round(25 + Math.random()*10);
				}
				else if (sword.getMaterial().equals("diamond")) {
					damage = Math.round(50 + Math.random()*10);
				}	
				m.setHealth(m.getHealth()-damage);
				System.out.println("The monster took " + damage + " damage!");
			}
		}
	}
	
	/**
	 * The monster's action toward the player.
	 * Decreases the player's health if the player still has health point left.
	 * The player is defeated and the game is over if there is no health point left.
	 * POSTCONDITION: Either the player's health is decreased or the player is defeated.
	 */
	public void engage() {	
		
		System.out.println("Mwahaha, your ignorance shall make you pay!");
		while(m.getHealth() >= 0 && p.getHealth()>=0) {
			playerCombat();
			monsterCombat();
		}
		if (p.getHealth() <=0) {
			System.out.println("You were defeated!");
			game.finishGame();
		}
		m.defeat();
	}
	
	
	
}
