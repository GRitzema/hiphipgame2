package game;

import java.util.Scanner;

public class Combat {

	private Player p;
	private Monster m;
	private Inventory pockets;
	
	public Combat(Player p, Monster m) {
		this.p = p;
		this.m = m;
		this.pockets = p.getInventory();
	}
	
	
	public void monsterCombat() {		
		if (m.getHealth() >= 0) {
			double damage = Math.random()*10;
			p.setHealth(p.getHealth()-damage);
		System.out.println("The monster inflicted " + damage);
		System.out.println("You now have " + p.getHealth() + "hp!");
		}
	}
	
	public void playerCombat() {
		System.out.println("It is your turn! What will you do?");
		Scanner keyboard = new Scanner(System.in);		
		
		String turn = keyboard.nextLine();
		
		if (turn.substring(0,3).equals("eat") && p.getPockets().receiveItem(turn.substring(4)).isEdible()) {
			p.getPockets().getFrom(turn.substring(4)).use();
		}
		
		else if(turn.equals("fight")) {
			fight(p.getSword());
		}
		
		else {
			System.out.println("The monster is confused at what you are doing. You miss and it hits you anyway.");
			System.out.println(turn.substring(4));
			
			p.getPockets().displayInventory();
			
			
		}
	}
	
	public void fight(Sword sword) {
		double damage = 0;
		if (Math.random()<=0.2) {
			System.out.println("You missed " + m.getName() + "!");
		}
		else {
			if (sword == null) {
				damage = 5 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println("Your fists inflicted " + damage + " on " + m.getName());
			}			
			else if (sword.getMaterial().equals("wood")) {
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
		}
	}
	
	public void engage() {	
		
		System.out.println("Mwahaha, your ignorance shall make you pay!");
		while(m.getHealth() >= 0) {
			playerCombat();
			monsterCombat();
		}
		m.defeat();
	}
	
	
	
}
