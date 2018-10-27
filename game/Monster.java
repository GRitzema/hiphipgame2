package game;

public class Monster {

	private Riddle riddle;
	private int health;
	private Room room;
	private Item item;
	private Key key;
	private String descrip;
	private Player p;
	
	public Monster(Player p, String name, int health, Riddle riddle, Room room, Item item, Key key, String des) {
		this.health = health;
		this.riddle = riddle;
		this.room = room;
		this.item = item;
		this.key = key;
		this.p = p;
		descrip = des;
	}
		
	public String getDes() {
		return descrip;
	}
	
	public void defeat() {
		if (this.health <= 0) {

		System.out.println("You defeated the monster! The " + key.returnName() + " and the "+ item.returnName() + " fell on the floor.");	
		


		room.addInside(item.returnName(), item);
		room.addInside(key.returnName(),key);
		

		p.addKill();
		
		
		room.addInside(item.returnName(), item);
		room.addInside(key.returnName(),key);
		room.placeMonster(null);

		}

	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = (int) health;
	}

	public Riddle getRiddle() {
		return riddle;
	}
	
	public Key getKey() {
		return key;
	}

	
	
}
