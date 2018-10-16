package game;

public interface Item {

	public String getDescription();
		
	public String returnName();
	
	public void pickUp();
	
	public boolean isEdible();
	
	public void use();
	
}
