package game;

public class Monster {

	private String name;
	private Riddle riddle;
	private int health;
	private Room room;
	private Item item;
	private Key key;
	
	public Monster(String name, int health, Riddle riddle, Room room, Item item, Key key) {
		this.name = name;
		this.health = health;
		this.riddle = riddle;
		this.room = room;
		this.item = item;
		this.key = key;
	}
		
	public String getName() {
		return name;
	}
	public void defeat() {
		if (this.health <= 0) {

		System.out.println("You defeated " + name + "! The " + key.returnName() + " and the "+ item.returnName() + " fell on the floor.");	
		

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
