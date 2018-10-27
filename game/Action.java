package game;

/**
 * Acion.java
 * 
 * Interface for action classes.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public interface Action {

	/**
	 * The action that the player will do when no object is not needed.
	 * PRECONDITION: The condition before the action is done.
	 * POSTCONDITION: The condition after the action is done.
	 */
	public void takeAction();

	/**
	 * The action that the player will do when an object is needed
	 * @param substring The object or command for the action.
	 * PRECONDITION: The condition before the action is done.
	 * POSTCONDITION: The condition after the action is done.
	 */
	public void takeAction(String substring);

}
