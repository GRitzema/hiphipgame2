/**package game;

public class FightAction implements Action {

	private Player p;
	private Monster m;
	
	public FightAction(Player p, Monster m) {
		this.p = p;
		this.m = m;
	}

	public void takeAction() { 
		
		double damage = 0;
		if (Math.random()>=0.2) {
			System.out.println("You missed " + m.getName() + "!");
		}
		else {
			if (p.getSword().getMaterial().equals("wood")) {
				damage = 10 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took " + damage + "!");
			}
			else if (p.getSword().getMaterial().equals("iron")) {
				damage = 25 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took " + damage + "!");
			}
			else if (p.getSword().getMaterial().equals("diamond")) {
				damage = 50 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println(m.getName() + "took" + damage + "!");
			}
			else if (p.getSword() == null) {
				damage = 5 + Math.random()*10;
				m.setHealth(m.getHealth()-damage);
				System.out.println("Your fists inflicted " + damage + " on " + m.getName());
			}
		}
	}

	public void takeAction(String substring) {
		System.out.println("You do not know how to do that");
	}

}**/