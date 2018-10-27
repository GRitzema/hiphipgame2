package game;

/**
 * Inventory.java
 * 
 * Class to represent the player's current inventory
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Monster {

	/**
	 * The riddle that the monster asks
	 */
	private Riddle riddle;
	
	/**
	 * The amount of health the monster has
	 */
	private int health;
	
	/**
	 * The room that the monster is in
	 */
	private Room room;
	
	/**
	 * The item the monster holds and drops when defeated
	 */
	private Item item;
	
	/**
	 * The key to the next room the monster gives when the riddle is answered 
	 * or drops if it is defeated
	 */
	private Key key;
	
	/**
	 * A description of the monster
	 */
	private String descrip;
	
	/**
	 * The current player
	 */
	private Player p;
	private boolean strength;
	
	

	/**
	 * Constructor
	 * Refer to instance variables
	 * @param p
	 * @param name
	 * @param health
	 * @param riddle
	 * @param room
	 * @param item
	 * @param key
	 * @param descrip
	 */
	public Monster(boolean s, Player p, String name, int health, Riddle riddle, Room room, Item item, Key key, String descrip) {
		this.health = health;
		this.riddle = riddle;
		this.room = room;
		this.item = item;
		this.key = key;
		this.p = p;
		this.descrip = descrip;
		strength = s;
		this.descrip = descrip;

	}
	
	/**
	 * Getter method for the description
	 * @return the description of the monster
	 */
	public String getDes() {
		return descrip;
	}
	
	/**
	 * Simulates the monster's defeat
	 * The monster disappears and the key and item are dropped and added to the room
	 * Adds one to the player's kill count
	 * PRECONDITION: It is called when its health is less than or equal to 0
	 * POSTCONDITION: the monster is null and the items are added to the room
	 */
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
	
	/**
	 * Getter method for the monster's health
	 * @return the monster's health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Setter method for the monster's health
	 * @param health: the new health of the monster
	 * POSTCONDITION: the monster's health is now changed
	 */
	public void setHealth(double health) {
		this.health = (int) health;
	}

	/**
	 * Getter method for the riddle
	 * @return the monster's riddle
	 */
	public Riddle getRiddle() {
		return riddle;
	}
	
	/**
	 * Getter method for the key
	 * @return the monster's key
	 */
	public Key getKey() {
		return key;
	}

	public boolean getStr() {
		return strength;
	}
	
}
