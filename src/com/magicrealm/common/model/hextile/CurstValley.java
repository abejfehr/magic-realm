package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class CurstValley extends HexTile {
	
	public CurstValley(int step) {
		super(step, "curstvalley1.gif");
		
		code = "CV";

		// Define the clearings
		Clearing c1 = new Clearing(1, 250, 83);
		Clearing c2 = new Clearing(2, 134, 147);
		Clearing c4 = new Clearing(4, 246, 285);
		Clearing c5 = new Clearing(5, 355, 145);
			
		// Define their paths
		c1.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c1);

		c2.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
