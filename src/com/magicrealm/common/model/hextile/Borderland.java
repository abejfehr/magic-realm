package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Borderland extends HexTile {
	
	public Borderland(int step) {
		super(step, "borderland1.gif");

		code = "BV";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 171, 82);
		Clearing c2 = new Clearing(2, 383, 199);
		Clearing c3 = new Clearing(3, 311, 90);
		Clearing c4 = new Clearing(4, 167, 364);
		Clearing c5 = new Clearing(5, 189, 269);
		Clearing c6 = new Clearing(6, 230, 183);
		
		// Define their paths
		c1.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c1);

		c6.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c6);

		c6.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c6);

		c3.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c3);

		c3.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c3);

		c4.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c4);

		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
