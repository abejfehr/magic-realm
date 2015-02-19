package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Ruins extends HexTile {
	
	/*
	 * Constructors
	 */
	public Ruins() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Ruins(int angle) {
		
		super(angle, "ruins1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "RN";

		// Define the clearings
		Clearing c1 = new Clearing(1, 161, 149);
		Clearing c2 = new Clearing(2, 323, 88);
		Clearing c3 = new Clearing(3, 368, 286);
		Clearing c4 = new Clearing(4, 234, 259);
		Clearing c5 = new Clearing(5, 146, 329);
		Clearing c6 = new Clearing(6, 329, 183);
		
		// Define their paths
		c1.addAdjacentByPath(2);
		c2.addAdjacentByPath(1);

		c1.addAdjacentByPath(4);
		c4.addAdjacentByPath(1);

		c4.addAdjacentByPath(6);
		c6.addAdjacentByPath(4);

		c6.addAdjacentByPath(3);
		c3.addAdjacentByPath(6);
		
		c3.addAdjacentByPath(5);
		c5.addAdjacentByPath(3);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
