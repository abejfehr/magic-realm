package com.magicrealm.common;

import com.magicrealm.common.weapon.GreatAxe;

public class Dwarf extends Character{
	public Dwarf(String name){
		super(Vulnerability.HEAVY, name);
		//Needs to set starting dwelling between INN or GUARD_HOUSE
		this.weapon = new GreatAxe();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Dwarf");
	}
}
