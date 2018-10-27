package game;

import java.util.HashMap;
import java.util.Scanner;

public class ShopAction implements Action {

	/**
	 * The shop  the user is buying from.
	 */
	private Shop theShop;
	
	/**
	 * The player playing the game.
	 */
	private Player p;
	
	/**
	 * The bag that the player has.
	 */
	private Inventory bag;
	
	/**
	 * To get user's input.
	 */
	Scanner keyboard = new Scanner(System.in);
	
	/**
	 * The shopping cart.
	 */
	private HashMap<String, Food> cart = new HashMap<String, Food>();
		
	/**
	 * Initializing shop action class.
	 * @param p The player playing the game.
	 */
	public ShopAction(Player p) {
		this.p = p;
		this.theShop = p.getCurrentRoom().getTheShop();
		this.bag = p.getInventory();
	}

	/**
	 * Buy foods in the shop and cook them if the shop has a cooking service.
	 */
	public void takeAction() {
		if (theShop == null) {
			System.out.println("Nothing can be bought in this room.");
		} else {		
			buy();
			buyAgain();
			System.out.println("Thank you for shopping with us.");
		}
	}

	public void takeAction(String substring) { 
		System.out.println("Sorry, " + substring + " is currently not available in Wheaton.");		
	}
	
	/**
	 * A method for buying the first object.
	 */
	public void buy() {
		theShop.displayMenu();
		System.out.print("What would you like to buy? ");
		String order = keyboard.nextLine().toLowerCase();
		HashMap<String, Food> stuff = theShop.getStore();
		if (stuff.containsKey(order) && (stuff.get(order).getPrice() <= p.getWealth())){
			cart.put(order, theShop.getStore().get(order));
			bag.addToInventory(theShop.getStore().get(order));
			p.setWealth(p.getWealth()-stuff.get(order).getPrice());
			theShop.removeFromShop(theShop.getStore().get(order));
			System.out.println("You purchased " + order + ".");
		}
		else if (stuff.containsKey(order) && (stuff.get(order).getPrice() > p.getWealth())) {
			System.out.println("Sorry, you do not have enough money.");
		} else {
			System.out.println("Sorry, we don't sell " + order + ".");
		}
	}

	/**
	 * A method for buying more objects.
	 */
	public void buyAgain() {
		System.out.println("Would you like to buy something else? (y/n)");
		String answer = keyboard.nextLine();
		if (answer.equals("n")) {
			cookingPrep();
		} else if (answer.equals("y")) {
			buy();
			buyAgain();
		} else {
			System.out.println("Please type y/n.");
			buyAgain();
		}
	}
	
	/**
	 * Getting the cooked dish.
	 * @param x The first food to be cooked.
	 * @param y The second food to be cooked.
	 * @return The cooked food.
	 */
	public Food cook(Food x, Food y) {
		int hp = 0;
		String name = "";
		String description = "";
		Food newFood = null;
		int price = 0;
		if (x != null && y != null) {
			System.out.println("You are mixing " + x.returnName() + " and " + y.returnName() + "...");
			hp = x.getHp() + y.getHp() + (x.getHp()*(5/100)) + (y.getHp()*(5/100));
			name = x.returnName() + "-" + y.returnName();
			description = "Restores " + hp + " hp";
			price = x.getPrice() + y.getPrice() + 1;
			newFood = new Food(hp, name, description, p, price);
		} else if (x != null && y == null) {
			hp = x.getHp() + (x.getHp()*(5/100));
			name = "Double " + x.returnName();
			description = "Restores " + hp + " hp";
			price = x.getPrice() + 1;
			newFood = new Food(hp, name, description, p, price);
		}
		return newFood;
	}
	
	/**
	 * Getting the ingredient to cook.
	 * @param instruction What kind of ingredient?
	 * @return The ingredient to cook.
	 */
	public Food chooseIngredient(String instruction, String note) {
		Food theIngredient = null;
		String inCart = "FOOD \t\t HP \n";
		if (!cart.isEmpty()) {
			System.out.println("In your cart: ");
			for (Food i : cart.values()) {
	    		inCart = inCart + i.returnName() + " \t " + i.getHp() + "\n";
	    	}
	    	System.out.println(inCart);
			System.out.println("Choose " + instruction + " ingredient to cook: " + note);
			String ingredient = keyboard.nextLine();
			if (cart.containsKey(ingredient)) {
				theIngredient = cart.get(ingredient);
			} else if (ingredient.equals("none")) {
			} else {
				System.out.println("There is no such food in your cart.");
				chooseIngredient(instruction, note);
			}		
		}
		return theIngredient;
	}
	
	/**
	 * Cooking foods.
	 */
	public String offer() {
		String answer;
		if (cart.isEmpty()) {
			 System.out.println("We provide cooking service, but you don't have any ingredient in your cart.");
			 System.out.println("Would you like to buy an ingredient to cook (y/n)?");
			 answer = keyboard.nextLine();
			 if (answer.equals("y")) {
				 buy();
				 buyAgain();
				 offer();
			 } else if (answer.equals("n")) {
			 } else {
				System.out.println("Please type y/n.");
				offer();
			 }
		} else {
			System.out.println("We provide cooking service. Would you like to cook (y/n)? ");
			answer = keyboard.nextLine();
		}
		return answer;
	}
	
	/**
	 * Choosing ingredients to cook.
	 */
	public void cookingPrep() {
		if (theShop.hasCookingService()) {
			String check = offer();
			if (check.equals("y")) {
				Food ingredient1 = null;
				Food ingredient2 = null;
				if (cart.size() == 1) {
					String ans = prepHelper();
					if (ans.equals("1")) {
						ingredient1 = chooseIngredient("", "");
					} else if (ans.equals("2")){
						buy();
						buyAgain();
					} else {
						System.out.println("Please type \"1\"/\"2\"");
					}
				} else {
					ingredient1 = chooseIngredient("the first", "");
					cart.remove(ingredient1.returnName());
					ingredient2 = chooseIngredient("the second", "(Type \"none\" if you don't need more ingredient)");
					cart.remove(ingredient2.returnName());
				}
				Food dish = cook(ingredient1, ingredient2);
				if (dish != null) {
					bag.addToInventory(dish);
				}
				if (ingredient1 != null) {
					bag.removeFromInventory(ingredient1);
				}
				if (ingredient2 != null) {
					bag.removeFromInventory(ingredient2);
				}
				if (dish != null) {
					System.out.println("You cooked " + dish.returnName());
				} 
			} else if (check.equals("n")) {
			} else {
				System.out.println("Please type y/n.");
				cookingPrep();
			}
		}
	}
	
	/**
	 * A helper method for cookingPrep method.
	 * @return The answer inputed by the user.
	 */
	public String prepHelper() {
		System.out.println("You only have one ingredient in the cart.");
		System.out.println("What would you like to do? ");
		System.out.println("   1) Recook the ingredient you have\n   2) Buy more ingredients");
		String answer = keyboard.nextLine();
		return answer;
	}
	
}
