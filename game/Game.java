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
    
	private Player p = new Player(50,null);

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
     * Constructor to set up the game.
     */
    public Game() {
        rooms = new Room[11];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("a room.", "There is nothing of interest."); 
        }
        
        setRooms();

        p.setCurrentRoom(rooms[0]);

    }
    
    public Player getPlayer() {
    	return p;
    }
 
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }
    
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

        Key key1 = new Key(pockets, "Handcuffs Key", "Open the hallway gate to the waiting room.");
        Riddle riddle1 = new Riddle("asdf", "jkl");
        rooms[1].placeMonster(new Monster("Public Security", 1000, riddle1, pockets, null, key1));
       
        Key key2 = new Key(pockets, "Master Key", "Open the door to the backstage room.");
        Riddle riddle2 = new Riddle("asdf", "jkl");
        rooms[5].placeMonster(new Monster("Chaplain Blackmon", 500, riddle2, pockets, null, key2));
       
        Key key3 = new Key(pockets, "Golden Key", "Open a secret room.");
        Riddle riddle3 = new Riddle("asdf", "jkl");
        rooms[9].placeMonster(new Monster("Satan", 100, riddle3, pockets, null, key3));

        rooms[0].setDescription("a parkinglot. 0");
        rooms[1].setDescription("a hallway. There is a monster at the end of the hallway. 1");
        rooms[2].setDescription("a waiting room. There is an ATM in the corner. 2");
        rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
        rooms[4].setDescription("an ice storage. 4");
        rooms[5].setDescription("Edmand Chapel. There is a monster on the stage. 5");
        rooms[6].setDescription("a changing-room. There is a vending machine in a corner 6");
        rooms[7].setDescription("the side stage. There is an ATM in a corner 7");
        rooms[8].setDescription("the side stage. There is a scroll on the wall. 8");
        rooms[9].setDescription("the backstage. There is a monster among the dresses. 9");
        rooms[10].setDescription("secret room. Dr. Ryken's Perry is in a safe box. 10");

    }
    
    private void populateRooms () {
    	//rooms[0].addInside(new Money(5));
    	//rooms[3].addInside(new Money(10));

    	rooms[0].addInside("money1", new Money(5, "a parking meter with a few coins in it"));
    	rooms[3].addInside("money2", new Money(10, "a small pile of money in a jar"));

    	//rooms[4].addInside(new Food(20,"a butterscotch and snail pie", pockets, p));
    	//rooms[7].addInside(new Sword());
    	//rooms[4].addInside(newSword());
    	//rooms[6].addInside(new Food());
    }
    
}
