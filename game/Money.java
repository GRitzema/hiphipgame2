package game;

/**
 * Money.java
 * 
 * Class to represent money to be found in the game.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */
public class Money {
	
	/**
	 * The amount that the money is worth.
	 */
	private int amount;
	
	/**
	 * Constructor.
	 * @param amount: the amount that the money is worth.
	 */
	public Money(int amount) {
		this.amount = amount;
	}

	/**
	 * Getter method for "amount".
	 * @return amount: the amount of money.
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Setter method for "amount".
	 * @param amount: the new amount of money.
	 * POSTCONDITION: amount is now changed.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
