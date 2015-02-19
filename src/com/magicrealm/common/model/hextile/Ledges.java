package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Ledges extends HexTile {
	
	/*
	 * Constructors
	 */
	public Ledges() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Ledges(int angle) {
		
		super(angle, "ledges1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "LE";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 270, 311);
		Clearing c2 = new Clearing(2, 360, 155);
		Clearing c3 = new Clearing(3, 376, 274);
		Clearing c4 = new Clearing(4, 250, 211);
		Clearing c5 = new Clearing(5, 156, 124);
		Clearing c6 = new Clearing(6, 171, 351);
			
		// Define their paths
		c3.addAdjacentByPath(6);
		c6.addAdjacentByPath(3);

		c6.addAdjacentByPath(1);
		c1.addAdjacentByPath(6);

		c1.addAdjacentByPath(4);
		c4.addAdjacentByPath(1);

		c2.addAdjacentByPath(5);
		c5.addAdjacentByPath(2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
