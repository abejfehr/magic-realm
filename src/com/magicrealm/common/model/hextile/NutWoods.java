package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class NutWoods extends HexTile {

	/*
	 * Constructors
	 */
	public NutWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public NutWoods(int angle) {
		
		super(angle, "nutwoods1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		
		code = "NW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 185, 106);
		Clearing c4 = new Clearing(4, 352, 137);
		Clearing c5 = new Clearing(5, 247, 282);
			
		// Define their paths
		c2.addAdjacentByPath(4);
		c4.addAdjacentByPath(2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
