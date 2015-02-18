package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class MapleWoods extends HexTile {
	
	public MapleWoods(int step) {
		super(step, "maplewoods1.gif");
		code = "MW";
		
		// Define the clearings
		Clearing c2 = new Clearing(2, 317, 117);
		Clearing c4 = new Clearing(4, 371, 274);
		Clearing c5 = new Clearing(5, 143, 216);
			
		// Define their paths
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
