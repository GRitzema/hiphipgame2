package game;

public class ReadAction implements Action {

	private Player p;
	private Inventory pockets;
	
	
	public ReadAction(Player p) {
		this.p = p;
		this.pockets = p.getInventory();
	}

	
	public void takeAction() {
		System.out.print("Read what?");
	}

	
	public void takeAction(String item) {
		String hold = item.substring(item.indexOf(' ') + 1);
		if (hold.equals("scroll")) {
			pockets.receiveItem(item).use();
		}
		else {
			System.out.println("You can't read that.");
		}
	}
}
