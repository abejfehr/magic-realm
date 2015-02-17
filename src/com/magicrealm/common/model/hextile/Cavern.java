package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Cavern extends HexTile {
	
	public Cavern(int step) {
		super(step, "cavern1.gif");

		code = "CN";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 374, 147);
		Clearing c2 = new Clearing(2, 246, 78);
		Clearing c3 = new Clearing(3, 245, 180);
		Clearing c4 = new Clearing(4, 252, 359);
		Clearing c5 = new Clearing(5, 136, 150);
		Clearing c6 = new Clearing(6, 298, 269);
		
		// Define their paths
		c1.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c1);

		c3.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c3);

		c3.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c3);

		c6.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c6);

		c4.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c4);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
