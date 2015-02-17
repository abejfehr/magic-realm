package com.magicrealm.common;

public class VictoryCondition {
	
	/*/
	 * List of Functions
	 *-checkForVictory(int,int,int,int,int) takes in 5 ints to compare against needed values to win 
	 *-printVictoryCondition() returns string containing needed victory points to win (mostly for testing)
	 */
	
	
	/*
	 * Parameters
	 */
	private int treasurePoints, famePoints, notorietyPoints, goldPoints, spellPoints;
	
	/*
	 * Constructor
	 * 0-5 Victory points for each victory category, 5 in total
	 */
	public VictoryCondition(int treasureVictory, int fameVictory, int notorietyVictory ,int goldVictory, int spellVictory){			
		treasurePoints  = treasureVictory;
		famePoints      = 10*fameVictory;
		notorietyPoints = 20*notorietyVictory;
		goldPoints      = 30*goldVictory;
		spellPoints     = 2*spellVictory;
	}
	
	public boolean checkForVictory(int treasure, int fame, int notoriety,int gold, int spell){
		if(treasure >= treasurePoints && fame >= famePoints && notoriety >= notorietyPoints 
				&& gold >= goldPoints && spell >= spellPoints){
			return true;
		} else{
			return false;
		}
		
	}
	
	public String printVictoryCondition(){
		return ("This player needs " + treasurePoints + " Treasure, " + famePoints + " fame points, " + notorietyPoints + 
				" notoriety points, " + goldPoints + " gold points and, " + spellPoints + " spell points to win the Game.");
	}
}
