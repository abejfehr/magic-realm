package com.magicrealm.common;

import com.magicrealm.common.weapon.LightBow;

public class Elf extends Character{
	public Elf(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
		this.weapon = new LightBow(); 
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Elf");
	}
}
