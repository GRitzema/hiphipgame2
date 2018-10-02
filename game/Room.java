package game;
import java.util.*;

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
    
    private String inRoom;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description, String inRoom) { 
    	this.description = description; 
    	this.inRoom = inRoom;
    	}
    
    /**
     * Rooms adjacent to this one, to which there is a door.
     */
    private HashMap<Room, String> theRooms = new HashMap<Room, String>();

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;
    private Room tunnel;
    
    /**
     * Methods for added "doors"-- direction connections to other rooms.
     */
    theRooms.put("north", north);
    south = theRooms.put("south", south);
    east = theRooms.put("east", east);
    theRooms.put("west", west);
    theRooms.put("up", up);
    theRooms.put("down", down);
    theRooms.put("tunnel", tunnel);
    
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
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
