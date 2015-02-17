package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Caves extends HexTile {
	
	public Caves(int step) {
		super(step, "caves1.gif");
		code = "CA";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 356, 284);
		Clearing c2 = new Clearing(2, 133, 282);
		Clearing c3 = new Clearing(3, 227, 215);
		Clearing c4 = new Clearing(4, 276, 345);
		Clearing c5 = new Clearing(5, 136, 150);
		Clearing c6 = new Clearing(6, 314, 86);
		
		// Define their paths
		c1.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c1);

		c6.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c6);

		c4.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c4);

		c2.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c2);

		c3.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c3);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
