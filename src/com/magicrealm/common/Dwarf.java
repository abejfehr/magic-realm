package com.magicrealm.common;

public class Dwarf extends Character{
	public Dwarf(String name){
		super(Vulnerability.HEAVY, 23,name);
		//Needs to set starting dwelling between INN or GUARD_HOUSE
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Dwarf");
	}
}
