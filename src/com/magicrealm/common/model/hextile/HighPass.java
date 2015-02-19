package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class HighPass extends HexTile {
	
	/*
	 * Constructors
	 */
	public HighPass() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public HighPass(int angle) {
		
		super(angle, "highpass1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		
		code = "HP";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 341, 251);
		Clearing c2 = new Clearing(2, 248, 87);
		Clearing c3 = new Clearing(3, 357, 152);
		Clearing c4 = new Clearing(4, 219, 236);
		Clearing c5 = new Clearing(5, 249, 349);
		Clearing c6 = new Clearing(6, 133, 148);
			
		// Define their paths
		c1.addAdjacentByPath(4);
		c4.addAdjacentByPath(1);

		c1.addAdjacentByPath(5);
		c5.addAdjacentByPath(1);

		c4.addAdjacentByPath(2);
		c2.addAdjacentByPath(4);

		c3.addAdjacentByPath(6);
		c6.addAdjacentByPath(3);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
