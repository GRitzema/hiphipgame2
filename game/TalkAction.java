package game;

public class TalkAction implements Action {

	private Player p;
	private Monster m;
	
	public TalkAction(Player p, Monster m) {
		this.p = p;
		this.m = m;
	}

	public void takeAction() { 
		
	}

	public void takeAction(String substring) {
		System.out.println("You do not know how to do that");
	}

}
