package game;


public class Player {
	private int health;
	private Sword sword;
	/**
	 * The current room the user is in. This serves two
	 * purposes-- it is our only permanent connection to
	 * the rooms in this game (the other rooms are reachable
	 * by traversing this room's "doors"-- and it maintains
	 * the state by representing the user's current location.
	 */
	private Room currentRoom;
	private Inventory pockets = new Inventory();
	
	public Player(int health, Sword sword) {
		this.health = health;
		this.sword = sword;
	}

	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
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

	
	public void removeFromInventory(Item x) {
			pockets.removeFromInventory(x);
	}
	

}
