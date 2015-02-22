package com.magicrealm.common.model.hextile;

import java.io.Serializable;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public class OakWoods extends HexTile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6300891646724116979L;



	/*
	 * Constructors
	 */
	public OakWoods() { // Parameter-less constructor for serialization
		
		super();
		
		init();
		
	}
	
	public OakWoods(int angle) {
		
		super(angle, "oakwoods1.gif", "oakwoods-e1.gif");

		init();
		
	}
	
	
	
	/*
	 * Initializes the tile, because the info will be the same no matter which constructor is called
	 */
	private void init() {

		code = "OW";

		// Define the clearings
		Clearing c2 = new Clearing(2, 360, 205);
		Clearing c4 = new Clearing(4, 134, 280);
		Clearing c5 = new Clearing(5, 189, 114);
		
		// Define the edges
		Edge e1 = new Edge(1);
		Edge e2 = new Edge(2);
		Edge e4 = new Edge(4);
		Edge e5 = new Edge(5);
		Edge e6 = new Edge(6);
			
		// Add them to the HexTile
		pathNodes.add(c2);
		pathNodes.add(c4);
		pathNodes.add(c5);
		pathNodes.add(e1);
		pathNodes.add(e2);
		pathNodes.add(e4);
		pathNodes.add(e5);
		pathNodes.add(e6);
		
		// Define their paths

		c2.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(c2);
		
		// Define the edges
		e1.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e1);

		e2.adjacencyListByNormalPath.add(c2);
		c2.adjacencyListByNormalPath.add(e2);

		e4.adjacencyListByNormalPath.add(c4);
		c4.adjacencyListByNormalPath.add(e4);
		
		e5.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e5);

		e6.adjacencyListByNormalPath.add(c5);
		c5.adjacencyListByNormalPath.add(e6);
		
		// Set the tileCode for each
		for(Node n : pathNodes) {
			n.setTileCode(code);
		}

		
		Clearing ec2 = new Clearing(2, 360, 205);
		Clearing ec4 = new Clearing(4, 134, 280);
		Clearing ec5 = new Clearing(5, 189, 114);
		
		// Define the edges
		Edge ee1 = new Edge(1);
		Edge ee2 = new Edge(2);
		Edge ee4 = new Edge(4);
		Edge ee5 = new Edge(5);
		Edge ee6 = new Edge(6);
		
		enchantedPathNodes.add(ec2);
		enchantedPathNodes.add(ec4);
		enchantedPathNodes.add(ec5);
		enchantedPathNodes.add(ee1);
		enchantedPathNodes.add(ee2);
		enchantedPathNodes.add(ee4);
		enchantedPathNodes.add(ee5);
		enchantedPathNodes.add(ee6);
		
		// Define their paths

		ec4.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ec4);
			
		// Define the edges
		ee1.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee1);

		ee2.adjacencyListByNormalPath.add(ec2);
		ec2.adjacencyListByNormalPath.add(ee2);

		ee4.adjacencyListByNormalPath.add(ec4);
		ec4.adjacencyListByNormalPath.add(ee4);
				
		ee5.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee5);

		ee6.adjacencyListByNormalPath.add(ec5);
		ec5.adjacencyListByNormalPath.add(ee6);

				// Set the tileCode for each
		for(Node n : enchantedPathNodes) {
			n.setTileCode(code);
		}

	}
}
