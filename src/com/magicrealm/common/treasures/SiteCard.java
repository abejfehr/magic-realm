package com.magicrealm.common.treasures;
 

import com.magicrealm.common.die.Die;
import com.magicrealm.common.weapon.*;


/*
 * When a character draws one of these cards, he turns it face up and crosses it off his Discoveries list 
 * (this is the only way a Site card can be discovered by searching). 
 * Then he returns it to the box he drew it from, at the bottom of the pile of treasures in that box, face up. 
 * The card stays in that box, but it is assumed to be in the same clearing with that box's chit. 
 * If several Site cards are in the same box, the one that was drawn most recently is the one that is on the bottom of the pile. 
 * When a character is in the same clearing with a Site card that he has crossed off, he can use Search phases to loot it. 
 * He must use the special table for that card - he cannot use the Loot table (nor Magic Sight) to loot a site card. 
 * 
 * He rolls two dice and uses the high roll to find his result, and all die roll modifications that apply to Loot rolls apply to his roll. 
 * The table for each Site card is given below, and an abbreviated version is shown on the Set Up Card.
 */

public class SiteCard {
	 
	/* Variables */
	private Die die1 = new Die();
	private Die die2 = new Die();
	private boolean found; // If this is true, you found a site card and now you can roll some sweet dice. 
	private int number1 = die1.getCurrentNumber();
	private int number2 = die2.getCurrentNumber(); 
	protected Weapon weapon; 
	protected Treasure treasure;
	
	
	/*TODO: Create constructor */
	public SiteCard(boolean found) { 
		this.found = false; 
	}

	/* Get and Set Methods */
	public boolean isFound() { return found; }
	public void setFound(boolean found) { this.found = found; }
	
	/*TODO: void open() - what happens when you open site cards? */
	public void open() { /*TODO*/ }
	
	/* TODO: public void boolean */
	/* Searching
	- is it found while searching? 
	- if so, call open()*/
	
	/*TODO: Get the high roll */
	public int highestRoll(Die die1, Die die2) {
		// Just clear everything before you roll
		int highestRoll = 0;
		resetDice();
		
		// Okay we're ready to roll!
		rollDice(); 
		System.out.println("Your first roll is: " + number1); 
		System.out.println("Your second roll is: " + number2); 

		// Find the highest roll between the two outputs 
		highestRoll = Math.max(number1, number2);
		System.out.println("The highest roll is: " + highestRoll);
		
		// and display it
		return highestRoll; 		
	}
	
	/* Roll Two die*/
	public void rollDice() {
		die1.roll();
		die2.roll(); 
	}

	/* Reset Dice rolls */ 
	public void resetDice() {
		// reset calls die.roll(); 
		// which just means this also re-rolls them. 
		die1.reset();
		die2.reset(); 
	}
	
	

}
