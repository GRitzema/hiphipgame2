package game;


import java.util.HashMap;


public class Inventory {
	
	
	private HashMap<String, Item> pockets = new HashMap<String, Item>();	
	
	public void addToInventory(Item x) {
		pockets.put(x.getDescription(), x);
		
	}
	
	public void removeFromInventory(Item x) {
		if (pockets.containsKey(x.getDescription()))
			pockets.remove(x.getDescription());
	}
	
	public void displayInventory() {
		int i = 1;
		if (!pockets.isEmpty()) {
			Object [] arr = pockets.keySet().toArray();
			for (int j = 0; j>arr.length; j++) {
				System.out.println(i + ". " + arr[j]);
				i++;
			}
		}
		else {
			System.out.println("Just air... and a little lint");
		}
	}
	
	public boolean checkInventory(String what) {
		if (pockets.get(what) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Item getFrom(String what){ 
		
		if (pockets.get(what) != null) {
			return pockets.get(what);
		} else {
			System.out.println("You do not have that item in your inventory\n");
			return new Empty();
		}
		
	}
		

}
