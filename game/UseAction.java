package game;

import java.util.Scanner;

public class UseAction implements Action {

	Game game;
	
	private Scanner keyboard;
	
	public UseAction(Game game) {
		this.game = game;
	}

	@Override
	public void takeAction() {
		System.out.print("Use what?");
	}

	@Override
	public void takeAction(String item) {
		
	}

}
