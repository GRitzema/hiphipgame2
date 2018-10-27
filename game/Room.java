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
    
    private HashMap<String,Room> doors = new HashMap<String,Room>();
    
    private Monster theMonster;
     
    private Shop theShop;

    private HashMap<String, Item> inside = new HashMap<String, Item>();
    
    private boolean locked;
    
    private Key key;
    
    private Money cash;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description, String inRoom, boolean locked, HashMap<String, Item> inside) { 
    	this.description = description; 
    	doors.put("left", null);
    	doors.put("right", null);
    	doors.put("forward", null);
    	doors.put("backward", null);
    	this.theMonster = null;
    	this.theShop = null;
    	this.locked = locked;
    	this.key = null;
    	this.inside = inside;
    	this.cash = new Money(0);
    	}
      
    public Money getCash() {
		return cash;
	}

	public void setCash(Money cash) {
		this.cash = cash;
	}

	public Room getDoors(String command){
		if(doors.containsKey(command)){
			return doors.get(command);
		} else {
			System.out.println("You don't know what direction that is...");
			return this;
		}
    }
	
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
    
    public void setRoom(String direction,Room next) {
    	doors.put(direction, next);
    }
    
    /**
     * Set objects inside the room
     * @param name The name of the object
     * @param a    The object
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
    
	public void setDescription(String descrip) {
    	description = descrip;
    }
    
    /**
     * Retrieve things hidden in the room.
     */
    public String getInRoom() {
    	String inRoom = "There is ";
    	if (inside.isEmpty()) {
    		inRoom = inRoom + "no item of interest in the room.";   	
    	} else {
    		for (Item i : inside.values()) {
	    		inRoom = inRoom + i.returnName() + ", ";
	    	}
	    	inRoom = inRoom.substring(0,inRoom.length() - 2) + ".";
    	}
    	return inRoom;
    }
    
    public boolean getLocked() {
    	return locked;
    }
    
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void placeMonster(Monster newMonster) {
    	theMonster = newMonster;
    }
	
	public Monster getMonster() {
		return theMonster;
	}

	public Shop getTheShop() {
		return theShop;
	}

	public void setTheShop(Shop theShop) {
		this.theShop = theShop;
	}

	public boolean hasMonster() {
		if (theMonster == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
