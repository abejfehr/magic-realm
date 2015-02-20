package com.magicrealm.common.treasures;

// Chest is not a type of treasure, chest CONTAINS treasure 
public class Chest {
	 /* Chest: Only way to open is with the lost keys
		* is LostKey active?
		* is  chest active?
		* bool chestIsOpen 
	*/
	
	//Will be used later on to check if the chest is open.
	private boolean isOpen;
	
	// we can assume for now that the chest is active and ready to be used at all times 
	private boolean isActive  = true;
	
	// This might have to be it's own class instead of a variable
	// lost keys can be found on the map, not in chests. 

	private boolean hasLostKey;
	
	// Create new treasure item that is given to the player once the chest is open
	Treasure treasure = new Treasure();
	
	private int gold; 
	private int goldBonus = 50; 
	
	
	
	
	
	/* Constructor */
	public Chest (boolean isOpen) {
		// When chest is created it has to be closed
		// player must gain key in order to open the chest 
		this.isOpen = false; 
	}
	
	/* TODO: Create bool canOpen(): check if haslostkey and a chest object */
	public boolean canOpen() {
		if((hasLostKey == true) && (isActive == true)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* TODO: Create void remove(): check if chest is open, if so remove chest card */
	
	/* TODO: Create void open(): check if canOpen if T then add coins = coins + 50. Player keeps treasures*/
	public void open() {
		if((isOpen == false) && this.canOpen()) {
			// might need some try catch here because the chest would be called from the map which
			// would  be on the server
			/*TODO: Talk to team mates about how this can be done*/  
			
			
		}
		else {
			System.out.println("This chest has been already opened, please try again");
		}
	}

	/* Get and Set methods for the gold in the chest, but we might not need these, so we'll see */ 
	public int getGold() { return gold; }

	public void setGold(int gold) { this.gold = gold; }

	public int getGoldBonus() { return goldBonus; }

	public void setGoldBonus(int goldBonus) { this.goldBonus = goldBonus; }
}
