package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class Borderland extends HexTile implements Serializable {

	private static final long serialVersionUID = 224814892256690661L;



	/*
	 * Constructors
	 */
	public Borderland() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Borderland(int angle) {
		
		super(angle, "borderland1.gif", "borderland-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "BV";
		
		/*
		 * Normal side of the tile
		 */
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 171, 82);
		Clearing c2 = new Clearing(2, 383, 199);
		Clearing c3 = new Clearing(3, 311, 90);
		Clearing c4 = new Clearing(4, 167, 364);
		Clearing c5 = new Clearing(5, 189, 269);
		Clearing c6 = new Clearing(6, 230, 183);
		
		// Define the edges
		Edge e1 = new Edge(1);
		Edge e2 = new Edge(2);
		Edge e3 = new Edge(3);
		Edge e4 = new Edge(4);
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
		pathNodes.add(e3);
		pathNodes.add(e4);
		pathNodes.add(e5);
		pathNodes.add(e6);
			
		// Define their paths
		c1.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c1);

		c6.adjacencyListByNormalPath.add(c3);
		c3.adjacencyListByNormalPath.add(c6);

		c6.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c6);

		c3.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(c3);

		c3.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c3);

		c4.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c4);

		// Define the edges
		e1.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e1);

		e2.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(e2);

		e3.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e3);

		e4.adjacencyListByNormalPath.add(c1);
		c1.adjacencyListByNormalPath.add(e4);

		e5.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e5);

		e6.adjacencyListByNormalPath.add(c1);
		c1.adjacencyListByNormalPath.add(e6);

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		
		/*
		 * Enchanted side of the tile
		 */
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 201, 70);
		Clearing ec2 = new Clearing(2, 411, 211);
		Clearing ec3 = new Clearing(3, 318, 197);
		Clearing ec4 = new Clearing(4, 235, 323);
		Clearing ec5 = new Clearing(5, 148, 262);
		Clearing ec6 = new Clearing(6, 202, 188);
			
		// Define the edges
		Edge ee1 = new Edge(1);
		Edge ee2 = new Edge(2);
		Edge ee3 = new Edge(3);
		Edge ee4 = new Edge(4);
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
		enchantedPathNodes.add(ee3);
		enchantedPathNodes.add(ee4);
		enchantedPathNodes.add(ee5);
		enchantedPathNodes.add(ee6);

		// Define their paths
		ec1.adjacencyListByNormalPath.add(ec6);
		ec6.adjacencyListByNormalPath.add(ec1);

		ec6.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec6);

		ec6.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ec6);

		ec3.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ec3);

		ec3.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec3);

		ec4.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec4);

		// Define the edges
		ee1.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee1);

		ee2.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ee2);

		ee3.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee3);

		ee4.adjacencyListByNormalPath.add(ec1);
		ec1.adjacencyListByNormalPath.add(ee4);

		ee5.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee5);

		ee6.adjacencyListByNormalPath.add(ec1);
		ec1.adjacencyListByNormalPath.add(ee6);

		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}

	}
}
