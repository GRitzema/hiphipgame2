package game;

public class CheckAction implements Action{

	private Player p;
	private Inventory pockets;
	
	public CheckAction(Player p) {
		this.p = p;
		this.pockets = p.getPockets();
	}

	
	public void takeAction() {
		System.out.println("Check what?");
		
	}

	
	public void takeAction(String substring) {
		if (pockets.receiveItem(substring) != null) {
			System.out.println(pockets.receiveItem(substring).getDescription());
		}
		else {
			System.out.println("You do not have that item");
		}
	}
	
	
}
