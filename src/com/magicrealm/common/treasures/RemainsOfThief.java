package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;


//Need to rewrite most of this code 
/* Remains of thief: Reveal, roll for a curse. Keep treasures, add 20 gold. */


public class RemainsOfThief {

	/*Variables*/
	private boolean isActive ;
	private int gold;
	private int goldBonus = 20; 
	Die die = new Die(); 
	
	/*TODO: Constructor */
	public RemainsOfThief() {
		this.setActive(false); 
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/*TODO: void open() - reveal and roll for a curse*/
	
	/*TODO: void close() - keep treasure, coins = coins + 20*/
}
