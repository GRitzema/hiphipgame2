package game;

import java.util.HashMap;

public class Shop {
	
	/**
	 * The player of the game
	 */
	private Player user;
	
	private HashMap<Item, Integer> shop = new HashMap<Item, Integer>();	
	
	/**
	 * Initializing the shop
	 */
	public Shop(String name, HashMap<Item, Integer> shop) {
		this.shop = shop;
	}
	
	/**
	 * Adding items to the shop
	 * @param x      The item that wants to be added
	 * @param amount The amount of the item available in the shop
	 */
	public void addToShop(Item x, int amount) {
		shop.put(x, amount);	
	}
	
	/**
	 * Removing items from the shop
	 * @param x The item that wants to be removed
	 */
	public void removeFromShop(Food x) {
		if (shop.containsKey(x))
			shop.remove(x);
	}
	
	/**
	 * Displaying the menu
	 */
	public void displayMenu() {
		int i = 1;
		if (!shop.isEmpty()) {
			Object [] arr = shop.keySet().toArray();
			for (int j = 0; j>arr.length; j++) {
				System.out.println(i + ". " + arr[j]);
				i++;
			}
		} else {
			System.out.println("Run out of stock, come back again tomorrow");
		}
	}
	
	/**
	 * Mixing or cooking two foods
	 * @param x The first food to be cooked
	 * @param y The second food to be cooked
	 * @return The cooked food
	 */
	public Food mixFood(Food x, Food y) {
		int hp = x.getHp() + y.getHp() + (x.getHp()*(5/100)) + (y.getHp()*(5/100));
		String name = x.returnName() + "-" + y.returnName();
		String description = "Cooked food";
		int price = x.getPrice() + y.getPrice() + 1;
		Food newFood = new Food(hp, name, description, user, price, null);
		return newFood;
	}
	
}