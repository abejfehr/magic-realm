package com.magicrealm.common.treasures;


import com.magicrealm.common.die.Die;


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
			case 1: /* He takes the Devil sword. If it is gone, he gets nothing. */ break; 
			case 2: /* He takes the treasure card. If it is gone, he gets nothing. */break;
			case 3: /* He instantly teleports to any cave clearing he chooses, remaining hidden if he was hidden, 
			and he continues his turn from there. If he is already in a cave, he can choose to stay there.  
			All followers are left behind.*/ break;
			case 4: /* For the rest of the day each time he uses the Peer table he can search any clearing (including caves). 
			Similarly, each time he does an Enchant activity he can do it in any clearing, as if he were in that clearing. */ break;
			case 5: /* He must roll on the Power of the Pit table with himself as the target.*/ break;
			case 6: /* He must roll for a Curse. */ break; 
			default: System.out.println("Something went wrong? Can't find the highest roll"); break;
			
			}
		}
		
	}

	/* I don't really this code, get is fine, you can remove this, it won't hurt */ 
	public int getHighestRoll() { return highestRoll; }
	public void setHighestRoll(int highestRoll) { this.highestRoll = highestRoll; }
	
}
