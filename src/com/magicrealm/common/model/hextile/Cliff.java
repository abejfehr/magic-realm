package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;
import com.magicrealm.common.model.path.Path;

public class Cliff extends HexTile implements Serializable {

	private static final long serialVersionUID = 1642350934228052597L;



	/*
	 * Constructors
	 */
	public Cliff() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Cliff(int angle) {
		
		super(angle, "cliff1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		code = "CL";
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 134, 151);
		Clearing c2 = new Clearing(2, 138, 283);
		Clearing c3 = new Clearing(3, 246, 218);
		Clearing c4 = new Clearing(4, 363, 149);
		Clearing c5 = new Clearing(5, 368, 285);
		Clearing c6 = new Clearing(6, 250, 88);
		Edge e1 = new Edge(1);
		Edge e2 = new Edge(2);
		Edge e4 = new Edge(4);
		Edge e5 = new Edge(5);
			
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);
		pathNodes.add(e1);
		pathNodes.add(e2);
		pathNodes.add(e4);
		pathNodes.add(e5);

		// Connect the clearings
		c1.newAdjacentByPath.add(new Path(1, c6));
		c6.newAdjacentByPath.add(new Path(1, c1));
		
		c6.newAdjacentByPath.add(new Path(1, c4));
		c4.newAdjacentByPath.add(new Path(1, c6));

		c6.newAdjacentByHiddenPath.add(new Path(1, c3));
		c3.newAdjacentByHiddenPath.add(new Path(1, c6));

		c3.newAdjacentByPath.add(new Path(1, c2));
		c2.newAdjacentByPath.add(new Path(1, c3));

		c3.newAdjacentByPath.add(new Path(1, c5));
		c5.newAdjacentByPath.add(new Path(1, c3));
		
		// Connect the edges
		e1.newAdjacentByPath.add(new Path(0.5, c4));
		c4.newAdjacentByPath.add(new Path(0.5, e1));

		e2.newAdjacentByPath.add(new Path(0.5, c5));
		c5.newAdjacentByPath.add(new Path(0.5, e2));

		e4.newAdjacentByPath.add(new Path(0.5, c2));
		c2.newAdjacentByPath.add(new Path(0.5, e4));

		e5.newAdjacentByPath.add(new Path(0.5, c1));
		c1.newAdjacentByPath.add(new Path(0.5, e5));

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}
	}

}
