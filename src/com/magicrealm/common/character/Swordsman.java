package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.ThrustingSword;

public class Swordsman extends Character{
	public Swordsman(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
		this.weapon = new ThrustingSword();
		setImage("swordsman.png");
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Swordsman");
	}
}
