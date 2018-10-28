package game;

/**
 * SetRooms.java
 * 
 * Class to set up rooms for refactoring.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class SetRooms {
	
	/**
	 * An array of all of the rooms in the layout
	 */
	private Room[] rooms;

	/**
	 * The current player
	 */
	private Player p;

	/**
	 * Constructor.
	 * @param r: an array of all of the rooms in the layout.
	 * @param p: the current player.
	 */
	public SetRooms(Room[] r, Player p) {
		this.p = p;
		rooms = r;	
	}
	
	/**
	 * Sets up all of the rooms and their connections to other rooms.
	 * Calls the other methods in the class.
	 * Also sets up riddles, keys, sphinxes and monsters in an organized fashion.
	 * POSTCONDITION: the rooms are now populated.
	 */
	public void set() {

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
	 	rooms[9].setRoom("left", rooms[10]);
	 	rooms[9].setRoom("right", rooms[11]);
	 	
	 	rooms[10].setRoom("right", rooms[9]);
	 	rooms[10].setRoom("forward", rooms[12]);
	 	rooms[12].setRoom("backward", rooms[10]);
	 	rooms[12].setRoom("forward", rooms[13]);
	 	rooms[13].setRoom("backward", rooms[12]);
	 	rooms[13].setRoom("forward", rooms[14]);
	 	rooms[14].setRoom("backward", rooms[13]);
	 	rooms[14].setRoom("forward", rooms[15]);
	 	rooms[15].setRoom("backward", rooms[14]);
	 	rooms[15].setRoom("forward", rooms[26]);
	 	
	 	rooms[11].setRoom("left", rooms[9]);
	 	rooms[11].setRoom("forward", rooms[16]);
	 	rooms[16].setRoom("backward", rooms[11]);
	 	rooms[16].setRoom("forward", rooms[17]);
	 	rooms[17].setRoom("backward", rooms[16]);
	 	rooms[17].setRoom("forward", rooms[20]);
	 	rooms[17].setRoom("left", rooms[18]);
	 	rooms[17].setRoom("right", rooms[19]);
	 	rooms[18].setRoom("right", rooms[17]);
	 	rooms[19].setRoom("left", rooms[17]);
	 	rooms[20].setRoom("backward", rooms[17]);
	 	rooms[20].setRoom("forward", rooms[21]);
	 	rooms[21].setRoom("backward", rooms[20]);
	 	rooms[21].setRoom("forward", rooms[24]);
	 	rooms[21].setRoom("left", rooms[22]);
	 	rooms[21].setRoom("right", rooms[23]);
	 	rooms[22].setRoom("right", rooms[21]);
	 	rooms[23].setRoom("left", rooms[21]);
	 	rooms[24].setRoom("backward", rooms[21]);
	 	rooms[24].setRoom("forward", rooms[26]);
	 	
	 	rooms[16].setRoom("wow", rooms[25]);
	 	rooms[20].setRoom("wow", rooms[25]);
	 	rooms[24].setRoom("wow", rooms[25]);
	 	
	 	rooms[25].setRoom("forward", rooms[26]);
	 	
	 	setDesc();
	 	setMoney();
	 	setItems();

	 	//Sets up keys for rooms
        Key key1 = new Key("handcuffs key", "a handcuffs key on the floor");
        rooms[2].setKey(key1);
        
        Key key2 = new Key("Master key", "a master key on the floor");
        rooms[6].setKey(key2);
        
        
        Key key7 = new Key("silver key", "a silver key on the floor");
        rooms[17].setKey(key7);
        
        Key key8 = new Key("glittery key", "a glittery key on the floor");
        rooms[21].setKey(key8);
        
        
        Key key6 = new Key("Final Key", "a plain key on the floor.  It seems to glow a bit...");
        rooms[26].setKey(key6);
      
        
        //Sets up riddles and monsters/sphinxes
        
        Riddle riddle1 = new Riddle("What is Wheaton College's catchphrase?", "intentional community");
        Scroll oldScroll = new Scroll("old scroll", "A dusty scroll", "Your actions have consequences");
        rooms[1].placeMonster(new Monster(false, p, "a monster", 20, riddle1, rooms[1], oldScroll, key1, " bobs its head along to DJ Pohly's hot new album"));
        
        Riddle riddle2 = new Riddle("What should be Dr. Pohly's side job?", "dj");
        rooms[5].placeMonster(new Monster(false, p, "a monster", 500, riddle2, rooms[5], null, key2, " flexes threateningly"));
               
        Riddle riddle3 = new Riddle("What's the best movie?", "land before time 2");
        rooms[16].placeMonster(new Monster(true, p, "a monster", 100, riddle3, rooms[16], null, key7, " adjusts his dinosaur T-Shirt"));
                
        Riddle riddle4 = new Riddle("What's my middle name", "henry");
        rooms[20].placeMonster(new Monster(true, p, "a monster", 100, riddle4, rooms[20], null, key8, " poses fabulously"));
        
        Riddle riddle5 = new Riddle("Is the answer to this question \"no\"?", "i don't no");
        rooms[24].placeMonster(new Monster(true, p, "a monster", 100, riddle5, rooms[24], null, key6, " contemplates existance"));
                
        
        Riddle riddle6 = new Riddle("What walks on four legs in the morning, two in the afternoon, and three in the evening?", "a man");
        rooms[12].placeSphinx(new Sphinx(riddle6, null, " sits on a mountain"));

        Riddle riddle7 = new Riddle("What is round, brown, and sticky?", "a stick");
        rooms[13].placeSphinx(new Sphinx(riddle7, null, " climbs up and down a tree"));

        
        Riddle riddle8 = new Riddle("What tastes better than it smells?", "a tongue");
        rooms[14].placeSphinx(new Sphinx(riddle8, null, " licks a lollipop"));

        Riddle riddle9 = new Riddle("What is full of holes, but can still hold water?", "a sponge");
        rooms[15].placeSphinx(new Sphinx(riddle9, key6, " watches Nickelodeon"));
                         

        rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));

	}
	
	/**
	 * Sets up the descriptions for all of the rooms.
	 * POSTCONDITION: the rooms have new descriptions.
	 */
	private void setDesc() {
				
		rooms[0].setDescription("a parking lot.");
		rooms[1].setDescription("a hallway.");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner.");
		rooms[3].setDescription("a storage.");
		rooms[4].setDescription("an ice storage.");
		rooms[5].setDescription("Edmund Chapel.");
		rooms[6].setDescription("a backstage. Stupe's Stall is right at the corner. A mysterious portal is open in front of you.");
		rooms[7].setDescription("the side stage. There is a SAGA's pantry in the corner kitchen.");
		rooms[8].setDescription("the side stage.");
		rooms[9].setDescription("a white hallway. \nThere is a sign reading \"Left Door: Path of Knowledge, Right Door: Path of Strength\"");
		
		rooms[10].setDescription("a long hall that opens into a grassy field.");
		rooms[12].setDescription("a mountainside.");
		rooms[13].setDescription("a thick forest.");
		rooms[14].setDescription("the entrance of a small cabin.");
		rooms[15].setDescription("the living room of a small cabin.");
		
		rooms[11].setDescription("a hallway that opens into a cave.");
		rooms[16].setDescription("a large cavern lit by torches.  There are badly drawn paintings on the walls.");
		rooms[17].setDescription("a small cavern.  Water drips from the ceiling.");
		rooms[18].setDescription("a tiny cave.  It is silent.");
		rooms[19].setDescription("a small cave with a pool of water.");
		rooms[20].setDescription("a cavern decorated with a lot of rugs and tapestries.");
		rooms[21].setDescription("a cave with a dirt floor. There are steps going up ahead.");
		rooms[22].setDescription("a cave with a hole in the ceiling. Blue sky is visible through the hole.");
		rooms[23].setDescription("a cave filled with various junk.");
		rooms[24].setDescription("what looks like a basement.");
		rooms[25].setDescription("a plain room with a table and chair. The walls seem to shift when you look at them.");
		
		rooms[26].setDescription("a bedroom. Dr. Ryken's Perry is in a safe box.");
	}
	
	/**
	 * Gives money to the rooms that have it.
	 * POSTCONDITION: the money in the rooms is now set.
	 */
	private void setMoney() {
		rooms[0].setCash(new Money(30));
		rooms[3].setCash(new Money(15));
		rooms[4].setCash(new Money(20));
	}
	
	/**
	 * Sets items in the rooms (swords, scrolls, food, etc.)
	 * POSTCONDITION: The rooms now have items.
	 */
	private void setItems() {
		
		rooms[0].addInside("wall scroll", new Scroll("wall scroll", "A scroll on the wall", "Greetings, adventurer!  Monsters have stolen Dr. Ryken's stuffed Perry.  It's up to you to get it back.  Good luck!"));
		rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));
		rooms[0].addInside("excalibur", new Sword("diamond", "excalibur", "A mighty, powerful blade", p));
		
		rooms[3].addInside("archive scroll", new Scroll("archive scroll", "A scroll in storage", "...Legend tells of a shortcut room between rooms... Who knows how to get to it, though."));
		
		rooms[11].addInside("cave scroll", new Scroll("cave scroll", "A scroll in a cave", "You have chosen the Path of Strength.  Your intellect will do you no good here."));
		
		rooms[10].addInside("tree scroll", new Scroll("tree scroll", "A scroll on a tree", "You have chosen the Path of Knowledge.  Your strength will do you no good here."));
		
		rooms[19].addInside("wet scroll", new Scroll("wet scroll", "A scroll in a wet cave", "The shortcut room has been discovered!  To find it, simply a-\nThe rest of the scroll has been destroyed by water."));
	}

}
