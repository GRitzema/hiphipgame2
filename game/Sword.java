package game;

public class Sword implements Item{
	
	private String material;
	private Inventory pockets;
	private String name;
	private String description;
	
	
	public Sword(Inventory pockets, String material, String name, String description) {
		this.pockets = pockets;
		this.material = material;
		this.name = name;
		this.description = description;
		
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}
	
	public void pickUp() {
		pockets.addToInventory(new Sword(pockets, material, name, description));
	}
		
	public String getMaterial() {
		return material;
	}

	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isEdible() {
		return false;
	}
}
