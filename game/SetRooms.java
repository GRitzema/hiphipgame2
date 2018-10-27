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
        
        Key key2 = new Key("Master Key", "a master key on the floor");
        rooms[6].setKey(key2);
        
        Key key3 = new Key("Golden Key", "a golden key on the floor");
        rooms[10].setKey(key3);
      
        
        //Sets up riddles
        
        Riddle riddle1 = new Riddle("What is Wheaton College's catchphrase?", "intentional community");
        Scroll oldScroll = new Scroll("old scroll", "A dusty scroll", "Your actions have consequences", "Item");
        rooms[1].placeMonster(new Monster(p, "Public Safety", 20, riddle1, rooms[1], oldScroll, key1, "singing along to DJ Pohly's hot new album"));
        
        Riddle riddle2 = new Riddle("What should be Dr. Pohly's side job?", "DJ");
        rooms[5].placeMonster(new Monster(p, "a monster", 500, riddle2, rooms[5], null, key2, "flexing threateningly"));
       
        
        Riddle riddle3 = new Riddle("What's the best movie?", "Land Before Time 2");
        rooms[16].placeMonster(new Monster(p, "a monster", 100, riddle3, rooms[16], null, key3, "adjusts his dinosaur T-Shirt"));
        
        
        Riddle riddle4 = new Riddle("What's my middle name", "Henry");
        rooms[20].placeMonster(new Monster(p, "a monster", 100, riddle4, rooms[20], null, key4, "poses fabulously"));
        
        Riddle riddle5 = new Riddle("Is the answer to this question \"no\"?", "I don't no");
        rooms[24].placeMonster(new Monster(p, "a monster", 100, riddle5, rooms[24], null, key5, "contemplates existance"));
        
       
        
        
        rooms[0].addInside("mushroom", new Food(10, "mushroom", "Restores 10 hp", p, 10));
           
        

	}
	
	private void setDesc() {
				
		rooms[0].setDescription("a parkinglot. 0");
		rooms[1].setDescription("a hallway. 1");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner. 2");
		rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
		rooms[4].setDescription("an ice storage. 4");
		rooms[5].setDescription("Edmand Chapel. (a monster) on the stage. 5");
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
		//rooms.addInside("excalibur", )
	}

}
