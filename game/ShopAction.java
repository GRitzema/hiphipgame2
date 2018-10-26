package game;

import java.util.HashMap;
import java.util.Scanner;

public class ShopAction implements Action {

	private Shop theShop;
	private Player p;
	private Inventory bag;
	Scanner keyboard = new Scanner(System.in);
	private HashMap<String, Food> cart = new HashMap<String, Food>();
		
	public ShopAction(Player p) {
		this.p = p;
		this.theShop = p.getCurrentRoom().getTheShop();
		this.bag = p.getInventory();
	}

	public void takeAction() {
		if (theShop == null) {
			System.out.println("Nothing can be bought in this room.");
		} else {		
			buy();
			buyAgain();
		}
	}

	public void takeAction(String substring) { 
		System.out.println("Sorry, " + substring + " is currently not available in Wheaton.");		
	}
	
	public void buy() {
		theShop.displayMenu();
		System.out.print("What would you like to buy? ");
		String order = keyboard.nextLine();
		if (theShop.getStore().containsKey(order)){
			cart.put(order, theShop.getStore().get(order));
			bag.addToInventory(theShop.getStore().get(order));
			System.out.println("You purchased " + order + ".");
		} else {
			System.out.println("Sorry, we don't sell " + order + ".");
		}
	}

	public void buyAgain() {
		System.out.println("Would you like to buy something else? (y/n)");
		String answer = keyboard.nextLine();
		if (answer.equals("n")) {
			if (theShop.hasCookingService()) {
				System.out.println("Would you like to cook?");
				String youWould = keyboard.nextLine();
				if (youWould == "y") {
					System.out.println("Choose the first ingredient to cook: ");
					Food ingredient1 = chooseIngredient();
					System.out.println("Choose the second ingredient to cook: ");
					Food ingredient2 = chooseIngredient();
					Food dish = cook(ingredient1, ingredient2);
					bag.addToInventory(dish);
					bag.removeFromInventory(ingredient1);
					bag.removeFromInventory(ingredient2);
					System.out.println("You cooked " + dish.returnName());
				} else if (answer.equals("n")) {

				} else {
					System.out.println("Please type y/n.");
					cooking();
				}
			}
			System.out.println("Thank you for shopping with us, come back soon!");
		} else if (answer.equals("y")) {
			buy();
			buyAgain();
		} else {
			System.out.println("Please type y/n.");
			buyAgain();
		}
	}
	
	/**
	 * Getting the cooked dish
	 * @param x The first food to be cooked
	 * @param y The second food to be cooked
	 * @return The cooked food
	 */
	public Food cook(Food x, Food y) {
		int hp = x.getHp() + y.getHp() + (x.getHp()*(5/100)) + (y.getHp()*(5/100));
		String name = x.returnName() + "-" + y.returnName();
		String description = "Restores " + hp + " hp";
		int price = x.getPrice() + y.getPrice() + 1;
		Food newFood = new Food(hp, name, description, p, price);
		return newFood;
	}
	
	/**
	 * Choosing ingredient to cook
	 */
	public Food chooseIngredient() {
		System.out.println("In your cart: ");
		String inCart = "FOOD \t\t HP \n";
		return null;
/**		if (!cart.isEmpty()) {
			Object [] arr = cart.values().toArray();
			for (Food i : cart.values()) {
	    		inCart = inCart + i.returnName() + " \t " + i.getHp() + "\n";
	    	}
	    	System.out.println(inCart);
			String ingredient = keyboard.nextLine();
			if (cart.containsKey(ingredient)) {
				return cart.get(ingredient);
			} else {
				System.out.println("There is no such food in your cart.");
				return null;
			}
		} else {
			System.out.println("You need to buy at least two ingredients first.");
			return null;
		}*/
	}
	
	/**
	 * Cooking foods
	 */
	public String cooking() {
		System.out.println("Would you like to cook?");
		String youWould = keyboard.nextLine();
		return youWould;
	}
	
}
