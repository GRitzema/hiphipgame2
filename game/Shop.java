package game;

/**
 * Shop.java
 * 
 * Class to describes shops.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

import java.util.HashMap;

public class Shop {

	/**
	 * The list of food sold in the shop.
	 */
	private HashMap<String, Food> store = new HashMap<String, Food>();	
	
	/** 
	 * Whether the shop has a cooking service.
	 */
	private boolean cookingService;
	
	/**
	 * Constructor. 
	 * Refer to the instance variables.
	 * @param name
	 * @param store
	 * @param cookingService
	 */
	public Shop(String name, HashMap<String, Food> store, boolean cookingService) {
		this.store = store;
		this.cookingService = cookingService;
	}
	
	/**
	 * Adding items to the shop.
	 * @param x        The item that wants to be added.
	 * POSTCONDITION: There is a new food in the shop.
	 */
	public void addToShop(Food x) {
		store.put(x.returnName(), x);	
	}
	
	/**
	 * Removing items from the shop.
	 * @param x The item that wants to be removed.
	 * POSTCONDITION: The item in the shop is removed.
	 */
	public void removeFromShop(Food x) {
		if (store.containsKey(x.returnName()))
			store.remove(x.returnName());
	}
	
	/**
	 * Displaying the menu.
	 * POSTCONDITION: The menu of the shop is printed out.
	 */
	public void displayMenu() {
		String menu = "MENU \t\t PRICE \n";
		if (!store.isEmpty()) {
			for (Food i : store.values()) {
	    		menu = menu + i.returnName() + " \t " + i.getPrice() + "\n";
	    	}
	    	System.out.println(menu);
		} else {
			System.out.println("Run out of stock, come back again tomorrow");
		}
	}
	
	/**
	 * Getting the list of products.
	 * @return The list of products.
	 */
	public HashMap<String, Food> getStore() {
		return store;
	}

	/**
	 * To check whether there is a cooking service in the shop.
	 * @return Whether there is a cooking service in the shop.
	 */
	public boolean hasCookingService() {
		return cookingService;
	}
	
}