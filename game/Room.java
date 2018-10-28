package game;

import java.util.HashMap;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Room {
	
    /**
     * A description of this room
     */
    private String description;
    
    /**
     * Map of rooms around the room.
     */
    private HashMap<String,Room> doors = new HashMap<String,Room>();
    
    /**
     * A monster inside the room.
     */
    private Monster theMonster;
    
    /**
     * A sphinx inside the room.
     */
    private Sphinx sph;
     
    /**
     * A shop inside the room.
     */
    private Shop theShop;

    /**
     * A map of items inside the room.
     */
    private HashMap<String, Item> inside = new HashMap<String, Item>();
    
    /**
     * Whether the door to the room is locked.
     */
    private boolean locked;
    
    /**
     * The key to the room.
     */
    private Key key;
    
    /**
     * Money inside the room.
     */
    private Money cash;

	 /**
	  * Constructor.
	  * Refer to the instance variables.
	  * @param description
	  * @param inRoom
	  * @param locked
	  * @param inside
	  */
    public Room(String description, String inRoom, boolean locked, HashMap<String, Item> inside) { 
    	this.description = description; 
    	doors.put("left", null);
    	doors.put("right", null);
    	doors.put("forward", null);
    	doors.put("backward", null);
    	this.theMonster = null;
    	this.sph = null;
    	this.theShop = null;
    	this.locked = locked;
    	this.key = null;
    	this.inside = inside;
    	this.cash = new Money(0);
    	}
      
    /**
     * Getter method to get the money inside the room.
     * @return The money inside the room.
     */
    public Money getCash() {
		return cash;
	}

    /**
     * Setting money inside the room.
     * @param cash The money that wants to be set in the room.
     * CONDITION: The money in the room is set.
     */
	public void setCash(Money cash) {
		this.cash = cash;
	}

	/**
	 * Getter method for the next room.
	 * @param command The direction where the door is.
	 * @return The room in that direction if there is one.
	 */
	public Room getDoors(String command){
		if(doors.containsKey(command)){
			return doors.get(command);
		} else {
			System.out.println("You don't know what direction that is...");
			return this;
		}
    }
	
	/**
	 * Setting directions.
	 * @return List of directions.
	 */
	public String[] returnDoors() {
		int i = 0;
		String[] returner = new String[4];
		
		if (doors.get("left") != null) {
			returner[i] = "left";
			i++;
		}
		
		if (doors.get("right") != null) {
			returner[i] = "right";
			i++;
		}
		
		if (doors.get("forward")!= null) {
			returner[i] = "front";
			i++;
		}
		
		if (doors.get("backward") != null) {
			returner[i] = "back";
			i++;
		}
		
		return returner;
	}
    
	/**
	 * Setting rooms.
	 * @param direction The direction of the room.
	 * @param next The next room after this room.
	 * POSTCONDITION: There is another room to the direction given from this room.
	 */
    public void setRoom(String direction,Room next) {
    	doors.put(direction, next);
    }
    
    /**
     * Set objects inside the room
     * @param name The name of the object
     * @param a    The object
     * POSTCONDITION: There is a new item inside the room.
     */
    public void addInside(String name, Item a) {
    	inside.put(name, a);
    }
    
    /**
     * Getter method for items list inside the room
     * @return The objects inside the room
     */
    public HashMap<String, Item> getInside() {
		return inside;
	}

    /**
     * Checking whether something exists inside the room
     * @param thing The thing that wants to be checked for its existence
     * @return Whether or not the thing exists
     */
	public boolean isInside(String thing) {
		if (inside.containsKey(thing)) {
			return true;
		} else {
			return false;
		}
	}

    /**
     * Retrieve a description of this room (to the user).
     * @return The description of the room.
     */
    public String getDescription() { 
    	return description; 
    	}
    
    /**
     * Removing an object from the room
     * @param name The name of the object
     * @return The item to remove
     */
    public Item takeOut(String name) {
    	Item returner = inside.remove(name);
    	return returner;
    }
    
    /**
     * Setting the description of the room.
     * @param descrip The description that wants to be given to the room.
     * POSTCONDITION: The description of the room is changed.
     */
	public void setDescription(String descrip) {
    	description = descrip;
    }
    
    /**
     * Retrieve things hidden in the room.
     * @return Print out of the items in the room.
     */
    public String getInRoom() {
    	String inRoom = "In the room, there is: ";
    	if (inside.isEmpty()) {
    		inRoom = inRoom + "no item of interest.";   	
    	} else {
    		for (Item i : inside.values()) {
	    		inRoom = inRoom + i.returnName() + ", ";
	    	}
	    	inRoom = inRoom.substring(0,inRoom.length() - 2);
    	}
    	return inRoom;
    }
    
    /**
     * Getter method for whether the door is locked.
     * @return Whether the door is locked.
     */
    public boolean getLocked() {
    	return locked;
    }
    
    /**
     * Setter method for whether the door is locked.
     * POSTCONDITION: The door is either locked or not.
     */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

    /**
     * Getter method for the key of the door.
     * @return The key to open the door.
     */
	public Key getKey() {
		return key;
	}

    /**
     * Setter method for the key of the door.
     * POSTCONDITION: The key to open the door is changed.
     */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * Placing a monster inside the room.
	 * @param newMonster The monster to place in the room.
	 */
	public void placeMonster(Monster newMonster) {
    	theMonster = newMonster;
    }
	
    /**
     * Getter method for the monster in the room.
     * @return The monster in the room.
     */
	public Monster getMonster() {
		return theMonster;
	}
	
	/**
	 * Checking whether there is a sphinx in the room.
	 * @return Whether there is a sphinx in the room.
	 */
	public boolean hasSph() {
		if (sph == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Placing a sphinx in the room.
	 * @param newSph The sphinx that wants to be placed in the room.
	 * POSTCONDITION: There is a new sphinx in the room.
	 */
	public void placeSphinx(Sphinx newSph) {
		sph = newSph;
	}
	
	/**
	 * Getting a sphinx in the room.
	 * @return The sphinx in the room.
	 */
	public Sphinx getSphinx() {
		return sph;
	}

	/**
	 * Getting the shop in the room.
	 * @return The shop in the room.
	 */
	public Shop getTheShop() {
		return theShop;
	}

    /**
     * Setting a shop in the room.
     * POSTCONDITION: There is a new shop in the room.
     */
	public void setTheShop(Shop theShop) {
		this.theShop = theShop;
	}

	/**
	 * Checking whether there is a monster in the room.
	 * @return Whether there is a monster in the room.
	 */
	public boolean hasMonster() {
		if (theMonster == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
