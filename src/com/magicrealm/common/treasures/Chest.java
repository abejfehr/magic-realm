package com.magicrealm.common.treasures;

public class Chest extends Treasure {
	 /* Chest: Only way to open is with the lost keys
		* is LostKey active?
		* is  chest active?
		* bool chestIsOpen 
	*/
	private boolean isOpen; 
	
	public Chest (boolean isOpen) {
		// When chest is created it has to be closed
		// player must gain key in order to open the chest 
		this.isOpen = false; 
	}
	
	/* TODO: Create void removeChest(): check if chest is open, if so remove chest card */
	/* TODO: Create bool canOpen(): check if haslost key and a chest object */
}
