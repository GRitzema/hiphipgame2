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
     * Rooms adjacent to this one, to which there is a door.
     */
    private Room forward, backward, left, right;

    /**
     * A description of this room
     */
    private String description;
    
    /**
     * A more detailed description of the items of a room.
     */
    private String inRoom;
    
    
    private HashMap<String,Room> doors = new HashMap<String,Room>();

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description, String inRoom) { 
    	this.description = description; 
    	this.inRoom = inRoom;
    	}
    
    
   
    
    public HashMap<String,Room> getDoors(){
    	return doors;
    }
    
    
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    public void setInRoom(String thing) {
    	inRoom = thing;
    }
    
    public String getInRoom() { return inRoom; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they extist-- lead.
     */
    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast() { return east; }
    public Room getWest() { return west; }
    public Room getUp() { return up; }
    public Room getDown() { return down; }
    public Room getTunnel() { return tunnel; }

	
}
