package game;

public interface Action {

	/**
	 * The action that the player will do when no object is not needed
	 */
	public void takeAction();

	/**
	 * The action that the player will do when an object is needed
	 * @param substring
	 */
	public void takeAction(String substring);

}
