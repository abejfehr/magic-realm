package com.magicrealm.common.model.path;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Node implements Serializable {

	private static final long serialVersionUID = 3303820687554897134L;
	/*
	 * Private/public members
	 */
	public ArrayList<Node> adjacencyListByNormalPath = new ArrayList<Node>();
	public ArrayList<Node> adjacencyListByHiddenPath = new ArrayList<Node>();

	// Stores the tile code
	protected String tileCode = null;
	
	public boolean discovered = false;
	
	// For pathfinding
	public Node previous;

	public ArrayList<Node> getAdjacencyList(boolean hidden) {
		ArrayList<Node> returnArray = new ArrayList<Node>();
		
		for(Node n : adjacencyListByNormalPath) {
			returnArray.add(n);
		}
		if(hidden) {
			for(Node n : adjacencyListByHiddenPath) {
				returnArray.add(n);
			}			
		}
		
		return returnArray;
	}
	
	public void setTileCode(String tc) { tileCode = tc; }
	
	public String getTileCode() { return tileCode; }

}
