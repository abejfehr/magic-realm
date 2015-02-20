package com.magicrealm.common.treasures;

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
	private static boolean canMove = false; 
	private boolean active; 
	
	
	/*TODO: Create Toad stool circle constructor */ 
	public ToadStoolCircle() { 
		super(false);	
	}

	/* Get and Set methods */
	public boolean isActive() { return active; }

	public void setActive(boolean active) { this.active = active; }
}
