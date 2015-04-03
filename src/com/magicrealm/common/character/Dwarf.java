package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.GreatAxe;

/*
 * Dwarf sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */

public class Dwarf extends Character{
	
	/*
	 * Constructors
	 */
	
	public Dwarf(String name){
		
		super(Vulnerability.HEAVY, name, "dwarf.png");
		this.weapon = new GreatAxe();
	
	}
	
	// no-args for serialization
	
	public Dwarf(){ 
		
		super(Vulnerability.HEAVY, "new dwarf", "dwarf.png");
		this.setStartingPoint();
		this.weapon = new GreatAxe();
	
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){return ("Dwarf");}
}
