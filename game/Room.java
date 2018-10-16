package game;
import java.util.*;

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

    private HashMap<String, Item> inside = new HashMap<String, Item>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description, String inRoom) { 
    	this.description = description; 
    	doors.put("left", null);
    	doors.put("right", null);
    	doors.put("forward", null);
    	doors.put("backward", null);
    	this.theMonster = null;
    	}
      
    public Room getDoors(String command){
		if(doors.containsKey(command)){
			return doors.get(command);
		} else {
			System.out.println("You don't know what direction that is...");
			return this;
		}
    }
    
    public void setRoom(String direction,Room next) {
    	doors.put(direction, next);
    }
    
    public void addInside(String name, Item a) {
    	inside.put(name, a);
    }
    
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { 
    	return description; 
    	}
    
    public Item takeOut(String name) {
    	Item returner = inside.remove(name);
    	return returner;
    }
    
    public void setDescription(String descrip) {
    	description = descrip;
    }
    
    public String getInRoom() {
    	String inRoom = "There is ";
    	if (inside.isEmpty()) {
    		inRoom = inRoom + "no item of interest in the room.";
    	} else {
    		for (Item i : inside.values()) {
	    		inRoom = inRoom + i.getDescription() + ", ";
	    	}
	    	inRoom = inRoom.substring(0,inRoom.length() - 2) + ".";
    	}
    	return inRoom;
    }
    
    public void placeMonster(Monster newMonster) {
    	theMonster = newMonster;
    }
	
}
