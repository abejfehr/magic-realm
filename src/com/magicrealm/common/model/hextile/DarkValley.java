package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class DarkValley extends HexTile {
	
	public DarkValley(int step) {
		super(step, "darkvalley1.gif");
		code = "DV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 365, 151);
		Clearing c2 = new Clearing(2, 253, 84);
		Clearing c4 = new Clearing(4, 185, 250);
		Clearing c5 = new Clearing(5, 363, 279);
			
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
