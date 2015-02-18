package com.magicrealm.common.die;

import java.io.Serializable; 

public class Die implements Serializable {
	private static final long serialVersionUID = -8806212193103753231L;
	/** Variables **/
	int number;
	int id;
	transient private boolean enabled; 
	
	/** Creates a new instance of Dice */
	public Die() {
		this.enabled = true;
		this.roll(); 
	}
	
	/** Roll function **/ 
	public void roll() {
		if(enabled) {
			number = (int)(Math.random()*6) + 1;
		}
		
	}
	
	/** Get current number on roll **/
	public int getCurrentNumber() { return number; }
	public int getId() { return id; }
	
	/** Set a number if you need to for some reason **/ 
	public void setCurrentNumber(int n) { n = number; } 
	public void setEnabled(boolean e) { e = enabled; }
	
	public void reset() {
		this.enabled = true;
		this.roll(); 
	}
	
	public String toString() {
		return Integer.toString(number);
	}

}
