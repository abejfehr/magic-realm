package com.magicrealm.common;

public class Swordsman extends Character{
	public Swordsman(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Swordsman");
	}
}
