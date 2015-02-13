package com.magicrealm.common;

public class VictoryCondition {
	/*
	 * Victory Points to win Game
	 */
	int treasurePoints, famePoints, notorietyPoints, goldPoints, spellPoints;
	
	/*
	 * Constructor
	 * 0-5 Victory points for each victory category, 5 in total
	 */
	public VictoryCondition(int treasureVictory, int fameVictory, int notorietyVictory ,int goldVictory, int spellVictory){		
		if (treasureVictory + fameVictory + notorietyVictory + goldVictory + spellVictory == 5){
			treasurePoints  = treasureVictory;
			famePoints      = 10*fameVictory;
			notorietyPoints = 20*notorietyVictory;
			goldPoints      = 30*goldVictory;
			spellPoints     = 2*spellVictory;
		} else {
			//throw some error reselect victory points
		}
	}
	
	public boolean checkForVictory(int treasure, int fame, int notoriety,int gold, int spell){
		if(treasure >= treasurePoints && fame >= famePoints && notoriety >= notorietyPoints 
				&& gold >= goldPoints && spell >= spellPoints){
			return true;
		} else{
			return false;
		}
		
	}
}
