package game;

public class SetRooms {
	
	private Room[] rooms;

	private Player p;

	public SetRooms(Room[] r, Player p) {
		this.p = p;
		rooms = r;
		
	}
	
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
        
        
        Key key3 = new Key("sphinx1", "a golden key on the floor");
        rooms[13].setKey(key3);

        Key key4 = new Key("sphinx2", "a golden key on the floor");
        rooms[14].setKey(key4);
        
        Key key5 = new Key("sphinx3", "a golden key on the floor");
        rooms[15].setKey(key5);
        
        Key key6 = new Key("Final Key", "a plain key on the floor.  It seems to glow a bit...");
        rooms[26].setKey(key6);
      
        
        //Sets up riddles and monsters/sphinxes
        
        Riddle riddle1 = new Riddle("What is Wheaton College's catchphrase?", "intentional community");
        Scroll oldScroll = new Scroll("old scroll", "A dusty scroll", "Your actions have consequences", "Item");
        rooms[1].placeMonster(new Monster(p, "a monster", 20, riddle1, rooms[1], oldScroll, key1, " bobs its head along to DJ Pohly's hot new album"));
        
        Riddle riddle2 = new Riddle("What should be Dr. Pohly's side job?", "dj");
        rooms[5].placeMonster(new Monster(p, "a monster", 500, riddle2, rooms[5], null, key2, " flexes threateningly"));
               
        Riddle riddle3 = new Riddle("What's the best movie?", "land before time 2");
        rooms[16].placeMonster(new Monster(p, "a monster", 100, riddle3, rooms[16], null, key7, " adjusts his dinosaur T-Shirt"));
                
        Riddle riddle4 = new Riddle("What's my middle name", "henry");
        rooms[20].placeMonster(new Monster(p, "a monster", 100, riddle4, rooms[20], null, key8, " poses fabulously"));
        
        Riddle riddle5 = new Riddle("Is the answer to this question \"no\"?", "i don't no");
        rooms[24].placeMonster(new Monster(p, "a monster", 100, riddle5, rooms[24], null, key6, " contemplates existance"));
                
        
        Riddle riddle6 = new Riddle("What walks on four legs in the morning, two in the afternoon, and three in the evening?", "a man");
        rooms[12].placeSphinx(new Sphinx(riddle6, key3, " sits on a mountain"));
        
        Riddle riddle7 = new Riddle("What is round, brown, and sticky?", "a stick");
        rooms[12].placeSphinx(new Sphinx(riddle7, key4, " climbs up and down a tree"));
        
        Riddle riddle8 = new Riddle("What tastes better than it smells?", "a tongue");
        rooms[12].placeSphinx(new Sphinx(riddle8, key5, " licks a lollipop"));
        
<<<<<<< HEAD
        Riddle riddle9 = new Riddle("What is full of holes, but can still hold water?", "a sponge");
        rooms[12].placeSphinx(new Sphinx(riddle9, key6, " watches Nickelodeon"));
                  
=======
        rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));

<<<<<<< HEAD
=======
=======
          
>>>>>>> e129e0c8c93e23bd04e3a23e3d74fb36574b70aa
>>>>>>> 3bc7d1765270c9fd6a63d4615640000539331125
>>>>>>> 1528d6dc1f521463f69beb91e9068c6aeb0175ac
	}
	
	private void setDesc() {
				
		rooms[0].setDescription("a parkinglot. 0");
		rooms[1].setDescription("a hallway. 1");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner. 2");
		rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
		rooms[4].setDescription("an ice storage. 4");
		rooms[5].setDescription("Edmand Chapel. 5");
		rooms[6].setDescription("a backstage. Stupe's Stall is right at the corner. A mysterious portal is open in front of you.  6");
		rooms[7].setDescription("the side stage. There is a SAGA's pantry in the corner kitchen. 7");
		rooms[8].setDescription("the side stage. There is a scroll on the wall. 8");

		rooms[9].setDescription("the garden of Eden. Lucifer is hiding among the bushes. 9");
		rooms[10].setDescription("secret storage. Dr. Ryken's Perry is in a safe box. 10");
		rooms[11].setDescription("a parkinglot. 11");
		rooms[12].setDescription("a hallway. 12");
		rooms[13].setDescription("a waiting room. There is a vending machine in the corner. 13");
		rooms[14].setDescription("a storage. There is a scroll on the wall. 14");
		rooms[15].setDescription("an ice storage. 15");
		rooms[16].setDescription("Edmand Chapel. (a monster) on the stage. 16");
		rooms[17].setDescription("a backstage. Stupe's Stall is right at the corner. 17");
		rooms[18].setDescription("the side stage. There is a SAGA's pantry in the corner kitchen. 18");
		rooms[19].setDescription("the side stage. There is a scroll on the wall. 19");
		rooms[20].setDescription("the garden of Eden. Lucifer is hiding among the bushes. 20");
		rooms[21].setDescription("secret storage. Dr. Ryken's Perry is in a safe box. 21");
		rooms[22].setDescription("a backstage. Stupe's Stall is right at the corner. 22");
		rooms[23].setDescription("the side stage. There is a SAGA's pantry in the corner kitchen. 23");
		rooms[24].setDescription("the side stage. There is a scroll on the wall. 24");
		rooms[25].setDescription("the garden of Eden. Lucifer is hiding among the bushes. 25");
		rooms[26].setDescription("heaven. Dr. Ryken's Perry is in a safe box. 26");
	}
	
	private void setMoney() {
		rooms[0].setCash(new Money(30));
		rooms[3].setCash(new Money(15));
		rooms[4].setCash(new Money(20));
	}
	
	private void setItems() {
		rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));
		rooms[0].addInside("excalibur", new Sword("diamond", "excalibur", "A mighty, powerful blade", p));
	}

}
