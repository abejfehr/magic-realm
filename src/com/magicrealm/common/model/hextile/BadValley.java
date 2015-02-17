package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class BadValley extends HexTile {
	
	public BadValley(int step) {
		super(step, "badvalley1.gif");

		code = "BV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 364, 281);
		Clearing c2 = new Clearing(2, 135, 281);
		Clearing c4 = new Clearing(4, 181, 104);
		Clearing c5 = new Clearing(5, 364, 150);
			
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
