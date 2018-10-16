package game;

public class Key implements Item{

	private Inventory pockets;
	private String name;
	private String description;
	
	public Key(String name, String description) {		
		this.pockets = pockets;
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}
	
	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return false;
	}
<<<<<<< HEAD
	
	public void use() {
		if ()
	}
	
=======

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

>>>>>>> df47345dd23277ba0dd5854766161b00e4fe4105
}