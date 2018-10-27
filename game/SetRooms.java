package game;

public class SetRooms {
	
	private Room[] rooms;
	private Player p;

	public SetRooms(Room[] r, Player p) {
		rooms = r;
		this.p = p;
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
	 	
	 	rooms[11].setRoom("left", rooms[9]);
	 	
	 	setDesc();
	 	setMoney();
	 	setItems();
	 			
	}
	
	private void setDesc() {
				
		rooms[0].setDescription("a parkinglot. 0");
		rooms[1].setDescription("a hallway. 1");
		rooms[2].setDescription("a waiting room. There is a vending machine in the corner. 2");
		rooms[3].setDescription("a storage. There is a scroll on the wall. 3");
		rooms[4].setDescription("an ice storage. 4");
		rooms[5].setDescription("Edmand Chapel. (a monster) on the stage. 5");
		rooms[6].setDescription("a backstage. Stupe's Stall is right at the corner. 6");
		rooms[7].setDescription("the side stage. There is a SAGA's pantry in the corner kitchen. 7");
		rooms[8].setDescription("the side stage. There is a scroll on the wall. 8");
		rooms[9].setDescription("the garden of Eden. Lucifer is hiding among the bushes. 9");
		rooms[10].setDescription("secret storage. Dr. Ryken's Perry is in a safe box. 10");
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
