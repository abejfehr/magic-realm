package com.magicrealm.common;

public class BlackKnight extends Character{
	public BlackKnight(String name){
		super(Vulnerability.MEDIUM, 40,name);
		this.setStartingPoint();
	} 
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Black Knight");
	}
}
