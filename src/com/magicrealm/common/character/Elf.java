package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.LightBow;
import com.magicrealm.common.weapon.ShortSword;

public class Elf extends Character{
	public Elf(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
		this.weapon = new LightBow(); 
		//setImage("elf.png");
	}
	public Elf(){ // no-args for serialization
		super(Vulnerability.LIGHT, "new elf");
		this.setStartingPoint();
		this.weapon = new LightBow();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Elf");
	}
}
