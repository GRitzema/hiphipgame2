package game;

/**
 * EndGame.java
 * 
 * Class to implement the end of the game.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class EndGame implements Action {
	
	/**
	 * The player in the game.
	 */
	private Player p;
	
	/**
	 * The game being played.
	 */
	private Game g;

	/**
	 * Constructor.
	 * @param p The player in the game.
	 * @param g The game being played.
	 */
	public EndGame(Player p, Game g) {
		this.p = p;
		this.g= g;
	}

	/**
	 * Print out a message.
	 */
	public void takeAction() {
		System.out.println("Open what?");		
	}

	/**
	 * Ending the game.
	 * PRECONDITION: The game is running.
	 * POSTCONDITION: The game ends.
	 */
	public void takeAction(String substring) {	
		if (substring.equals("safe box")) {
			end();
		} else {
			System.out.println("You don't know how to open that.");
		}
	}
	
	/**
	 * A method to end the game.
	 * PRECONDITION: The game is running.
	 * POSTCONDITION: The game ends.
	 */
	private void end() {
		
		System.out.println("\nAs you pick up Perry, he looks into your eyes and judges you...\n");
		
		int k = p.getKills(); // The number of monsters being killed
		
		if (k == 0) {
			noKills();
		} else if (k < 3 && k !=0) {
			halfKills();
		} else if (k == 5){
			allKills();
		}else {
			kills();
		}
		
		System.out.println("In your travels, you collected " + p.getWealth() + " dollars.  You got through with " + p.getHealth() + " hp, and killed " + p.getKills() + " monsters.");
		
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
	
	/**
	 * A method to print out the result when the player did not kill any monster.
	 * POSTCONDITION: A message of the game result is printed out.
	 */
	private void noKills() {
		System.out.println("Congrats!  You finished the game without killing any monsters!");
	}
	
	/**
	 * A method to print out the result when the player killed less than or equal to half of the monsters.
	 * POSTCONDITION: A message of the game result is printed out.
	 */
	private void halfKills() {
		System.out.println("You killed a few monsters, but overall you proceeded peacefully.");
	}
	
	/**
	 * A method to print out the result when the player killed more than half of the monsters.
	 * POSTCONDITION: A message of the game result is printed out.
	 */
	private void kills() {
		System.out.println("Well... I mean, you didn't kill ALL the monsters...");
	}
	
	/**
	 * A method to print out the result when the player killed all of the monsters.
	 * POSTCONDITION: A message of the game result is printed out.
	 */
	private void allKills() {
		System.out.println("You killed all the monsters in your way...are you sure you aren't the monster?");
	}

}
