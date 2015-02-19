package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Mountain extends HexTile {
	
	/*
	 * Constructors
	 */
	public Mountain() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Mountain(int angle) {
		
		super(angle, "mountain1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "MN";

		// Define the clearings
		Clearing c1 = new Clearing(1, 169, 171);
		Clearing c2 = new Clearing(2, 119, 291);
		Clearing c3 = new Clearing(3, 240, 286);
		Clearing c4 = new Clearing(4, 250, 71);
		Clearing c5 = new Clearing(5, 374, 291);
		Clearing c6 = new Clearing(6, 345, 163);
			
		// Define their paths
		c1.addAdjacentByPath(3);
		c3.addAdjacentByPath(1);

		c3.addAdjacentByPath(6);
		c6.addAdjacentByPath(3);

		c6.addAdjacentByPath(5);
		c5.addAdjacentByPath(6);

		c5.addAdjacentByPath(2);
		c2.addAdjacentByPath(5);
		
		c2.addAdjacentByPath(4);
		c4.addAdjacentByPath(2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
