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
		rooms[1].setDescription("a hallway. (a monster) at the end of the hallway. 1");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner. 2");
		rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
		rooms[4].setDescription("an ice storage. 4");
		rooms[5].setDescription("Edmand Chapel. (a monster) on the stage. 5");
		rooms[6].setDescription("a backstage. There is a food stall in a corner. 6");
		rooms[7].setDescription("the side stage. There is a pantry in the corner kitchen. 7");
		rooms[8].setDescription("the side stage. There is a scroll on the wall. 8");
		rooms[9].setDescription("the garden of Eden. Lucifer is hiding among the bushes. 9");
		rooms[10].setDescription("secret storage. Dr. Ryken's Perry is in a safe box. 10");
	       
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
		Shop vendingMachine = new Shop("Vending Machine", vending);
		vendingMachine.addToShop(new Food(5, "Doritos", "Restore 5 hp", p, 10), 3);
		vendingMachine.addToShop(new Food(20, "Gatorade", "Restore 20 hp", p, 10), 3);
		vendingMachine.addToShop(new Food(3, "Hershey", "Restore 3 hp", p, 10), 3);
		vendingMachine.addToShop(new Food(12, "Bubble Tea", "Restore 12 hp", p, 10), 3);
		vendingMachine.addToShop(new Food(7, "Pop-Secret", "Restore 7 hp", p, 10), 3);
		rooms[0].setTheShop(vendingMachine);
		
        HashMap<String, Food> stall = new HashMap<String, Food>();
		Shop foodStall = new Shop("Kitchen Pantry", stall);
		foodStall.addToShop(new Food(12, "French Fries", "Restores 12 hp", p, 1), 2);
		foodStall.addToShop(new Food(30,"Hot Dog","Restores 30 hp", p, 100), 5);
		foodStall.addToShop(new Food(10, "Chicken Nuggets", "Restores 10 hp", p, 10), 3);
    	foodStall.addToShop(new Food(25, "Crepes", "Restores 25 hp", p, 20), 4);
    	foodStall.addToShop(new Food(15, "Ice cream", "Restores 15 hp", p, 20), 2);
		rooms[6].setTheShop(foodStall);
		
        HashMap<String, Food> pantry = new HashMap<String, Food>();
		Shop kitchenPantry = new Shop("Kitchen Pantry", pantry);
		kitchenPantry.addToShop(new Food(2, "Cookie", "Restores 2 hp", p, 1), 5);
		kitchenPantry.addToShop(new Food(50,"Salad","Restores all hp", p, 100), 7);
		kitchenPantry.addToShop(new Food(35, "Arancini", "Restores 35 hp", p, 10), 10);
		kitchenPantry.addToShop(new Food(45, "Curry", "Restores 45 hp", p, 20), 3);
		kitchenPantry.addToShop(new Food(27, "Shin Ramyun", "Restores 27 hp", p, 20), 1);
		rooms[7].setTheShop(kitchenPantry);

    }
    
}
