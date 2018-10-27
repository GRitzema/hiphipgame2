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
		} else if (k < 2 && k !=0) {
			halfKills();
		} else if (k == 3){
			allKills();
		}else {
			kills();
		}
		
		System.out.println("\n Thanks for playing! \n GAME OVER");
		g.finishGame();
	}
	
	private void noKills() {
		System.out.println("Congrats!  You finished the game without killing any monsters!");
	}
	
	private void halfKills() {
		System.out.println("You killed a few monsters, but overall you proceeded peacefully.");
	}
	
	private void kills() {
		System.out.println("Well... I mean you didn't kill ALL the monsters...");
	}
	
	private void allKills() {
		System.out.println("You killed all the monsters in your way...are you sure you aren't the monster?");
	}

}
