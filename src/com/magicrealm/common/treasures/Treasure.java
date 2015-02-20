package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;


/* Each of these cards has a box of treasures on the Set Up Card. 
 * When a card is found, its treasures become available in some way. 
*/

public class Treasure {
	// weight enum? 
	// 1 - large - more treasure
	// 2 - small - less treasure'
	
	
	/* Variables */
	
	private int gold;	
	private int fameBonus; //May affect player's fame. 
	private int famePrice; // Player may be able to sell a Treasure card to an NPC for fame.
	Die die = new Die(); 
	protected int dieNumber = die.getCurrentNumber();
	
	private boolean canMove; //Some treasures cannot be moved
	
	/* Constructor */
	public Treasure(boolean canMove) { 
		this.setCanMove(canMove); 
	} 

	/* Get and Set Methods */ 
	public int getTreasureGold()	{ return gold; }
	public boolean getCanMove() 	{ return canMove; }
	public int getFameBonus() 		{ return fameBonus; }
	public int getFamePrice() 		{ return famePrice; }

	public void setCanMove(boolean canMove) { this.canMove = canMove; }
	public void setFameBonus(int fameBonus) { this.fameBonus = fameBonus; }
	public void setTreasureGold(int gold) 	{ this.gold = gold; }
	public void setFamePrice(int famePrice) { this.famePrice = famePrice; } 

	/*TODO: Create a print method for all treasure description*/
	
}
