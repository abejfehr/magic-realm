package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class PineWoods extends HexTile {

	/*
	 * Constructors
	 */
	public PineWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public PineWoods(int angle) {
		
		super(angle, "pinewoods1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "PW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 120, 194);
		Clearing c4 = new Clearing(4, 233, 81);
		Clearing c5 = new Clearing(5, 358, 211);
			
		// Define their paths
		c2.addAdjacentByPath(4);
		c4.addAdjacentByPath(2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
