package com.magicrealm.common;

public class Natives {
	
	/*
	 * Parameters
	 */
	
	//Weapon
	//Move strength
	//weapon damage?
	//sharpness?
	//weight
	protected char           ID;
	protected int            secondaryID;
	protected Vulnerability  vulnerability;
	
	
	
	
	public Natives(char groupIdentifier, int secondID, int vulnerability){
		ID                 = groupIdentifier;
		secondaryID        = secondID;
		this.vulnerability = new Vulnerability(vulnerability);
	}

}
