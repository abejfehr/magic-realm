package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class OakWoods extends HexTile {
	
	public OakWoods(int step) {
		super(step, "oakwoods1.gif");
		code = "OW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 360, 205);
		Clearing c4 = new Clearing(4, 134, 280);
		Clearing c5 = new Clearing(5, 189, 114);
			
		// Define their paths
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
