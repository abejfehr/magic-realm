package com.magicrealm.common;

/*
 * VictoryCondition class that every character has to fulfill to win the game
 * 
 * Functions
 * ----------
 *-checkForVictory(int,int,int,int,int) takes in characters 5 victory points to compare against needed values to win 
 *-printVictoryCondition() returns string containing needed victory points to win (mostly for testing)
 */
public class VictoryCondition {
	
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
	
	public VictoryCondition(){
		treasurePoints  = 0;
		famePoints      = 0;
		notorietyPoints = 0;
		goldPoints      = 0;
		spellPoints     = 0;
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
	
	/*
	 * getters
	 */
	
	public int getGoldPoints()     {return goldPoints;}
	public int getTresurePoints()  {return treasurePoints;}
	public int getFamePoints()     {return famePoints;}
	public int getSpellPoints()    {return spellPoints;}
	public int getNotorietyPoints(){return notorietyPoints;}
}
