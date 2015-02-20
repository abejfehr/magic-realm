package com.magicrealm.common.die;



public class Die{
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
