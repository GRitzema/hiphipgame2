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
        rooms = new Room[27];
        
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("a room.", "There is nothing of interest.", false, new HashMap<String,Item>());          
            if (i == 2 || i == 6 || i == 13 || i == 14 || i == 15 || i == 26 || i == 17 || i == 21) {
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
    	
    	SetRooms set = new SetRooms(rooms, p);
    	set.set();
    	
    	over = false;   
    }
    
    private void populateRooms() {

        HashMap<String, Food> vending = new HashMap<String, Food>();
		Shop vendingMachine = new Shop("Vending Machine", vending, false);
		vendingMachine.addToShop(new Food(5, "Doritos", "Restore 5 hp", p, 2));
		vendingMachine.addToShop(new Food(20, "Gatorade", "Restore 20 hp", p, 10));
		vendingMachine.addToShop(new Food(5, "Hershey", "Restore 5 hp", p, 6));
		vendingMachine.addToShop(new Food(15, "Bubble Tea", "Restore 15 hp", p, 8));
		vendingMachine.addToShop(new Food(10, "Pop-Secret", "Restore 10 hp", p, 4));
		rooms[2].setTheShop(vendingMachine);
		
        HashMap<String, Food> stupe = new HashMap<String, Food>();
		Shop stupeStall = new Shop("Kitchen Pantry", stupe, true);
		stupeStall.addToShop(new Food(10, "FrenchFries", "Restores 10 hp", p, 10));
		stupeStall.addToShop(new Food(30,"Crispy Chicken","Restores 30 hp", p, 40));
		stupeStall.addToShop(new Food(15, "Beef Burger", "Restores 15 hp", p, 20));
		stupeStall.addToShop(new Food(35, "Taco Salad", "Restores 35 hp", p, 50));
		stupeStall.addToShop(new Food(15, "Pork Gyros", "Restores 15 hp", p, 30));
		rooms[0].setTheShop(stupeStall);
		
        HashMap<String, Food> saga = new HashMap<String, Food>();
		Shop sagaPantry = new Shop("Kitchen Pantry", saga, true);
		sagaPantry.addToShop(new Food(5, "Cookie", "Restores 5 hp", p, 1));
		sagaPantry.addToShop(new Food(50,"Salad","Restores all hp", p, 100));
		sagaPantry.addToShop(new Food(35, "Arancini", "Restores 35 hp", p, 10));
		sagaPantry.addToShop(new Food(45, "Curry", "Restores 45 hp", p, 20));
		sagaPantry.addToShop(new Food(25, "Shin Ramyun", "Restores 25 hp", p, 20));
		rooms[7].setTheShop(sagaPantry);

    }
    
}
