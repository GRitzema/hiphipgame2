package game;

import java.util.Scanner;

public class TalkAction implements Action{

	private Room room;
	private Player p;
	
	
	public TalkAction(Player p) {
		this.p = p;
		this.room = p.getCurrentRoom();
		
	}
	
	public void takeAction() {
		System.out.println("Talk to whom?");	
	}

	
	public void takeAction(String enemy) {
		Scanner keyboard = new Scanner(System.in);
		room = p.getCurrentRoom();
		Monster monster = room.getMonster();
		if (enemy.equals("to monster") && room.hasMonster()) {			
					
			System.out.println("Hear my riddle! " + room.getMonster().getRiddle().getQuestion());
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine();
			
			if (guess.equals(monster.getRiddle().getAnswer())){
				System.out.println("Hmmph, I suppose that answer will suffice.");
				System.out.println(monster.getName() + " gave you the " +  monster.getKey().returnName()+"!");
				p.addToInventory(monster.getKey());
			}
			else {
				Combat battle = new Combat(p, room.getMonster());
				battle.engage();
			}
		
		}
		else {
			System.out.println("There's no one here of that name!");
		} 
	}

}
