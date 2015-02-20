package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;

public class Treasure {

	/* Each of these cards has a box of treasures on the Set Up Card. 
	 * When a card Is found, its treasures become available in some way. 
	*/
	
	/* Variables */
	Die die = new Die(); 
	int dieNumber = die.getCurrentNumber();
	private int gold;
	
	
	/* Constructor */
	public Treasure() { } 
	
	/* Types of treasures 
	 * Substitute cards (Has-a relationship): Exchanged for treasures in it's box. When used, it's removed from the game
	 * Chest (Has-a relationship): Only way to open is with the lost keys
	 * Mouldy Skeleton: Reveal, roll for a curse. When exchanged, player does not keep treasures 
	 * Remains of thief: Reveal, roll for a curse. Keep treasures, add 20 gold. 
	 */
	
	/* TODO: needs more phase treasures, how are we talking care of phases?*/

	
}
