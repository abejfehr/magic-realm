package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Cavern extends HexTile {
	
	/*
	 * Constructors
	 */
	public Cavern() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Cavern(int angle) {
		
		super(angle, "cavern1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "CN";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 374, 147);
		Clearing c2 = new Clearing(2, 246, 78);
		Clearing c3 = new Clearing(3, 245, 180);
		Clearing c4 = new Clearing(4, 252, 359);
		Clearing c5 = new Clearing(5, 136, 150);
		Clearing c6 = new Clearing(6, 298, 269);
		
		// Define their paths
		c1.addAdjacentByPath(3);
		c3.addAdjacentByPath(1);

		c3.addAdjacentByPath(2);
		c2.addAdjacentByPath(3);

		c3.addAdjacentByPath(6);
		c6.addAdjacentByPath(3);

		c6.addAdjacentByPath(4);
		c4.addAdjacentByPath(6);

		c4.addAdjacentByPath(5);
		c5.addAdjacentByPath(4);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
