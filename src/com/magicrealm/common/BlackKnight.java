package com.magicrealm.common;

import com.magicrealm.common.weapon.Mace;

public class BlackKnight extends Character{
	public BlackKnight(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
		this.weapon = new Mace();
	} 
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Black Knight");
	}
}
