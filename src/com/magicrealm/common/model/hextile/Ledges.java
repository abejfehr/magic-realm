package com.magicrealm.common.model.hextile;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class Ledges extends HexTile {
	
	/*
	 * Constructors
	 */
	public Ledges() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Ledges(int angle) {
		
		super(angle, "ledges1.gif", "ledges-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "LE";
		
		/*
		 * Normal side of the tile
		 */
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 270, 311);
		Clearing c2 = new Clearing(2, 360, 155);
		Clearing c3 = new Clearing(3, 376, 274);
		Clearing c4 = new Clearing(4, 250, 211);
		Clearing c5 = new Clearing(5, 156, 124);
		Clearing c6 = new Clearing(6, 171, 351);
		
		// Define the edges
		Edge e1 = new Edge(1);
		Edge e2 = new Edge(2);
		Edge e5 = new Edge(5);
		Edge e6 = new Edge(6);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);
		pathNodes.add(e1);
		pathNodes.add(e2);
		pathNodes.add(e5);
		pathNodes.add(e6);
			
		// Define their paths
		c1.adjacencyListByHiddenPath.add(c3);
		c3.adjacencyListByHiddenPath.add(c1);

		c1.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c1);

		c1.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c1);

		c4.adjacencyListByHiddenPath.add(c6);
		c6.adjacencyListByHiddenPath.add(c4);
		
		c2.adjacencyListByHiddenPath.add(c5);
		c5.adjacencyListByHiddenPath.add(c2);

		// Define the edges
		e1.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e1);

		e2.adjacencyListByNormalPath.add(c3);
		c3.adjacencyListByNormalPath.add(e2);

		e5.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e5);

		e6.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(e6);

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		
		/*
		 * Enchanted side of the tile
		 */
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 270, 311);
		Clearing ec2 = new Clearing(2, 360, 155);
		Clearing ec3 = new Clearing(3, 376, 274);
		Clearing ec4 = new Clearing(4, 250, 211);
		Clearing ec5 = new Clearing(5, 156, 124);
		Clearing ec6 = new Clearing(6, 171, 351);
			
		// Define the edges
		Edge ee1 = new Edge(1);
		Edge ee2 = new Edge(2);
		Edge ee5 = new Edge(5);
		Edge ee6 = new Edge(6);
		
		// Add them to the HexTile
		enchantedPathNodes.add(ec1);
		enchantedPathNodes.add(ec2);
		enchantedPathNodes.add(ec3);
		enchantedPathNodes.add(ec4);
		enchantedPathNodes.add(ec5);
		enchantedPathNodes.add(ec6);
		enchantedPathNodes.add(ee1);
		enchantedPathNodes.add(ee2);
		enchantedPathNodes.add(ee5);
		enchantedPathNodes.add(ee6);

		// Define their paths
		ec1.adjacencyListByHiddenPath.add(ec3);
		ec3.adjacencyListByHiddenPath.add(ec1);

		ec1.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ec1);

		ec1.adjacencyListByNormalPath.add(ec6);
		ec6.adjacencyListByNormalPath.add(ec1);

		ec4.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec4);
		
		ec2.adjacencyListByHiddenPath.add(ec5);
		ec5.adjacencyListByHiddenPath.add(ec2);

		// Define the edges
		ee1.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee1);

		ee2.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ee2);

		ee5.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee5);

		ee6.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ee6);

		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}

	}
}
