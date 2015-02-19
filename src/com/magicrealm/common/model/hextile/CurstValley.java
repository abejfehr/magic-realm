package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class CurstValley extends HexTile {
	
	/*
	 * Constructors
	 */
	public CurstValley() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public CurstValley(int angle) {
		
		super(angle, "curstvalley1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */

	private void init() {
		
		code = "CV";

		// Define the clearings
		Clearing c1 = new Clearing(1, 250, 83);
		Clearing c2 = new Clearing(2, 134, 147);
		Clearing c4 = new Clearing(4, 246, 285);
		Clearing c5 = new Clearing(5, 355, 145);
			
		// Define their paths
		c1.addAdjacentByPath(4);
		c4.addAdjacentByPath(1);

		c2.addAdjacentByPath(5);
		c5.addAdjacentByPath(2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
