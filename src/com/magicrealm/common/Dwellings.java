package com.magicrealm.common;

public class Dwellings {
	
	static final int NOT_SET        = 0;
	static final int INN            = 1;
	static final int CHAPEL	        = 2;
	static final int SMALL_CAMPFIRE = 3;
	static final int LARGE_CAMPFIRE = 4;
	static final int GUARD_HOUSE    = 5;
	static final int HOUSE          = 6;
	static final int TWO_GHOSTS     = 7;
	
	
	int dwelling;
	public Dwellings(int dwelling){
		this.dwelling = dwelling;
	}

}
