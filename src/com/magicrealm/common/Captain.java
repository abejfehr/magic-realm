package com.magicrealm.common;

import com.magicrealm.common.weapon.ShortSword;

public class Captain extends Character{
	public Captain(String name){
		super(Vulnerability.MEDIUM, name);
		//Needs to set starting point between INN, HOUSE, GUARD_HOUSE
		this.weapon = new ShortSword();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Captain");
	}
}
