package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class Crag extends HexTile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -703194757093571841L;



	/*
	 * Constructors
	 */
	public Crag() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Crag(int angle) {
		
		super(angle, "crag1.gif", "crag-e01.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {
		code = "CR";

		
		/*
		 * Normal side of the tile
		 */
		
		// Define the clearings
		Clearing c1 = new Clearing(1, 231, 361);
		Clearing c2 = new Clearing(2, 248, 86);
		Clearing c3 = new Clearing(3, 172, 174);
		Clearing c4 = new Clearing(4, 320, 287);
		Clearing c5 = new Clearing(5, 323, 177);
		Clearing c6 = new Clearing(6, 160, 280);
		
		// Define the edges
		Edge e6 = new Edge(6);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);
		pathNodes.add(e6);
			
		// Define their paths
		c1.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c1);

		c1.adjacencyListByHiddenPath.add(c6);
		c6.adjacencyListByHiddenPath.add(c1);

		c4.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c4);

		c6.adjacencyListByNormalPath.add(c3);
		c3.adjacencyListByNormalPath.add(c6);

		c3.adjacencyListByHiddenPath.add(c2);
		c2.adjacencyListByHiddenPath.add(c3);

		c3.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c3);

		// Define the edges
		e6.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e6);

		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		
		/*
		 * Enchanted side of the tile
		 */
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 204, 355);
		Clearing ec2 = new Clearing(2, 270, 89);
		Clearing ec3 = new Clearing(3, 174, 145);
		Clearing ec4 = new Clearing(4, 283, 278);
		Clearing ec5 = new Clearing(5, 313, 183);
		Clearing ec6 = new Clearing(6, 161, 266);
			
		// Define the edges
		Edge ee6 = new Edge(6);
		
		// Add them to the HexTile
		enchantedPathNodes.add(ec1);
		enchantedPathNodes.add(ec2);
		enchantedPathNodes.add(ec3);
		enchantedPathNodes.add(ec4);
		enchantedPathNodes.add(ec5);
		enchantedPathNodes.add(ec6);
		enchantedPathNodes.add(ee6);

		// Define their paths
		ec1.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ec1);

		ec4.adjacencyListByNormalPath.add(ec6);
		ec6.adjacencyListByNormalPath.add(ec4);

		ec4.adjacencyListByHiddenPath.add(ec5);
		ec5.adjacencyListByHiddenPath.add(ec4);

		ec5.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec5);

		ec5.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ec5);

		ec6.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec6);

		ec3.adjacencyListByHiddenPath.add(ec2);
		ec2.adjacencyListByHiddenPath.add(ec3);

		// Define the edges
		ee6.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee6);

		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}

	}
}
