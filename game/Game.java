package game;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    private Inventory pockets = new Inventory();
    
    private Item left = new Empty();
    private Item right = new Empty();
    
    public Item getLeft() { return left; }
    public Item getRight() { return right; }
    public Inventory getPockets() { return pockets;}
    
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
        Room[] rooms = new Room[5];
        for (int i = 0; i < rooms.length; i++)
            rooms[i] = new Room("a room", "There is nothing of interest.");
        rooms[0].setNorth(rooms[1]);
        rooms[1].setSouth(rooms[0]);
        rooms[2].setSouth(rooms[3]);
        rooms[3].setNorth(rooms[2]);
        rooms[3].setWest(rooms[0]);
        rooms[0].setEast(rooms[3]);
        rooms[4].setDown(rooms[3]);
        rooms[3].setUp(rooms[4]);
        rooms[0].setTunnel(rooms[2]);
        rooms[2].setTunnel(rooms[0]);
        rooms[0].setInRoom("There is a key in the corner");
        over = false;
        currentRoom = rooms[0];
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { over = true; }
    
    public Inventory inventory() {
    	return pockets;
    }
    
}
