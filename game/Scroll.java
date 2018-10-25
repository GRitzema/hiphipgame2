package game;

public class Scroll implements Item {

	private String name;
	private String description;
	private String hint;
	private String type;
	
	public Scroll(String name, String description, String hint, String type) {
		this.name = name;
		this.description = description;
		this.hint = hint;
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	
	public String returnName() {		
		return name;
	}

	
	public boolean isEdible() {
		return false;
	}

	
	public void use() {
		System.out.println("The scroll reads:");
		System.out.println(hint);
		
	}

	@Override
	public String returnType() {
		return type;
	}

}
