package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.GreatAxe;
import com.magicrealm.common.weapon.ShortSword;

public class Dwarf extends Character{
	public Dwarf(String name){
		super(Vulnerability.HEAVY, name);
		//Needs to set starting dwelling between INN or GUARD_HOUSE
		this.weapon = new GreatAxe();
		//setImage("dwarf.png");
	}
	public Dwarf(){ // no-args for serialization
		super(Vulnerability.HEAVY, "new dwarf");
		this.setStartingPoint();
		this.weapon = new GreatAxe();
	}
	@Override
	public String toString(){
		return (""+ this.name + ", the Dwarf");
	}
}
