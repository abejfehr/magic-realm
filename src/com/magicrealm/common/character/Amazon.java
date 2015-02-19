package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.ShortSword;

public class Amazon extends Character{
	public Amazon(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
		this.weapon = new ShortSword();
		setImage("amazon.png");
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Amazon");
	}
}
