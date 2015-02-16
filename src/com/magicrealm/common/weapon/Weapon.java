package com.magicrealm.common.weapon;

public class Weapon {

	//attack, length, price
	
	/* Class Variables */
	protected String attackType;
	protected int length; 
	protected int price; 
	
	/* Constructor */ 
	public Weapon(String attackType, int length, int price) {
		this.attackType = attackType;
		this.length = length;
		this.price = price; 
	}
	/* Get Methods */
	public String getAttackType() { return attackType; }
	public int getLength() { return length; }
	public int getPrice() { return price; }
	

 	/* Set Methods */ 
	public void setAttackType(String a) { attackType = a; }
	public void setLength(int l) { length = l; }
	public void setPrice(int p) { price = p;}
}
