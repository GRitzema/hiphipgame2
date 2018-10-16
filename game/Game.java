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
     * The current room the user is in. This serves two
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;
    
    private Player p = new Player(50);

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    private Room[] rooms;
    
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
        Room[] rooms = new Room[11];
        rooms = new Room[11];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("a room. You are in room " + i + ".", "There is nothing of interest."); 
        }
  
        setRooms();

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
    
    private void setRooms() {
        
        rooms[0].setRoom("forward",rooms[1]);
        rooms[1].setRoom("backward", rooms[0]);
        rooms[1].setRoom("forward", rooms[2]);
        rooms[2].setRoom("backward", rooms[1]);
        rooms[2].setRoom("left", rooms[3]);
        rooms[2].setRoom("right", rooms[4]);
        rooms[2].setRoom("forward", rooms[5]);
        rooms[3].setRoom("right", rooms[2]);
        rooms[4].setRoom("left", rooms[2]);
        rooms[5].setRoom("backward", rooms[2]);
        rooms[5].setRoom("forward", rooms[6]);
        rooms[6].setRoom("backward", rooms[5]);
        rooms[6].setRoom("left", rooms[7]);
        rooms[6].setRoom("right", rooms[8]);
        rooms[6].setRoom("forward", rooms[9]);
        rooms[7].setRoom("right", rooms[6]);
        rooms[8].setRoom("left", rooms[6]);
        rooms[9].setRoom("backward", rooms[6]);
        rooms[9].setRoom("forward", rooms[10]);
        rooms[10].setRoom("backward", rooms[9]);
        over = false;

        rooms[0].setInRoom("There are few coins in a parking meter.");
        rooms[3].setInRoom("There are few coins in a jar.");
        rooms[4].setInRoom("There is food in an icebox.");
        rooms[6].setInRoom("There is food inside a shopping bag.");
        rooms[7].setInRoom("There is a sword underneath a carpet.");
        
        rooms[0].setDescription("a parkinglot.");
        rooms[1].setDescription("a hallway. There is a monster at the end of the hallway.");
        rooms[2].setDescription("a waiting room. There is an ATM in the corner.");
        rooms[3].setDescription("a storage. There is a scroll on the wall.");
        rooms[4].setDescription("an ice storage.");
        rooms[5].setDescription("Edmand Chapel. There is a monster on the stage.");
        rooms[6].setDescription("a changing-room. There is a vending machine in a corner");
        rooms[7].setDescription("the side stage. There is an ATM in a corner");
        rooms[8].setDescription("the side stage. There is a scroll on the wall.");
        rooms[9].setDescription("the backstage. There is a monster among the dresses.");
        rooms[10].setDescription("secret room. Dr. Ryken's Perry is in a safe box.");

        populateRooms();
    }
    
    private void populateRooms () {
    	rooms[0].addInside(new Money(5));
    	rooms[3].addInside(new Money(10));
    	//rooms[4].addInside(new Food(20,"a butterscotch and snail pie", pockets, p));
    	//rooms[7].addInside(new Sword());
    	//rooms[4].addInside(newSword());
    	//rooms[6].addInside(new Food());
    }
    
}
