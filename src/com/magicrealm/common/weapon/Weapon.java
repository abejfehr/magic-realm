package com.magicrealm.common.weapon;

public class Weapon {

	//attack, length, price
	
	// Players can have only one active Weapon at a time 
	
	/* Class Variables */
	protected String attackType;
	protected int length; 
	protected int price;
	protected boolean isActive;
	protected String imageFilename; 
	
	/* Constructor */ 
	public Weapon(String attackType, int length, int price) {
		this.attackType = attackType;
		this.length = length;
		this.price = price;
		this.isActive = true; 
	}
	/* Get Methods */
	public String getAttackType() { return attackType; }
	public int getLength() { return length; }
	public int getPrice() { return price; }
	
	public boolean isActive() { 
		return isActive; 
	} 
	

 	/* Set Methods */ 
	public void setAttackType(String a) { attackType = a; }
	public void setLength(int l) { length = l; }
	public void setPrice(int p) { price = p;}
	public void setActivation(boolean a) { isActive = a; }
}
