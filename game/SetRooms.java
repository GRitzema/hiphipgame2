package game;

public class SetRooms {
	
	private Room[] rooms;

	public SetRooms(Room[] r) {
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
	 			
	}
	
	private void setDesc() {
		
		rooms[0].setCash(new Money(5));
		
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

}
