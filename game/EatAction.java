package game;

public class EatAction implements Action{
	
	private Player p;
	private Inventory pockets;
	
	
	public EatAction(Player p) {
		this.p = p;
		this.pockets = p.getInventory();
	}

	@Override
	public void takeAction() {
		System.out.print("Eat what?");
	}

	
	public void takeAction(String item) {
		if (pockets.getPockets().containsKey(item)) {
			if(pockets.receiveItem(item).isEdible()) {
				pockets.receiveItem(item).use();
			} else {
				System.out.println("You can't eat that.");
			}
		}
		else {
			System.out.println("You don't have that :(");
		}
	}
}
