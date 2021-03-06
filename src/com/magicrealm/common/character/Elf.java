package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.LightBow;

/*
 * Elf sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */

public class Elf extends Character{
	
	/*
	 * Constructors
	 */
	
	public Elf(String name){
		
		super(Vulnerability.LIGHT, name, "elf.png") ;
		this.setStartingPoint();
		this.weapon = new LightBow();
		this.location = startingPoint.getLocation();
		Elf.MAX_NUMBER_OF_ACTIONS = 4;

	}
	
	// no-args for serialization
	
	public Elf(){ 
		
		super(Vulnerability.LIGHT, "new elf", "elf.png");
		this.setStartingPoint();
		this.weapon = new LightBow();
		this.location = startingPoint.getLocation();
		Elf.MAX_NUMBER_OF_ACTIONS = 4;
		
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){return ("Elf");}
	
}
