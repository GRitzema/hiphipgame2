package game;

/**
 * Sphinx.java
 * 
 * Class to create instances of Sphinxes.
 * 
 * @author Grace Ritzema, Lina Widodo, and Andy Peterson
 * Oct 26, 2018
 */

public class Sphinx {
	
	/**
	 * The riddle that corresponds to the sphinx.
	 */
	private Riddle riddle;
	
	/**
	 * The key held by the Sphinx.
	 */
	private Key key;
	
	/**
	 * The description of the Sphinx.
	 */
	private String descrip;
	
	
	/**
	 * Constructor.
	 * Refer to instance variables.
	 * @param riddle
	 * @param key
	 * @param des
	 */
	public Sphinx (Riddle riddle, Key key, String des) {
		
		this.riddle = riddle;
		this.key = key;
		descrip = des;
	}
		
	/**
	 * Getter method for description.
	 * @return the description.
	 */
	public String getDes() {
		return descrip;
	}
	
	/**
	 * Getter method for the riddle.
	 * @return the riddle.
	 */
	public Riddle getRiddle() {
		return riddle;
	}
	
	/**
	 * Getter method for the key.
	 * @return the key.
	 */
	public Key getKey() {
		return key;
	}

	
}
