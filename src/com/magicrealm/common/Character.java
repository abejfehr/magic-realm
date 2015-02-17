package com.magicrealm.common;

public abstract class Character {
	/*
	 * Parameters
	 */
	//Weapon
	//Armour
	//Combat chits
	//List of active chits
	//Active belongings
	//inactive belongings
	//Friendly
	//Unfriendly
	//Ally
	//Enemy
	protected String name;
	protected Vulnerability vulnerability;
    protected int treasureCount, gold, notorietyCount, fameCount, spellCount;
	protected VictoryCondition victoryCondition;
	protected Dwellings startingPoint;
    
    /*
     * Constructors
     */
    public Character(int vulnerability, String name){
    	this.vulnerability  = new Vulnerability(vulnerability);
    	this.startingPoint  = new Dwellings(Dwellings.NOT_SET);
    	this.name           = name;
    	this.gold           = 10;
    	this.treasureCount  = 0;
    	this.notorietyCount = 0;
    	this.fameCount      = 0;
    	this.spellCount     = 0;
    	
    }
    
    /*
     * Default Starting Position for Most Characters, at the INN
     */
    public void setStartingPoint(){
    	startingPoint.dwelling = Dwellings.INN;
    }
    /*
     * Optional Cheat set startingPoint for potential to set start any of the dwellings
     */
    public void setStartingPoint(int startingDwelling){
    	startingPoint.dwelling = startingDwelling;
    	
    }
    
    protected void setVictoryCondition(int treasure,int fame, int notoriety,int gold,int spell){
    	victoryCondition = new VictoryCondition(treasure, fame, notoriety, gold, spell);   	
    }
    
            
}
