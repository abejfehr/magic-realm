package com.magicrealm.common.character;

/*
 * Amazon sub-class of Character
 * 
 * Functions
 * ----------
 * -toString() prints out info for testing
 */
import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.ShortSword;

public class Amazon extends Character{
	
	/*
	 * Constructors
	 */
	
	public Amazon(String name){
		
		super(Vulnerability.MEDIUM, name, "amazon.png");
		this.setStartingPoint();
		this.weapon = new ShortSword();
		this.location = startingPoint.getLocation();
		Amazon.MAX_NUMBER_OF_ACTIONS = 4;
		
	}
	
	// no-args for serialization
	
	public Amazon(){ 
		
		super(Vulnerability.MEDIUM, "new amazon", "amazon.png");
		this.setStartingPoint();
		this.weapon = new ShortSword();
		this.location = startingPoint.getLocation();
		Amazon.MAX_NUMBER_OF_ACTIONS = 4;
		
	}
	
	/*
	 * Overrides javas toString method
	 */
	@Override
	public String toString(){return ("Amazon");}
	
}
