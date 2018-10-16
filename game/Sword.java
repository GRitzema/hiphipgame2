package game;

public class Sword implements Item{
	
	private String material;
	private Inventory pockets;
	private String name;
	private String description;
	private int durability;
	
	public Sword(Inventory pockets, String material, String name, String description) {
		this.pockets = pockets;
		this.material = material;
		this.name = name;
		this.description = description;
		if (material.equals("wood"))
			durability = 1;
		else if (material.equals("iron"))
			durability = 2;
		else if(material.equals("diamond"))
			durability = 3;
		
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
	
	public int getDurability() {
		return durability;
	}
	
	public String getMaterial() {
		return material;
	}
}
