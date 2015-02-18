package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Ruins extends HexTile {
	
	public Ruins(int step) {
		super(step, "ruins1.gif");
		code = "RN";

		// Define the clearings
		Clearing c1 = new Clearing(1, 161, 149);
		Clearing c2 = new Clearing(2, 323, 88);
		Clearing c3 = new Clearing(3, 368, 286);
		Clearing c4 = new Clearing(4, 234, 259);
		Clearing c5 = new Clearing(5, 146, 329);
		Clearing c6 = new Clearing(6, 329, 183);
		
		// Define their paths
		c1.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c1);

		c1.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c1);

		c4.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c4);

		c6.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c6);
		
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
