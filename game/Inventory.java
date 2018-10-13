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
	
//HEAD
	public Item getFrom(String what) { 
		
		if (pockets.indexOf(what) >= 0) {
			return pockets.get(pockets.indexOf(what));
		} else {
			return new Empty();
		}
		
	}
	
=======
>>>>>>> 0d070e3c46d43152ff817144a90940d6ef4b51d7

}
