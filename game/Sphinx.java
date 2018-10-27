package game;

public class Sphinx {
	private Riddle riddle;
	private Key key;
	private String descrip;
	
	public Sphinx (Riddle riddle, Key key, String des) {
		
		this.riddle = riddle;
		this.key = key;
		descrip = des;
	}
		
	public String getDes() {
		return descrip;
	}
	
	public Riddle getRiddle() {
		return riddle;
	}
	
	public Key getKey() {
		return key;
	}

	
}
