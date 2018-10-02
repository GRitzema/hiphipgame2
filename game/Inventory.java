package game;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> pockets = new ArrayList<Item>(); 
	
	private int empty = 0;
	
	
	public void addToInventory(Item x) {
		pockets.add(x);
		empty++;
	}
	
	
	public void displayInventory() {
		if (empty != 0) {
			for (Item it : pockets) {
				System.out.println(it);
			}
		}
		else {
			System.out.println("You have nothing but lint");
		}
	}
	
	public boolean checkInventory(String what) {
		boolean check = false; // to check whether there is such a thing
		if (empty != 0) {
			for (Item it : pockets) {
				if (what.equals(""+it)) {
					check = true;
				}
			}
		}
		
		return check;
	}
	

}
