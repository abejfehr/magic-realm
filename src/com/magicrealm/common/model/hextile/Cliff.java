package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Cliff extends HexTile {
	
	/*
	 * Constructors
	 */
	public Cliff() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Cliff(int angle) {
		
		super(angle, "cliff1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		code = "CL";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 134, 151);
		Clearing c2 = new Clearing(2, 138, 283);
		Clearing c3 = new Clearing(3, 246, 218);
		Clearing c4 = new Clearing(4, 363, 149);
		Clearing c5 = new Clearing(5, 368, 285);
		Clearing c6 = new Clearing(6, 250, 88);
			
		// Define their paths
		c1.addAdjacentByPath(6);
		c6.addAdjacentByPath(1);

		c6.addAdjacentByPath(4);
		c4.addAdjacentByPath(6);

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
