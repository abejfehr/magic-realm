package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class DeepWoods extends HexTile {

	public DeepWoods(int step) {
		super(step, "deepwoods1.gif");
		code = "DW";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 163, 109);
		Clearing c2 = new Clearing(2, 382, 221);
		Clearing c3 = new Clearing(3, 300, 347);
		Clearing c4 = new Clearing(4, 87, 220);
		Clearing c5 = new Clearing(5, 147, 324);
		Clearing c6 = new Clearing(6, 239, 242);
			
		// Define their paths
		c1.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c1);

		c6.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c6);

		c4.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c4);

		c3.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c3);

		c2.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c2);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
