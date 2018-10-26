package game;

import java.util.HashMap;

public class Shop {
	
	/**
	 * The player of the game
	 */
	private Player user;
	
	private Food food;
	
	private HashMap<String, Food> store = new HashMap<String, Food>();	
	
	/**
	 * Initializing the shop
	 */
	public Shop(String name, HashMap<String, Food> store) {
		this.store = store;
	}
	
	/**
	 * Adding items to the shop
	 * @param foodName The name of the food
	 * @param x        The item that wants to be added
	 * @param amount   The amount of the item available in the shop
	 */
	public void addToShop(Food x, int amount) {
		store.put(x.returnName(), x);	
	}
	
	/**
	 * Removing items from the shop
	 * @param x The item that wants to be removed
	 */
	public void removeFromShop(Food x) {
		if (store.containsKey(x))
			store.remove(x);
	}
	
	/**
	 * Displaying the menu
	 */
	public void displayMenu() {
		String menu = "MENU \t\t PRICE \n";
		if (!store.isEmpty()) {
			Object [] arr = store.values().toArray();
			for (Food i : store.values()) {
	    		menu = menu + i.returnName() + " \t " + i.getPrice() + "\n";
	    	}
	    	System.out.println(menu);
		} else {
			System.out.println("Run out of stock, come back again tomorrow");
		}
	}
	
	/**
	 * Getting the list of products
	 * @return The list of products
	 */
	public HashMap<String, Food> getStore() {
		return store;
	}

	/**
	 * Cooking two foods
	 * @param x The first food to be cooked
	 * @param y The second food to be cooked
	 * @return The cooked food
	 */
	public Food cook(Food x, Food y) {
		int hp = x.getHp() + y.getHp() + (x.getHp()*(5/100)) + (y.getHp()*(5/100));
		String name = x.returnName() + "-" + y.returnName();
		String description = "Cooked food";
		int price = x.getPrice() + y.getPrice() + 1;
		Food newFood = new Food(hp, name, description, user, price);
		return newFood;
	}
	
}