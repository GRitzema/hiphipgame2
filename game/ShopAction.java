package game;

import java.util.Scanner;

public class ShopAction implements Action {

	private Shop theShop;
	private Player p;
		
	public ShopAction(Player p) {
		this.p = p;
	}

	public void takeAction() {
		Scanner keyboard = new Scanner(System.in);
		this.theShop = p.getCurrentRoom().getTheShop();
		if (theShop == null) {
			System.out.println("Nothing can be bought in this room.");
		} else {
			theShop.displayMenu();
			System.out.print("What would you like to buy? ");
			String order = keyboard.nextLine();
			if (theShop.getStore().containsKey(order)){
				System.out.println("You purchased " + order + ".");
			} else {
				System.out.println("Sorry, we don't sell " + order + ".");
			}
		}
	}

	public void takeAction(String substring) { 
		System.out.println("Sorry, " + substring + " is currently not available in Wheaton.");		
	}

}
