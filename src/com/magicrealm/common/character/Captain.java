package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.ShortSword;

/*
 * Captain sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */

public class Captain extends Character{
	
	/*
	 * Constructors
	 */
	
	public Captain(String name){
		
		super(Vulnerability.MEDIUM, name, "captain.png");
		this.weapon = new ShortSword();
		Captain.MAX_NUMBER_OF_ACTIONS = 4;
		
	}
	
	// no-args for serialization
	
	public Captain(){ 
		super(Vulnerability.MEDIUM, "new captain", "captain.png");
		this.weapon = new ShortSword();
		Captain.MAX_NUMBER_OF_ACTIONS = 4;
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){return ("Captain");}
	
}
