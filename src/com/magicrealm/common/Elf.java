package com.magicrealm.common;

public class Elf extends Character{
	public Elf(String name){
		super(Vulnerability.LIGHT, name);
		this.setStartingPoint();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Elf");
	}
}
