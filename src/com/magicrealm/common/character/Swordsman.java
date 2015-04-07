package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.ThrustingSword;

/*
 * Swordsman sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */

public class Swordsman extends Character{
	
	/*
	 * Constructors
	 */
	
	public Swordsman(String name){
		
		super(Vulnerability.LIGHT, name, "swordsman.png");
		this.setStartingPoint();
		this.weapon = new ThrustingSword();
		this.location = startingPoint.getLocation();
		Captain.MAX_NUMBER_OF_ACTIONS = 4;
		
	}
	
	// no-args for serialization
	
	public Swordsman(){ 
		
		super(Vulnerability.LIGHT, "new swordsman", "swordsman.png");
		this.setStartingPoint();
		this.weapon = new ThrustingSword();
		this.location = startingPoint.getLocation();
		Captain.MAX_NUMBER_OF_ACTIONS = 4;
	
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){ return ("Swordsman");}
	
}
