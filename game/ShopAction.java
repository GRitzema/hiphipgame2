package game;

import java.util.HashMap;
import java.util.Scanner;

public class ShopAction implements Action {

	private Shop theShop;
	private Player p;
	private Inventory bag;
	Scanner keyboard = new Scanner(System.in);
	private HashMap<String, Food> cart = new HashMap<String, Food>();
	private boolean exitShop = false;
		
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
		HashMap<String, Food> stuff = theShop.getStore();
		if (stuff.containsKey(order) && (stuff.get(order).getPrice() <= p.getWealth())){
			cart.put(order, theShop.getStore().get(order));
			bag.addToInventory(theShop.getStore().get(order));
			System.out.println("You purchased " + order + ".");
			p.setWealth(p.getWealth()-stuff.get(order).getPrice());
		}
		else if (stuff.containsKey(order) && (stuff.get(order).getPrice() > p.getWealth())) {
			System.out.println("Sorry, you do not have enough money.");
		} else {
			System.out.println("Sorry, we don't sell " + order + ".");
		}
	}

	public void buyAgain() {
		System.out.println("Would you like to buy something else? (y/n)");
		String answer = keyboard.nextLine();
		if (answer.equals("n")) {
			cookingPrep();
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
		} else if (x == null && y != null) {
			hp = y.getHp() - (y.getHp()*(5/100));
			name = "overcooked" + y.returnName();
			description = "Restores " + hp + " hp";
			price = y.getPrice() + 1;
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
			System.out.println("(Type \"none\" if you don't need additional ingredient.)");
			String ingredient = keyboard.nextLine();
			if (cart.containsKey(ingredient)) {
				theIngredient = cart.get(ingredient);
			} else if (ingredient.equals("none")) {
			} else {
				System.out.println("There is no such food in your cart.");
				chooseIngredient(instruction, note);
			}
		} else {
			System.out.println("You don't have any ingredient.");			
		}
		return theIngredient;
	}
	
	/**
	 * Cooking foods
	 */
	public String offer() {
		System.out.println("We provide cooking service. Would you like to cook (y/n)? ");
		String wantCook = keyboard.nextLine();
		return wantCook;
	}
	
	/**
	 * Choosing ingredients to cook.
	 */
	public void cookingPrep() {
		if (theShop.hasCookingService()) {
			String check = offer();
			if (check.equals("y")) {
				Food ingredient1 = chooseIngredient("the first", "");
				if (ingredient1 != null) {
					System.out.println("You need at least one ingredient to cook.");
					buy();
				}
				Food ingredient2 = chooseIngredient("the second", "(Type \"none\" if you don't need more ingredient)");
				Food dish = cook(ingredient1, ingredient2);
				if (dish != null) {
					bag.addToInventory(dish);
				}
				bag.removeFromInventory(ingredient1);	
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
	
	public String exit() {
		System.out.println("Do you still want to cook (y/n)?");
		String ans = keyboard.nextLine();
		return ans;
	}
	
}
