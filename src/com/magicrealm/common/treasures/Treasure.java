package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;

public class Treasure {

	/* Each of these cards has a box of treasures on the Set Up Card. 
	 * When a card Is found, its treasures become available in some way. 
	*/
	
	// weight enum? 
	// 1 - large - more treasure
	// 2 - small - less treasure'
	
	
	/* Variables */
	Die die = new Die(); 
	int dieNumber = die.getCurrentNumber();
	private int gold;	
	
	private int fameBonus; //May affect player's fame. 
	private int famePrice; // Player may be able to sell a Treasure card to an NPC for fame. 
	private boolean canMove; //Some treasures cannot be moved
	
	/* Constructor */
	public Treasure(boolean canMove) { 
		this.setCanMove(canMove); 
		} 

	public int getTreasureGold() { return gold; }
	public void setTreasureGold(int gold) { this.gold = gold; }

	public boolean getCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	} 

	/*TODO: Creare a print method for all treasure description*/
	
}
