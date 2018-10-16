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
		
	}

	@Override
	public void takeAction(String substring) {
	
        game.getPockets().getFrom(item);
	}

}
