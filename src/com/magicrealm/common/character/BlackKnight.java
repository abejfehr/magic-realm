package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.Mace;
import com.magicrealm.common.weapon.ShortSword;

public class BlackKnight extends Character{
	public BlackKnight(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
		this.weapon = new Mace();
		//setImage("black_knight.png");
	} 
	public BlackKnight(){ // no-args for serialization
		super(Vulnerability.MEDIUM, "new black knight");
		this.setStartingPoint();
		this.weapon = new Mace();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Black Knight");
	}
}
