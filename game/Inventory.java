package game;


import java.util.HashMap;


public class Inventory {
	
	
	private HashMap<String, Item> pockets = new HashMap<String, Item>();	
	
	public void addToInventory(Item x) {
		pockets.put(x.returnName(), x);
		
	}
	
	public void removeFromInventory(Item x) {
		if (pockets.containsKey(x.returnName()))
			pockets.remove(x.returnName());
	}
	
	public void displayInventory() {
		int i = 1;
		if (!pockets.isEmpty()) {
		
			Object [] arr = pockets.keySet().toArray();
			for (int j = 0; j<arr.length; j++) {

				System.out.println(i + ". " + arr[j]);

				System.out.println("    " + i + ". " + arr[j]);

				i++;
			}
		}
		else {
			System.out.println("    Just air... and a little lint");
		}
	}
	
	public Item getFrom(String what) {
		Item e = new Empty();
		
		for (Item i : pockets.values()) {
			if (i.returnType().equals(what)) {
				e = i;
			} 
		}
		return e;
	}
	
	
	public boolean contains(Key something) {
		if (pockets.containsKey(something)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	public Item getFrom(String what){ 
		
		if (pockets.get(what) != null) {
			return pockets.get(what);
		} else {
			System.out.println("You do not have that item in your inventory\n");
			return new Empty();
		}
		
	}
	*/
		

}
