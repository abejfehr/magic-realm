package com.magicrealm.common;

public class Amazon extends Character{
	public Amazon(String name){
		super(Vulnerability.MEDIUM, name);
		this.setStartingPoint();
	}
	
	@Override
	public String toString(){
		return (""+ this.name + ", the Amazon");
	}
}
