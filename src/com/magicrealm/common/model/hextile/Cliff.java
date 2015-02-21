package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

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
		
		super(angle, "cliff1.gif", "cliff-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		code = "CL";
		

		/*
		 * Normal side of the tile
		 */
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 134, 151);
		Clearing c2 = new Clearing(2, 138, 283);
		Clearing c3 = new Clearing(3, 246, 218);
		Clearing c4 = new Clearing(4, 363, 149);
		Clearing c5 = new Clearing(5, 368, 285);
		Clearing c6 = new Clearing(6, 250, 88);
		
		// Define the edges
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
			
		// Define their paths
		c1.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c1);

		c6.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c6);

		c2.adjacencyListByNormalPath.add(c3);
		c3.adjacencyListByNormalPath.add(c2);

		c3.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c3);
		
		c3.adjacencyListByHiddenPath.add(c6);
		c6.adjacencyListByHiddenPath.add(c3);

		c5.adjacencyListByHiddenPath.add(c2);
		c2.adjacencyListByHiddenPath.add(c5);

		// Define the edges
		e1.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(e1);

		e2.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e2);

		e4.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e4);

		e5.adjacencyListByNormalPath.add(c1);
		c1.adjacencyListByNormalPath.add(e5);

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		
		/*
		 * Enchanted side of the tile
		 */
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 134, 151);
		Clearing ec2 = new Clearing(2, 138, 283);
		Clearing ec3 = new Clearing(3, 246, 218);
		Clearing ec4 = new Clearing(4, 363, 149);
		Clearing ec5 = new Clearing(5, 368, 285);
		Clearing ec6 = new Clearing(6, 250, 88);
			
		// Define the edges
		Edge ee1 = new Edge(1);
		Edge ee2 = new Edge(2);
		Edge ee4 = new Edge(4);
		Edge ee5 = new Edge(5);
		
		// Add them to the HexTile
		enchantedPathNodes.add(ec1);
		enchantedPathNodes.add(ec2);
		enchantedPathNodes.add(ec3);
		enchantedPathNodes.add(ec4);
		enchantedPathNodes.add(ec5);
		enchantedPathNodes.add(ec6);
		enchantedPathNodes.add(ee1);
		enchantedPathNodes.add(ee2);
		enchantedPathNodes.add(ee4);
		enchantedPathNodes.add(ee5);

		// Define their paths
		ec1.adjacencyListByNormalPath.add(ec6);
		ec6.adjacencyListByNormalPath.add(ec1);

		ec6.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ec6);

		ec2.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec2);

		ec3.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec3);
		
		ec3.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec3);

		ec5.adjacencyListByHiddenPath.add(ec2);
		ec2.adjacencyListByHiddenPath.add(ec5);
		
		// Define the edges
		ee1.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ee1);

		ee2.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee2);

		ee4.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee4);

		ee5.adjacencyListByNormalPath.add(ec1);
		ec1.adjacencyListByNormalPath.add(ee5);

		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}
		
	}
}
