package game;

import java.util.Scanner;

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
		if (enemy.equals("to monster") && room.hasMonster()) {			
					
			System.out.println("The monster" + monster.getDes() + ".");
			System.out.println("\"Hear my riddle! " + room.getMonster().getRiddle().getQuestion() + "\"");
			System.out.print("(What is your guess?): ");
			String guess = keyboard.nextLine();
			
			if (guess.equals(monster.getRiddle().getAnswer())){
				System.out.println("Hmmph, I suppose that answer will suffice.");
				System.out.println("The monster gave you the " +  monster.getKey().returnName()+"!");
				p.addToInventory(monster.getKey());
				room.placeMonster(null);
				System.out.println("The monster vanished in thin air!");
			}
			else {
				Combat battle = new Combat(p, room.getMonster(), game);
				battle.engage();
			}
		
		}
		else {
			System.out.println("There's no one here of that name!");
		} 
	}

}
