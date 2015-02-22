package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class Caves extends HexTile implements Serializable {
	
	private static final long serialVersionUID = 2048773765402207097L;



	/*
	 * Constructors
	 */
	public Caves() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Caves(int angle) {
		
		super(angle, "caves1.gif", "caves-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "CA";
		
		/*
		 * Normal side of the tile
		 */
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 356, 284);
		Clearing c2 = new Clearing(2, 133, 282);
		Clearing c3 = new Clearing(3, 227, 215);
		Clearing c4 = new Clearing(4, 276, 345);
		Clearing c5 = new Clearing(5, 136, 150);
		Clearing c6 = new Clearing(6, 314, 86);
		
		// Define the edges
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
		pathNodes.add(e2);
		pathNodes.add(e4);
		pathNodes.add(e5);
			
		// Define their paths
		c1.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c1);

		c6.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c6);

		c4.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(c4);

		c2.adjacencyListByHiddenPath.add(c3);
		c3.adjacencyListByHiddenPath.add(c2);

		c3.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c3);

		// Define the edges
		e2.adjacencyListByNormalPath.add(c1);
		c1.adjacencyListByNormalPath.add(e2);

		e4.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e4);

		e5.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e5);

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		
		/*
		 * Enchanted side of the tile
		 */
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 356, 277);
		Clearing ec2 = new Clearing(2, 128, 276);
		Clearing ec3 = new Clearing(3, 263, 185);
		Clearing ec4 = new Clearing(4, 250, 333);
		Clearing ec5 = new Clearing(5, 130, 146);
		Clearing ec6 = new Clearing(6, 330, 75);
			
		// Define the edges
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
		enchantedPathNodes.add(ee2);
		enchantedPathNodes.add(ee4);
		enchantedPathNodes.add(ee5);

		// Define their paths
		ec1.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ec1);

		ec1.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec1);

		ec4.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec4);

		ec6.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec6);

		ec3.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ec3);

		// Define the edges
		ee2.adjacencyListByNormalPath.add(ec1);
		ec1.adjacencyListByNormalPath.add(ee2);

		ee4.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee4);

		ee5.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee5);

		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}
		
	}
}
