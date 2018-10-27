package game;

import java.util.Scanner;

/**
 * TalkAction.java
 * 
 * Class to implement talking to monsters and sphinxes
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class TalkAction implements Action{

	private Room room;
	private Player p;
	private Game game;
	
	
	public TalkAction(Player p, Game game) {
		this.p = p;
		this.room = p.getCurrentRoom();
		this.game = game;
	}
	
	public void takeAction() {
		System.out.println("Talk to whom?");	
	}

	
	public void takeAction(String enemy) {
		Scanner keyboard = new Scanner(System.in);
		room = p.getCurrentRoom();
		Monster monster = room.getMonster();
		Sphinx sph = room.getSphinx();
		if (enemy.equals("to monster") && room.hasMonster()) {			
					
			System.out.println("\nThe monster" + monster.getDes() + ".");
			System.out.println("\"Hear my riddle! " + room.getMonster().getRiddle().getQuestion() + "\"");
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine();
			
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
				Combat battle = new Combat(p, room.getMonster(), game);
				battle.engage();
			}
		
		} else if (enemy.equals("to sphinx") && room.hasSph()) {
			System.out.println("\nThe sphinx" + sph.getDes() + ".");
			System.out.println("\"Hear my riddle, adventurer! " + room.getSphinx().getRiddle().getQuestion() + "\"");
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine().toLowerCase();
			
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
				System.out.println("\"That answer is not correct...\"");
			}
		} else {
			System.out.println("There's no one here of that name!");
		} 
	}

}
