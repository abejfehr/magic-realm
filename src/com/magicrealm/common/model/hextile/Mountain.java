package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Mountain extends HexTile {
	
	public Mountain(int step) {
		super(step, "mountain1.gif");

		code = "MN";

		// Define the clearings
		Clearing c1 = new Clearing(1, 169, 171);
		Clearing c2 = new Clearing(2, 119, 291);
		Clearing c3 = new Clearing(3, 240, 286);
		Clearing c4 = new Clearing(4, 250, 71);
		Clearing c5 = new Clearing(5, 374, 291);
		Clearing c6 = new Clearing(6, 345, 163);
			
		// Define their paths
		c1.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c1);

		c3.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c3);

		c6.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c6);

		c5.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c5);
		
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
