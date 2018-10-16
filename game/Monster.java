package game;

public class Monster {

	private Riddle riddle;
	private int health;
	private Game game;
	private Player p;
	private Inventory pockets;
	private Item item;
	
	public Monster(int health, Riddle riddle, Game game, Player p, Inventory pockets, Item item) {
		this.health = health;
		this.riddle = riddle;
		this.game = game;
		this.p = p;
		this.pockets = pockets;
		this.item = item;
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
			this.setHealth(health-25-(Math.random()*10));
		}
		if (sword.getMaterial().equals("diamond")) {
			this.setHealth(health-50-(Math.random()*10));
		}
	}
		
	public void dropItem() {
		if (this.health <= 0)
		pockets.addToInventory(item);
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = (int) health;
	}
}
