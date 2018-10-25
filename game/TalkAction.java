package game;

import java.util.Scanner;

public class TalkAction implements Action{

	private Room room;
	private Player p;
	private Combat battle;;
	
	public TalkAction(Player p, Room room) {
		this.p = p;
		this.room = room;
		this.battle = new Combat(p, room.getMonster());
	}
	
	public void takeAction() {
		System.out.println("Talk to whom?");
		
	}

	
	public void takeAction(String enemy) {
		Scanner keyboard = new Scanner(System.in);
		if (enemy.substring(0, 2).equals("to") && enemy.substring(3).equals("monster") && room.hasMonster()) {	
		System.out.println("Hear my riddle! " + room.getMonster().getRiddle());
		System.out.println("(What is your guess?)");
			String guess = keyboard.nextLine();
			battle.engage(guess);
		}
		else {
			System.out.println("There's no one there of that name!");
		} 
		
	}

}
