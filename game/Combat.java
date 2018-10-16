package game;

public class Combat {

	private Player p;
	private Monster m;
	
	public Combat(Player p, Monster m) {
		this.p = p;
		this.m = m;
	}
	
	
	public void monsterCombat() {		
		if (m.getHealth() >= 0) {
			p.setHealth(p.getHealth()-(Math.random()*10));
		}
	}
	
	public void playerCombat(Sword sword) {
		double damage = 0;
		if (Math.random()>=0.2) {
			System.out.println("You missed" + m.getName() + "!");
		}
		else {
			if (sword.getMaterial().equals("wood")) {
				damage = 10 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took" + damage + "!");
			}
			if (sword.getMaterial().equals("iron")) {
				damage = 25 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took" + damage + "!");
			}
			if (sword.getMaterial().equals("diamond")) {
				damage = 50 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took" + damage + "!");
			}
		}
	}
	
	
	public void engage(String guess) {
		if (guess.equals(m.getRiddle().getAnswer())){
			
		}
	}
}
