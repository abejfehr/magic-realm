package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class DeepWoods extends HexTile {
	
	/*
	 * Constructors
	 */
	public DeepWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public DeepWoods(int angle) {
		
		super(angle, "deepwoods1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		
		code = "DW";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 163, 109);
		Clearing c2 = new Clearing(2, 382, 221);
		Clearing c3 = new Clearing(3, 300, 347);
		Clearing c4 = new Clearing(4, 87, 220);
		Clearing c5 = new Clearing(5, 147, 324);
		Clearing c6 = new Clearing(6, 239, 242);
			
		// Define their paths
		c1.addAdjacentByPath(6);
		c6.addAdjacentByPath(1);

		c6.addAdjacentByPath(4);
		c4.addAdjacentByPath(6);

		c4.addAdjacentByPath(5);
		c5.addAdjacentByPath(4);

		c3.addAdjacentByPath(5);
		c5.addAdjacentByPath(3);

		c2.addAdjacentByPath(3);
		c3.addAdjacentByPath(2);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
