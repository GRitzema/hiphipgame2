package game;

import java.util.HashMap;

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
    
	Player p = new Player(50,null);

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    private Room[] rooms;
    
    private Item left = new Empty();
    private Item right = new Empty();
    
    public Item getLeft() { return left; }
    public Item getRight() { return right; }
       
    /**
     * Constructor to set up the game.
     */
    public Game() {
        rooms = new Room[11];
        
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("a room.", "There is nothing of interest.", false, new HashMap<String,Item>());          
            if (i == 2 || i == 6 || i == 10) {
            	rooms[i].setLocked(true);
            }
        }
        
        setRooms();
        populateRooms();

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
	
		rooms[0].setDescription("a parkinglot. 0");
		rooms[1].setDescription("a hallway. Public safety at the end of the hallway. 1");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner. 2");
		rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
		rooms[4].setDescription("an ice storage. 4");
		rooms[5].setDescription("Edmand Chapel. Chaplain Blackmon is on the stage. 5");
		rooms[6].setDescription("a backstage. There is a stall in a corner 6");
		rooms[7].setDescription("the side stage. There is a pantry in a corner 7");
		rooms[8].setDescription("the side stage. There is a scroll on the wall. 8");
		rooms[9].setDescription("the garden of Eden. Satan is hiding among the bushes. 9");
		rooms[10].setDescription("secret storage. Dr. Ryken's Perry is in a safe box. 10");
	       
    }
    
    private void populateRooms() {
    	//rooms[0].addInside(new Money(5));
    	//rooms[3].addInside(new Money(10));

    	//rooms[0].addInside("money1", new Money(5, "a parking meter with a few coins in it"));
    	//rooms[3].addInside("money2", new Money(10, "a small pile of money in a jar"));

    	rooms[0].addInside("pie", new Food(50,"Pie","Restores all hp", p, 100, "Food"));
    	rooms[0].addInside("mushroom", new Food(10, "Mushroom", "Restores 10 hp", p, 10, "Food"));
    	rooms[1].addInside("sandwich", new Food(15, "Sandwich", "Restores 15 hp", p, 20, "Food"));
    	rooms[1].addInside("cake", new Food (20, "Cake", "Restores 20 hp", p, 20, "Food"));
    	//rooms[7].addInside(new Sword());
    	//rooms[4].addInside(new Sword());
    	//rooms[6].addInside(new Food());


        Key key1 = new Key("handcuffs key", "a handcuffs key on the floor");
        rooms[2].setKey(key1);
        Riddle riddle1 = new Riddle("What is Wheaton's motto?", "intentional community");
        
        Scroll oldScroll = new Scroll("old scroll", "A dusty scroll", "Your actions have consequences", "Item");
       
        rooms[2].setKey(key1);
        rooms[1].placeMonster(new Monster(p, "Public Safety", 20, riddle1, rooms[1], oldScroll, key1, "rattles its handcuffs threateningly"));

       
        Key key2 = new Key("Master Key", "a master key on the floor");
        rooms[6].setKey(key2);
        Riddle riddle2 = new Riddle("What is Dr. Pohly's second occupation?", "DJ");
        rooms[5].placeMonster(new Monster(p, "Chaplain Blackmon", 500, riddle2, rooms[5], null, key2, "flips through his Bible"));
       
        Key key3 = new Key("Golden Key", "a golden key on the floor");
        rooms[10].setKey(key3);
        Riddle riddle3 = new Riddle("asdf", "jkl");
        rooms[9].placeMonster(new Monster(p, "Satan", 100, riddle3, rooms[9], null, key3, "twirls his trident"));
	
        HashMap<Item, Integer> vending = new HashMap<Item, Integer>();
		vending.put(new Food(10, "Shin-Ramyun", "Main course", p, 10, null), 3);
		vending.put(new Food(2, "Chocolate", "Dessert", p, 1, null), 5);
		Shop vendingMachine = new Shop("Vending Machine", vending);
		rooms[2].placeShop(vendingMachine);

    }
    
}
