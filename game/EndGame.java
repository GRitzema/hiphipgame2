package game;

public class EndGame implements Action {
	
	private Player p;
	
	private Game g;

	public EndGame(Player p, Game g) {
		this.p = p;
		this.g= g;
	}

	
	public void takeAction() {
		System.out.println("Open what?");		
	}


	public void takeAction(String substring) {	
		if (substring.equals("safe box")) {
			end();
		} else {
			System.out.println("You don't know how to open that.");
		}
	}
	
	private void end() {
		
		System.out.println("\nAs you pick up Perry, he looks into your eyes and judges you...\n");
		
		int k = p.getKills();
		
		if (k == 0) {
			noKills();
		} else if (k < 3 && k !=0) {
			halfKills();
		} else if (k == 5){
			allKills();
		}else {
			kills();
		}
		
		switch (p.getEnding()) {
		case 1:
			System.out.println("You successfully outsmarted the monsters on the Path of Strength and found the shortcut room!");
			break;
		case 2:
			System.out.println("You fought and defeated all the monsters on the Path of Strength, emerging victorious!");
			break;
		case 3:
			System.out.println("You outsmarted the sphinxes on the Path of Knowledge!  Congratulations, wise one.");
			break;
		}
		
		System.out.println("\n Thank you for playing SPHINX! \n GAME OVER");
		g.finishGame();
	}
	
	private void noKills() {
		System.out.println("Congrats!  You finished the game without killing any monsters!");
	}
	
	private void halfKills() {
		System.out.println("You killed a few monsters, but overall you proceeded peacefully.");
	}
	
	private void kills() {
		System.out.println("Well... I mean, you didn't kill ALL the monsters...");
	}
	
	private void allKills() {
		System.out.println("You killed all the monsters in your way...are you sure you aren't the monster?");
	}

}
