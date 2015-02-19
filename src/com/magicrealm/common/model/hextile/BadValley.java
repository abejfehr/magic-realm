package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class BadValley extends HexTile {

	/*
	 * Constructors
	 */
	public BadValley() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public BadValley(int angle) {
		
		super(angle, "badvalley1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		
		code = "BV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 364, 281);
		Clearing c2 = new Clearing(2, 135, 281);
		Clearing c4 = new Clearing(4, 181, 104);
		Clearing c5 = new Clearing(5, 364, 150);
			
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
