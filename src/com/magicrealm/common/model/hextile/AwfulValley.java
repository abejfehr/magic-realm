package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class AwfulValley extends HexTile {
	
	/*
	 * Constructors
	 */
	public AwfulValley() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public AwfulValley(int angle) {
		
		super(angle, "awfulvalley1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		
		code = "AV";

		// Define the clearings
		Clearing c1 = new Clearing(1, 135, 154);
		Clearing c2 = new Clearing(2, 132, 278);
		Clearing c4 = new Clearing(4, 308, 251);
		Clearing c5 = new Clearing(5, 240, 84);
			
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
