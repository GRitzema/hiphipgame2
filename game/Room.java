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
    
    /**
     * A more detailed description of the items of a room.
     */
    private String inRoom;
    
    
    private HashMap<String,Room> doors = new HashMap<String,Room>();
    
    private ArrayList<Item> inside = new ArrayList<Item>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description, String inRoom) { 
    	this.description = description; 
    	this.inRoom = inRoom;
    	doors.put("left", null);
    	doors.put("right", null);
    	doors.put("forward", null);
    	doors.put("backward", null);
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
    
    public void addInside(Item a) {
    	inside.add(a);
    }
    
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    public void setDescription(String descrip) {
    	description = descrip;
    }
    
    public void setInRoom(String thing) {
    	inRoom = thing;
    }
    
    public String getInRoom() { return inRoom; }
	
}
