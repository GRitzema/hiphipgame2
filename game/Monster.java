package game;

public class Monster {

	private Riddle riddle;
	private int health;
	private Game game;
	private Player p;
	
	public Monster(int health, Riddle riddle, Game game, Player p) {
		this.health = health;
		this.riddle = riddle;
		this.game = game;
		this.p = p;
	}
	
	public void monsterCombat() {		
		if (health >= 0) {
			p.setHealth(p.getHealth()-(Math.random()*10));
		}
	}
	
	public void playerCombat(Sword sword) {
		if (sword.getMaterial().equals("wood")) {
			this.setHealth(health-10-(Math.random()*10));
		}
		if (sword.getMaterial().equals("iron")) {
			this.setHealth(health-10-(Math.random()*10));
		}
		if (sword.getMaterial().equals("diamond")) {
			this.setHealth(health-10-(Math.random()*10));
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = (int) health;
	}
}
