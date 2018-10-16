package game;


public class Player {
	private int health;
	private Sword sword;
	
	public Player(int health, Sword sword) {
		this.health = health;
		this.sword = sword;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(double d) {
		this.health = (int) d;
	}
	
	public Sword getSword() {
		return sword;
	}
	
	public void setSword(Sword newSword) {
		sword = newSword;
	}
	
}
