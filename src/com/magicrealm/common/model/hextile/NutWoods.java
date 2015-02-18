package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class NutWoods extends HexTile {

	public NutWoods(int step) {
		super(step, "nutwoods1.gif");
		
		code = "NW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 185, 106);
		Clearing c4 = new Clearing(4, 352, 137);
		Clearing c5 = new Clearing(5, 247, 282);
			
		// Define their paths
		c2.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);

	}
}
