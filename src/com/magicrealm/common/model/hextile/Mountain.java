package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class Mountain extends HexTile implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8240381353369832568L;



	/*
	 * Constructors
	 */
	public Mountain() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public Mountain(int angle) {
		
		super(angle, "mountain1.gif", "mountain-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "MN";

		// Define the clearings
		Clearing c1 = new Clearing(1, 169, 171);
		Clearing c2 = new Clearing(2, 119, 291);
		Clearing c3 = new Clearing(3, 240, 286);
		Clearing c4 = new Clearing(4, 250, 71);
		Clearing c5 = new Clearing(5, 374, 291);
		Clearing c6 = new Clearing(6, 345, 163);
			
		Edge e2 = new Edge(2);
		Edge e4 = new Edge(4);
		Edge e6 = new Edge(6);
		
		// Add them to the HexTile
		pathNodes.add(c1);
		pathNodes.add(c2);
		pathNodes.add(c3);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(c6);
		pathNodes.add(e2);
		pathNodes.add(e4);
		pathNodes.add(e6);
		
		// Define their paths

		c1.adjacencyListByNormalPath.add(c3);
		c3.adjacencyListByNormalPath.add(c1);
		
		c2.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(c2);
		
		c3.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c3);
		
		c4.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(c4);
		
		c4.adjacencyListByHiddenPath.add(c6);
		c6.adjacencyListByHiddenPath.add(c4);
		
		c5.adjacencyListByNormalPath.add(c6);
		c6.adjacencyListByNormalPath.add(c5);
				
		// Define the edges

		e2.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e2);

		e4.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e4);

		e6.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(e6);
		
		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}
		
		// Define the clearings
		Clearing ec1 = new Clearing(1, 169, 171);
		Clearing ec2 = new Clearing(2, 119, 291);
		Clearing ec3 = new Clearing(3, 240, 286);
		Clearing ec4 = new Clearing(4, 250, 71);
		Clearing ec5 = new Clearing(5, 374, 291);
		Clearing ec6 = new Clearing(6, 345, 163);
		
		Edge ee2 = new Edge(2);
		Edge ee4 = new Edge(4);
		Edge ee6 = new Edge(6);
		
		// Add them to the HexTile
		enchantedPathNodes.add(ec1);
		enchantedPathNodes.add(ec2);
		enchantedPathNodes.add(ec3);
		enchantedPathNodes.add(ec4);
		enchantedPathNodes.add(ec5);
		enchantedPathNodes.add(ec6);
		enchantedPathNodes.add(ee2);
		enchantedPathNodes.add(ee4);
		enchantedPathNodes.add(ee6);

		// Define their paths

		ec1.adjacencyListByNormalPath.add(ec3);
		ec3.adjacencyListByNormalPath.add(ec1);
		
		ec1.adjacencyListByHiddenPath.add(ec4);
		ec4.adjacencyListByHiddenPath.add(ec1);
		
		ec2.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec2);
		
		ec3.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec3);
		
		ec4.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ec4);
		
		ec4.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec4);
		
		ec5.adjacencyListByHiddenPath.add(ec6);
		ec6.adjacencyListByHiddenPath.add(ec5);
				
		// Define the edges

		ee2.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee2);

		ee4.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee4);

		ee6.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ee6);
		
		// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}

	}
}
