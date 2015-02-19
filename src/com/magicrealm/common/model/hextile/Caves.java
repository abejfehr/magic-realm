package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Caves extends HexTile {
	
	/*
	 * Constructors
	 */
	public Caves() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Caves(int angle) {
		
		super(angle, "caves1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "CA";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 356, 284);
		Clearing c2 = new Clearing(2, 133, 282);
		Clearing c3 = new Clearing(3, 227, 215);
		Clearing c4 = new Clearing(4, 276, 345);
		Clearing c5 = new Clearing(5, 136, 150);
		Clearing c6 = new Clearing(6, 314, 86);
		
		// Define their paths
		c1.addAdjacentByPath(6);
		c6.addAdjacentByPath(1);

		c6.addAdjacentByPath(4);
		c4.addAdjacentByPath(6);

		c4.addAdjacentByPath(2);
		c2.addAdjacentByPath(4);

		c2.addAdjacentByPath(3);
		c3.addAdjacentByPath(2);

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
