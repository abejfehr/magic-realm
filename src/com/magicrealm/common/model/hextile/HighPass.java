package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class HighPass extends HexTile {
	
	public HighPass(int step) {
		
		super(step, "highpass1.gif");
		
		code = "HP";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 341, 251);
		Clearing c2 = new Clearing(2, 248, 87);
		Clearing c3 = new Clearing(3, 357, 152);
		Clearing c4 = new Clearing(4, 219, 236);
		Clearing c5 = new Clearing(5, 249, 349);
		Clearing c6 = new Clearing(6, 133, 148);
			
		// Define their paths
		c1.addAdjacentByPath(c4);
		c4.addAdjacentByPath(c1);

		c1.addAdjacentByPath(c5);
		c5.addAdjacentByPath(c1);

		c4.addAdjacentByPath(c2);
		c2.addAdjacentByPath(c4);

		c3.addAdjacentByPath(c6);
		c6.addAdjacentByPath(c3);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);

	}
}
