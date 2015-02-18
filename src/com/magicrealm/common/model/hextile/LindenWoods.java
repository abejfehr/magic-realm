package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class LindenWoods extends HexTile {
	
	public LindenWoods(int step) {
		super(step, "lindenwoods1.gif");
		code = "LW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 251, 278);
		Clearing c4 = new Clearing(4, 134, 150);
		Clearing c5 = new Clearing(5, 301, 123);
			
		// Define their paths
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);
		
	}
}
