package game;

public class Sword implements Item{
	
	private String material;
	private String name;
	private String description;

	private Player wielder;

	private String type = "sword";

	
	public Sword(String material, String name, String description, Player wielder) {
		this.material = material;
		this.name = name;
		this.description = description;
		this.wielder = wielder;
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public String returnName() {
		return name;
	}
	
		
	public String getMaterial() {
		return material;
	}


	
	public void use() {	
		wielder.setSword(this);
		System.out.println("You have equipped " + this.returnName() + "!");
	}
	
	public boolean isEdible() {
		return false;
	}

	@Override
	public String returnType() {
		return type;
	}
}
