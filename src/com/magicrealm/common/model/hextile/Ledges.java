package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Ledges extends HexTile {
	
	public Ledges(int step) {
		super(step, "ledges1.gif");

		code = "LE";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 270, 311);
		Clearing c2 = new Clearing(2, 360, 155);
		Clearing c3 = new Clearing(3, 376, 274);
		Clearing c4 = new Clearing(4, 250, 211);
		Clearing c5 = new Clearing(5, 156, 124);
		Clearing c6 = new Clearing(6, 171, 351);
			
		// Define their paths
		c3.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c3);

		c6.addAdjacentByPath(c1);
		c1.addAdjacentByPath(c6);

		c1.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c1);

		c2.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c2);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
