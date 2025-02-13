package game;

/**
 * Inventory.java
 * 
 * Class to represent the player's current inventory.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

import java.util.HashMap;


public class Inventory {
	
	/**
	 * A hashmap to map the string name to a specified item in the inventory.
	 */
	private HashMap<String, Item> pockets = new HashMap<String, Item>();	
	
	
	/**
	 * Adds a new association to the HashMap and a new item to the inventory.
	 * Makes an association with the Items name and the item.
	 * @param x: the item to be added to the inventory.
	 * POSTCONDITION: A new association exists in the HashMap.
	 */
	public void addToInventory(Item x) {
		pockets.put(x.returnName(), x);	
	}
	
	
	/**
	 * Removes an item from the inventory and an association from the HashMap.
	 * @param x: the item to be removed.
	 * POSTCONDITION: an association will be removed from the inventory.
	 */
	public void removeFromInventory(Item x) {
		if (pockets.containsKey(x.returnName()))
			pockets.remove(x.returnName());
	}
	
	/**
	 * Prints a list of the current inventory.
	 * Iterates an array of the HashMap's keys and prints out the item's names.
	 * Prints a special message if the inventory is empty.
	 * POSTCONDITION: The name of the items in the inventory is printed out.
	 */
	public void displayInventory() {
		int i = 1; // index of items in the inventory
		if (!pockets.isEmpty()) {
			Object[] arr = pockets.keySet().toArray();				

			for (int j = 0; j<arr.length; j++) { // j is the index of items in the pocket array
				if(!(((String) arr[j]).substring(0,6).equals("sphinx"))) {
					System.out.println("    " + i + ". " + arr[j]);
					i++;
				}
			}
		}
		else {
			System.out.println("    Just air... and a little lint");
		}
	}
		
	/**
	 * Returns a boolean if an item exists in the inventory.
	 * @param something: the item to be searched for in the inventory.
	 * @return true if the item is in the inventory, else false.
	 */
	public boolean contains(Item something) {
		if (pockets.containsValue(something)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns an item of a specified string.
	 * @param it: the key to correspond to the returned item.
	 * @return the corresponding item (null if it does not exist).
	 */
	public Item receiveItem(String it) {
		return pockets.get(it);
	}

	/**
	 * Getter method for the HashMap.
	 * @return the HashMap representing the inventory.
	 */
	public HashMap<String, Item> getPockets() {
		return pockets;
	}

				

}
