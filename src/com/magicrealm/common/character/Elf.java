package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.LightBow;

public class Elf extends Character{
	public Elf(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
		this.weapon = new LightBow(); 
		setImage("elf.png");
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Elf");
	}
}
