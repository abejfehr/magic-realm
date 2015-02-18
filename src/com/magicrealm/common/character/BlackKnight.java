package com.magicrealm.common.character;

import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.Mace;

public class BlackKnight extends Character{
	public BlackKnight(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
		this.weapon = new Mace();
		setImage("black_knight.png");
	} 
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Black Knight");
	}
}
