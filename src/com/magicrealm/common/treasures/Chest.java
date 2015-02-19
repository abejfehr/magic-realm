package com.magicrealm.common.treasures;

// Chest is not a type of treasure, chest CONTAINS treasure 
public class Chest {
	 /* Chest: Only way to open is with the lost keys
		* is LostKey active?
		* is  chest active?
		* bool chestIsOpen 
	*/
	private boolean isOpen;
	Treasure treasure = new Treasure();
	
	public Chest (boolean isOpen) {
		// When chest is created it has to be closed
		// player must gain key in order to open the chest 
		this.isOpen = false; 
	}
	
	/* TODO: Create void remove(): check if chest is open, if so remove chest card */
	/* TODO: Create bool canOpen(): check if haslost key and a chest object */
	/* TODO: Create void open(): check if canOpen if T then add coins = coins + 50. Player keeps treasures*/
}
