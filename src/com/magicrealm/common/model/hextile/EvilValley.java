package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class EvilValley extends HexTile {
	
	public EvilValley(int step) {
		super(step, "evilvalley1.gif");
		
		code = "EV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 133, 285);
		Clearing c2 = new Clearing(2, 132, 150);
		Clearing c4 = new Clearing(4, 312, 101);
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
