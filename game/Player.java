package game;

/**
 * Player.java
 * 
 * Class to represent the game's current player
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Player {
	
	/**
	 * The player's current health
	 */
	private int health;
	
	/**
	 * The player's maximum potential health
	 */
	private int maxHealth;
	
	/**
	 * The player's current equipped sword
	 */
	private Sword sword;
	
	/**
	 * The current room the user is in. This serves two
	 * purposes-- it is our only permanent connection to
	 * the rooms in this game (the other rooms are reachable
	 * by traversing this room's "doors"-- and it maintains
	 * the state by representing the user's current location.
	 */
	private Room currentRoom;
	
	/**
	 * The player's current inventory (initially empty)
	 */
	private Inventory pockets = new Inventory();
	
	/**
	 * The number of monsters the player has defeated
	 */
	private int killCount;
	
	/**
	 * The amount of money the player has
	 */
	private int wealth;
	private int ending;
	
	/**
	 * Constructor
	 * @param health: the players current health
	 * @param sword: the player's current sword
	 */
	public Player(int health, Sword sword) {
		this.health = health;
		this.sword = sword;
		this.maxHealth = health;
		killCount = 0;
		this.wealth = 0;
	}

	/**
	 * Getter method for wealth
	 * @return the players current wealth
	 */
	public int getWealth() {
		return wealth;
	}

	/**
	 * Setter method for wealth
	 * @param wealth: the player's new wealth
	 * POSTCONDITION: wealth is now changed
	 */
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

	/**
	 * Setter method for the player's current room
	 * @param r: the new room that the player is in
	 * POSTCONDITION: the current room is now changed
	 */
	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	/**
	 * Getter method for the player's current room
	 * @return the current room that the player is in
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * Getter method for the player's current inventory
	 * @return the player's current inventory
	 */
	public Inventory getPockets() { return pockets;}
	
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
	
	public void addKill() {
		++killCount;
	}
	
	public int getKills() {
		return killCount;
	}

	
	public void removeFromInventory(Item x) {
		pockets.removeFromInventory(x);
	}
	
	public void addToInventory(Item x) {
		pockets.addToInventory(x);
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public Inventory getInventory() {
		return pockets;
	}
	
	public void setEnding(int i) {
		ending = i;
	}
	
	public int getEnding() {
		return ending;
	}
}
