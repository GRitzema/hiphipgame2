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
        rooms = new Room[26];
        
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
    	
    	SetRooms set = new SetRooms(rooms);
    	set.set();
    	
    	over = false;   
    }
    
    private void populateRooms() {
    	//rooms[0].addInside(new Money(5));
    	//rooms[3].addInside(new Money(10));

    	//rooms[0].addInside("money1", new Money(5, "a parking meter with a few coins in it"));
    	//rooms[3].addInside("money2", new Money(10, "a small pile of money in a jar"));

    	//rooms[7].addInside(new Sword());
    	//rooms[4].addInside(new Sword());
    	//rooms[6].addInside(new Food());


        Key key1 = new Key("handcuffs key", "a handcuffs key on the floor");
        rooms[2].setKey(key1);
        Riddle riddle1 = new Riddle("What is Wheaton's motto?", "intentional community");
        
        Scroll oldScroll = new Scroll("old scroll", "A dusty scroll", "Your actions have consequences", "Item");
        
        rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));
       
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
	
        HashMap<String, Food> vending = new HashMap<String, Food>();
		Shop vendingMachine = new Shop("Vending Machine", vending, false);
		vendingMachine.addToShop(new Food(5, "Doritos", "Restore 5 hp", p, 2), 3);
		vendingMachine.addToShop(new Food(20, "Gatorade", "Restore 20 hp", p, 10), 3);
		vendingMachine.addToShop(new Food(5, "Hershey", "Restore 5 hp", p, 6), 3);
		vendingMachine.addToShop(new Food(15, "Bubble Tea", "Restore 15 hp", p, 8), 3);
		vendingMachine.addToShop(new Food(10, "Pop-Secret", "Restore 10 hp", p, 4), 3);
		rooms[2].setTheShop(vendingMachine);
		
        HashMap<String, Food> stupe = new HashMap<String, Food>();
		Shop stupeStall = new Shop("Kitchen Pantry", stupe, true);
		stupeStall.addToShop(new Food(10, "French Fries", "Restores 10 hp", p, 10), 2);
		stupeStall.addToShop(new Food(30,"Crispy Chicken","Restores 30 hp", p, 40), 5);
		stupeStall.addToShop(new Food(15, "Beef Burger", "Restores 15 hp", p, 20), 3);
		stupeStall.addToShop(new Food(35, "Taco Salad", "Restores 35 hp", p, 50), 4);
		stupeStall.addToShop(new Food(15, "Pork Gyros", "Restores 15 hp", p, 30), 2);
		rooms[0].setTheShop(stupeStall);
		
        HashMap<String, Food> saga = new HashMap<String, Food>();
		Shop sagaPantry = new Shop("Kitchen Pantry", saga, true);
		sagaPantry.addToShop(new Food(5, "Cookie", "Restores 5 hp", p, 1), 5);
		sagaPantry.addToShop(new Food(50,"Salad","Restores all hp", p, 100), 7);
		sagaPantry.addToShop(new Food(35, "Arancini", "Restores 35 hp", p, 10), 10);
		sagaPantry.addToShop(new Food(45, "Curry", "Restores 45 hp", p, 20), 3);
		sagaPantry.addToShop(new Food(25, "Shin Ramyun", "Restores 25 hp", p, 20), 1);
		rooms[7].setTheShop(sagaPantry);

    }
    
}
