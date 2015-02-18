package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;

public class Crag extends HexTile {
	
	public Crag(int step) {
		super(step, "crag1.gif");
		code = "CR";

		// Define the clearings
		Clearing c1 = new Clearing(1, 133, 155);
		Clearing c2 = new Clearing(2, 136, 285);
		Clearing c3 = new Clearing(3, 245, 219);
		Clearing c4 = new Clearing(4, 363, 149);
		Clearing c5 = new Clearing(5, 368, 285);
		Clearing c6 = new Clearing(6, 250, 88);
			
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
