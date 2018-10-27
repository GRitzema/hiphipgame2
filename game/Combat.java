package game;

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
	 * Constructor.
	 * @param p    The player in the game.
	 * @param m    The monster in the game.
	 * @param game The game being played.
	 */
	public Combat(Player p, Monster m, Game game) {
		this.p = p;
		this.m = m;
		this.pockets = p.getInventory();
		this.game = game;
	}
	
	
	public void monsterCombat() {		
		if (m.getHealth() >= 0) {
			double damage = Math.round(Math.random()*10);
			p.setHealth(p.getHealth()-damage);
		System.out.println("The monster inflicted " + damage + " damage!");
		System.out.println("You now have " + p.getHealth() + " hp!");
		}
	}
	
	public void playerCombat() {
		
		System.out.println("It is your turn! What will you do?");
		Scanner keyboard = new Scanner(System.in);		
		
		String turn = keyboard.nextLine();
		Item item = null;;
		
		if (turn.length()>4) {
			item = p.getPockets().receiveItem(turn.substring(4));
		}
		
		
		if (turn.length() > 3 && turn.substring(0,3).equals("eat") && item != null && item.isEdible()) {
			item.use();
		}
		
		else if(turn.equals("fight")) {
			fight(p.getSword());
		}
		
		else {
			System.out.println("The monster is confused at what you are doing. You miss and it hits you anyway.");
		}
		
	}
	
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
