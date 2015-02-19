package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class DarkValley extends HexTile {
	
	/*
	 * Constructors
	 */
	public DarkValley() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public DarkValley(int angle) {
		
		super(angle, "darkvalley1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		code = "DV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 365, 151);
		Clearing c2 = new Clearing(2, 253, 84);
		Clearing c4 = new Clearing(4, 185, 250);
		Clearing c5 = new Clearing(5, 363, 279);
			
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
