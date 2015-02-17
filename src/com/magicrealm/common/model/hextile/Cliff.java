package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Cliff extends HexTile {
	
	public Cliff(int angle) {
		super(angle);
		imageFilename = "cliff1.gif";
		code = "CL";
		
		// Define the clearings
		Clearing c1 = new Clearing(1);
		Clearing c2 = new Clearing(2);
		Clearing c3 = new Clearing(3);
		Clearing c4 = new Clearing(4);
		Clearing c5 = new Clearing(5);
		Clearing c6 = new Clearing(6);
			
		// Define their paths
		c1.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c1);

		c6.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c6);

		c2.addAdjacentByPath(c3);
		c3.addAdjacentByPath(c2);

		c3.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c3);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
