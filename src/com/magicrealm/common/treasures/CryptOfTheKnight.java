package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;

/*
 * 	CRYPT OF THE KNIGHT
Die	
Roll:	Effect on the searching character:
1	He takes the warhorse. If it is gone, he gets nothing.
2	He takes the “T” suit of armor. If it is gone, he gets nothing.
3	He takes the Bane sword. If it is gone, he gets nothing.
4	He takes the treasure card. If it is gone, he gets nothing.
5	He adds one point to his recorded Gold. These Gold points remain available when all of the treasures are gone.
6	He must roll for a Curse.

 */
public class CryptOfTheKnight extends SiteCard {

	/* Variables */
	private boolean active;
	private Die die1 = new Die();
	private Die die2 = new Die();
	private int highestRoll;
	
	/* Constructor */
	public CryptOfTheKnight() {
		super(false);
	}

	public boolean isActive() { return active; }

	public void setActive(boolean active) { this.active = active; }
	
	/* TODO: public void open() */
	public void open() {
		if((active == true) && (this.isFound() == true)) {
			//open this card
			highestRoll = this.highestRoll(die1, die2); 
			
			switch(highestRoll) {
			case 1: case1();
					break; 
			case 2: case2();
					break;
			case 3: case3();
					break;
			case 4: case4();
					break;
			case 5: case5();
					break;
			case 6: case6();
					break; 
			default: System.out.println("Something went wrong? Can't find the highest roll"); break;
			
			}
		}
		
	}

	/* TODO: Case 6 function -  He must roll for a Curse.*/
	private void case6() {
		// TODO Auto-generated method stub
		
	}

	/*TODO: Case 5 function - He adds one point to his recorded Gold. 
	 * These Gold points remain available when all of the treasures are gone. 
	 */
	private void case5() {
		// TODO Auto-generated method stub
		
	}
	/*TODO: Case 4 function - He takes the treasure card. If it is gone, he gets nothing. */
	private void case4() {
		// TODO Auto-generated method stub
		
	}

	/* TODO: Case 3 function - He takes the Bane sword. If it is gone, he gets nothing. */
	private void case3() {
		// TODO Auto-generated method stub
		
	}

	/* TODO: Case function - He takes the “T” suit of armor. If it is gone, he gets nothing. */
	private void case2() {
		// TODO Auto-generated method stub
		
	}

	/* TODO: Case 1 function - He takes the warhorse. If it is gone, he gets nothing. */
	private void case1() {
		// TODO Auto-generated method stub
		
		
	}

}
