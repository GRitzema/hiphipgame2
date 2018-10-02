package game;

public class Inventory {
	
	private Item[] pockets = new Item[10]; 
	private int empty = 0;
	
	public void addToInventory(Item x) {
		pockets[empty] = x;
		empty++;
	}
	
	public void displayInventory() {
		for (int i = 0; i<empty; i++) {
			System.out.println(pockets[i].returnName());
		}
	}

}
