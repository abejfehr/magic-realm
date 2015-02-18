package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class PineWoods extends HexTile {

	public PineWoods(int step) {
		super(step, "pinewoods1.gif");
		code = "PW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 120, 194);
		Clearing c4 = new Clearing(4, 233, 81);
		Clearing c5 = new Clearing(5, 358, 211);
			
		// Define their paths
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
