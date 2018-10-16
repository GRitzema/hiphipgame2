package game;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> pockets = new ArrayList<Item>(); 
		
	
	public void addToInventory(Item x) {
		pockets.add(x);
		
	}
	
	public void removeFromInventory(Item x) {
		if (pockets.indexOf(x) >= 0)
			pockets.remove(pockets.indexOf(x));
	}
	
	public void displayInventory() {
		int i = 1;
		if (!pockets.isEmpty()) {
			for (Item it : pockets) {
				System.out.println(i + ". " + it);
				i++;
			}
		}
		else {
			System.out.println("Just air... and a little lint");
		}
	}
	
	public boolean checkInventory(String what) {
		if (pockets.indexOf(what) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Item getFrom(String what){ 
		
		if (pockets.indexOf(what) >= 0) {
			return pockets.get(pockets.indexOf(what));
		} else {
			System.out.println("You do not have that item in your inventory\n");
			return new Empty();
		}
		
	}

}
