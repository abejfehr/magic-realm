package com.magicrealm.common.character;

/*
 * BlackKnight sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.Mace;

public class BlackKnight extends Character{
	
	/*
	 * Constructors
	 */
	
	public BlackKnight(String name){
		
		super(Vulnerability.MEDIUM, name, "black_knight.png");
		this.setStartingPoint();
		this.weapon = new Mace();
		
	} 
	
    // no-args for serialization
	
	public BlackKnight(){
		
		super(Vulnerability.MEDIUM, "new black knight", "black_knight.png");
		this.setStartingPoint();
		this.weapon = new Mace();
		
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){return (""+ this.name + ", the Black Knight");}
	
}
