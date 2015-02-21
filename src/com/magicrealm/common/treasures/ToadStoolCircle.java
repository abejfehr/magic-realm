package com.magicrealm.common.treasures;


import com.magicrealm.common.die.Die;
import com.magicrealm.common.weapon.DevilSword;



/* 	TOADSTOOL CIRCLE
Die	
Roll:	Effect on the searching character:
1	He takes the Devil sword. If it is gone, he gets nothing.
2	He takes the treasure card. If it is gone, he gets nothing.
3	He instantly teleports to any cave clearing he chooses, remaining hidden if he was hidden, and he continues his turn from there. If he is already in a cave, he can choose to stay there.  All followers are left behind.
4	For the rest of the day each time he uses the Peer table he can search any clearing (including caves). Similarly, each time he does an Enchant activity he can do it in any clearing, as if he were in that clearing.
5	He must roll on the Power of the Pit table with himself as the target.
6	He must roll for a Curse.


*/

public class ToadStoolCircle extends SiteCard {

	/* Variables to consider for this card */
	@SuppressWarnings("unused") //really though, leave me alone.
	private static boolean canMove = false; // this card cannot move, ever. 
	private boolean active;
	private Die die1 = new Die();
	private Die die2 = new Die();
	private int highestRoll;
	
	
	/*TODO: Create Toad stool circle constructor */ 
	public ToadStoolCircle() { 
		super(false);	//Found = False. Created, doesn't mean it's found. 
	}

	/* Get and Set methods */
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
	
	/* TODO: Case 1 Function: He takes the Devil sword. If it is gone, he gets nothing. */
	private void case1() {
		this.weapon = new DevilSword(); 
		/* check if (weapon is on the map) {
		 * if it is, take it 
		 * add it to the player's inventory
		 * then remove it from the world
		 * } 
		 * else {
		 * Print to screen, the item is gone, try again."
		 */
		System.out.println("Rolling 1: Devil sword");	
	}
	/* TODO: Case 2 Function: He takes the treasure card. If it is gone, he gets nothing. */
	private void case2() {
		this.treasure = new Treasure(false); // This card can't be moved 
		/* check if (treasure is on the map) {
		 * if it is, take it 
		 * add it to the player's inventory
		 * then remove it from the world
		 * } 
		 * else {
		 * Print to screen, the item is gone, try again."
		 */
		System.out.println("Rolling 2: Treasure card");
	}
	/* TODO: Case 3 Function: Instantly teleport to any cave clearing.*/
	private void case3() {
		// if hidden, stay hidden
		// continue turn from new location
		
		// if already in a cave, you can choose to stay. 
		// all followers are left behind. 
		System.out.println("Rolling 3: Teleport to any cave clearing");
	}
	/* TODO: Case 4 Function*/
	private void case4() {
		/* For the rest of the day each time he uses the Peer table he can search any clearing (including caves). 
		Similarly, each time he does an Enchant activity he can do it in any clearing, as if he were in that clearing. */
		System.out.println("Rolling 4: Search any clearing");
	}
	/* TODO: Case 5 Function*/
	private void case5() {
		/* He must roll on the Power of the Pit table with himself as the target.*/
		System.out.println("Rolling 5: Roll on the Power of the Pit");
	}
	/* TODO: Case 6 Function*/
	private void case6() {
		/* He must roll for a Curse. */
		System.out.println("Rolling 6: Roll for a Curse");
	}
	
	/* I don't really this code, get is fine, you can remove this, it won't hurt */ 
	public int getHighestRoll() { return highestRoll; }
	public void setHighestRoll(int highestRoll) { this.highestRoll = highestRoll; }
	
}
