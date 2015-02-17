package com.magicrealm.common;

import com.magicrealm.common.weapon.ShortSword;

public class Amazon extends Character{
	public Amazon(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
		this.weapon = new ShortSword();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Amazon");
	}
}
