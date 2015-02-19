package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class MapleWoods extends HexTile {
	
	/*
	 * Constructors
	 */
	public MapleWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public MapleWoods(int angle) {
		
		super(angle, "maplewoods1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "MW";
		
		// Define the clearings
		Clearing c2 = new Clearing(2, 317, 117);
		Clearing c4 = new Clearing(4, 371, 274);
		Clearing c5 = new Clearing(5, 143, 216);
			
		// Define their paths
		c2.addAdjacentByPath(4);
		c4.addAdjacentByPath(2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
