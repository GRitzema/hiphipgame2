package game;

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
    private Room north, south, east, west, up, down, tunnel;

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
     * Methods for added "doors"-- directiona connections to other rooms.
     */
    public void setNorth(Room north) { this.north = north; }
    public void setSouth(Room south) { this.south = south; }
    public void setEast(Room east) { this.east = east; }
    public void setWest(Room west) { this.west = west; }
    public void setUp(Room up) { this.up = up; }
    public void setDown(Room down) {this.down = down; }
    public void setTunnel(Room tunnel) {this.tunnel = tunnel; }
    
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
