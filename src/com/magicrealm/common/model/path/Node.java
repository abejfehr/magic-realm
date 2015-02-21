package com.magicrealm.common.model.path;

import java.util.ArrayList;

import com.magicrealm.server.controller.GameController;

public abstract class Node {

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
