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
 * 
 * @author Edited by: Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Game {
    
	/**
	 * The player in the game.
	 */
	Player p = new Player(50,null);

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Rooms in the game.
     */
    private Room[] rooms;
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
        rooms = new Room[27];
        
        for (int i = 0; i < rooms.length; i++) { // i is the index of rooms array
            rooms[i] = new Room("a room.", "There is nothing of interest.", false, new HashMap<String,Item>());          
            if (i == 2 || i == 6 || i == 13 || i == 14 || i == 15 || i == 26 || i == 17 || i == 21) {
            	rooms[i].setLocked(true);
            }
        }
        
        setRooms();
        populateShops();
        p.setCurrentRoom(rooms[0]);

    }
    
    /**
     * Getter method to get the player.
     * @return The player in the game.
     */
    public Player getPlayer() {
    	return p;
    }
 
    /**
     * Is this game over or not?
     * @return Whether the game is still running.
     */
    public boolean isOver() { return over; }
    
    /**
     * Indicate that the game is now over.
     * PRECONDITION: The game is running.
     * POSTCONDITION: The game ends.
     */
    public void finishGame() { over = true; }
    
    /**
     * Setter method to set the rooms.
     * PRECONDITION: There is no room in the game.
     * POSTCONDITION: There are rooms in the game.
     */
    private void setRooms() {
    	
    	SetRooms set = new SetRooms(rooms, p); // The room being set
    	set.set();
    	populateShops();
    	
    	over = false;   
    }
    
    /**
     * Adding shops into the rooms.
     * PRECONDITION: There is no shop in the room.
     * POSTCONDITION: There are shops in the game's rooms.
     */
    private void populateShops() {
        HashMap<String, Food> vending = new HashMap<String, Food>(); // The map of foods available
		Shop vendingMachine = new Shop("Vending Machine", vending, false); // The shop in room 2
		vendingMachine.addToShop(new Food(5, "doritos", "Restore 5 hp", p, 2));
		vendingMachine.addToShop(new Food(20, "gatorade", "Restore 20 hp", p, 10));
		vendingMachine.addToShop(new Food(5, "hershey", "Restore 5 hp", p, 6));
		vendingMachine.addToShop(new Food(15, "bubble tea", "Restore 15 hp", p, 8));
		vendingMachine.addToShop(new Food(10, "pop-secret", "Restore 10 hp", p, 4));
		rooms[2].setTheShop(vendingMachine);
		
        HashMap<String, Food> stupe = new HashMap<String, Food>(); // The map of foods available
		Shop stupeStall = new Shop("Kitchen Pantry", stupe, true); // The shop in room 6
		stupeStall.addToShop(new Food(10, "french fries", "Restores 10 hp", p, 10));
		stupeStall.addToShop(new Food(30,"crispy chicken","Restores 30 hp", p, 40));
		stupeStall.addToShop(new Food(15, "beef burger", "Restores 15 hp", p, 20));
		stupeStall.addToShop(new Food(35, "taco salad", "Restores 35 hp", p, 50));
		stupeStall.addToShop(new Food(15, "pork gyros", "Restores 15 hp", p, 30));
		rooms[6].setTheShop(stupeStall);
		
        HashMap<String, Food> saga = new HashMap<String, Food>(); // The map of foods available
		Shop sagaPantry = new Shop("Kitchen Pantry", saga, true); // The shop in room 7
		sagaPantry.addToShop(new Food(5, "cookie", "Restores 5 hp", p, 1));
		sagaPantry.addToShop(new Food(50,"hearty salad","Restores all hp", p, 100));
		sagaPantry.addToShop(new Food(35, "arancini", "Restores 35 hp", p, 10));
		sagaPantry.addToShop(new Food(45, "spicy curry", "Restores 45 hp", p, 20));
		sagaPantry.addToShop(new Food(25, "shin ramyun", "Restores 25 hp", p, 20));
		rooms[7].setTheShop(sagaPantry);
    }
    
}
