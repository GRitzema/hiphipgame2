package game;

public class Monster {

	private String name;
	private Riddle riddle;
	private int health;
	private Room room;
	private Item item;
	private Key key;
	private String descrip;
	private Player p;
	
	public Monster(Player p, String name, int health, Riddle riddle, Room room, Item item, Key key, String des) {
		this.name = name;
		this.health = health;
		this.riddle = riddle;
		this.room = room;
		this.item = item;
		this.key = key;
		this.p = p;
		descrip = des;
	}
		
	public String getName() {
		return name;
	}
	
	public String getDes() {
		return descrip;
	}
	
	public void defeat() {
		if (this.health <= 0) {

		System.out.println("You defeated " + name + "! You received the " + key + "and the "+ item + ".");	
		
		p.addKill();
		
		System.out.println("The ");	
		room.addInside(item.returnName(), item);
		room.addInside(key.returnName(),key);
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
