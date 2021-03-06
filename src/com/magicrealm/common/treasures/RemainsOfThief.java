package com.magicrealm.common.treasures;

import com.magicrealm.common.die.Die;

/* Remains of thief: Reveal, roll for a curse. Keep treasures, add 20 gold. */

public class RemainsOfThief {

	/*Variables*/
	private boolean active;
	private boolean open; 
	private int gold;
	private int goldBonus = 20; 
	Die die = new Die();
	private int dieNumber = die.getCurrentNumber();
	
	@SuppressWarnings("unused") //really though, leave me alone. 
	private static boolean canMove = false; 
	
	/*TODO: Constructor */
	public RemainsOfThief() { 
		this.active = false;
		this.open = false; 
	}

	/* Get and Set Methods */ 
	public boolean isActive() { return active; }
	public int getGold() { return gold; }
	public boolean getOpen() { return open; }
	
	public void setActive(boolean active) { this.active = active; }
	public void setGold(int gold) { this.gold = gold + goldBonus; }
	
	// I rather not, but just in case :3 
	public static void setCanMove(boolean canMove) { RemainsOfThief.canMove = canMove; }
	
	
	/*TODO: void open() - reveal and roll for a curse*/
	public void open() {
		if(active == true) {
			System.out.println("Congrats! You Opened: Remains of Thief");
			System.out.println("Roll for a curse!"); 
			die.roll();
			System.out.println("You rolled: " + dieNumber + " Yay!");
			open = true; 
		}
		else {
			System.out.println("This item cannot be open");
			open = false;
		}
	}

	/*TODO: void close() - keep treasure, coins = coins + 20*/
	public void close() {
		if(open == true) {
			System.out.println("Closing your treasure (Remains of thief)....");
			gold = gold + goldBonus;
			
			// I'm making things up, I don't know where the player can store his/her gold/ D:
			System.out.println( gold + " has been added to your pocket 'o gold.");
		}
		else  {
			System.out.println("The Chest was not open, gonna try to open it now....");
			this.open();
		}
	}

}
