package game;

import java.util.Scanner;

public class HoldAction implements Action {
	
	Game game;
	
	private Scanner keyboard;
	
	public HoldAction(Game game) {
		this.game = game;
	}

	@Override
	public void takeAction() {
		System.out.print("What do you want to hold?--> ");
        String item = keyboard.nextLine().toLowerCase();  

        game.getPockets().getFrom(item);
	}

	@Override
	public void takeAction(String substring) {
		// TODO Auto-generated method stub
		
	}

}
