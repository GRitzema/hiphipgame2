package game;

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
	 * Initializing the shop.
	 */
	public Shop(String name, HashMap<String, Food> store, boolean cookingService) {
		this.store = store;
		this.cookingService = cookingService;
	}
	
	/**
	 * Adding items to the shop.
	 * @param foodName The name of the food.
	 * @param x        The item that wants to be added.
	 * @param amount   The amount of the item available in the shop.
	 */
	public void addToShop(Food x) {
		store.put(x.returnName(), x);	
	}
	
	/**
	 * Removing items from the shop.
	 * @param x The item that wants to be removed.
	 */
	public void removeFromShop(Food x) {
		if (store.containsKey(x.returnName()))
			store.remove(x.returnName());
	}
	
	/**
	 * Displaying the menu.
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