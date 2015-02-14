package com.magicrealm.common;

public class Captain extends Character{
	public Captain(String name){
		super(Vulnerability.MEDIUM, 35,name);
		//Needs to set starting point between INN, HOUSE, GUARD_HOUSE
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Captain");
	}
}
