package game;

import java.util.Scanner;

public class Combat {

	private Player p;
	private Monster m;
	private Inventory pockets;
	
	public Combat(Player p, Monster m, Inventory pockets) {
		this.p = p;
		this.m = m;
	}
	
	
	public void monsterCombat() {		
		if (m.getHealth() >= 0) {
			p.setHealth(p.getHealth()-(Math.random()*10));
		}
	}
	
	public void playerCombat(Sword sword) {
		Scanner keyboard = new Scanner(System.in);		
		
		String turn = keyboard.nextLine();
		
		if (turn.substring(0,3).equals("eat ") && pockets.getFrom(turn.substring(4)).isEdible()) {
			pockets.getFrom(turn.substring(4)).use();
		}
		
		else if(turn.equals("fight")) {
			fight(sword);
		}
		
		else {
			System.out.println("The monster is confused at what you are doing. You miss and it hits you anyway.");
		}
	}
	
	public void fight(Sword sword) {
		double damage = 0;
		if (Math.random()>=0.2) {
			System.out.println("You missed " + m.getName() + "!");
		}
		else {
			if (sword.getMaterial().equals("wood")) {
				damage = 10 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took " + damage + "!");
			}
			else if (sword.getMaterial().equals("iron")) {
				damage = 25 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took " + damage + "!");
			}
			else if (sword.getMaterial().equals("diamond")) {
				damage = 50 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took" + damage + "!");
			}
			else 
				damage = 5 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println("Your fists inflicted " + damage + " on " + m.getName());
		}
	}
	
	public void engage(String guess) {
		if (guess.equals(m.getRiddle().getAnswer())){
			System.out.println("Hmmph, I suppose that answer will suffice.");
			System.out.println(m.getName() + "gave you the " + m.getKey() + "!");
			pockets.addToInventory(m.getKey());
		}
		else {
			System.out.println("Mwahaha, your ignorance shall make you pay!");
			while(m.getHealth() >= 0) {
				playerCombat(p.getSword());
				monsterCombat();
			}
		}
	}
	
}
