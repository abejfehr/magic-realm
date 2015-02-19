package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class LindenWoods extends HexTile {
	
	/*
	 * Constructors
	 */
	public LindenWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public LindenWoods(int angle) {
		
		super(angle, "lindenwoods1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	public void init() {
		
		code = "LW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 251, 278);
		Clearing c4 = new Clearing(4, 134, 150);
		Clearing c5 = new Clearing(5, 301, 123);
			
		// Define their paths
		c2.addAdjacentByPath(4);
		c4.addAdjacentByPath(2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
