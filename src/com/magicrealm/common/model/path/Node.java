package com.magicrealm.common.model.path;

import java.util.ArrayList;

import com.magicrealm.server.controller.GameController;

public abstract class Node implements Comparable<Node>{

	/*
	 * Private members
	 */
	ArrayList<Integer> adjacentByPath = new ArrayList<Integer>();
	ArrayList<Integer> adjacentByHiddenPath = new ArrayList<Integer>();
	
	
	
	public ArrayList<Path> newAdjacentByPath = new ArrayList<Path>();
	public ArrayList<Path> newAdjacentByHiddenPath = new ArrayList<Path>();

	// Stores the tile code
	protected String tileCode = null;
	
	
	// Weird stuff for the pathfinding
    public double minDistance = Double.POSITIVE_INFINITY;
	public Node previous;

	
	
	/*
	 * Add methods
	 */
	public void addAdjacentByPath(int clearingNumber) {
		adjacentByPath.add(clearingNumber);	
	}

	public void addAdjacentByHiddenPath(int clearingNumber) {
		adjacentByHiddenPath.add(clearingNumber);
	}
	
	
	
	/*
	 * Gets whether or not the requested clearing number is adjacent to this one
	 */
	public boolean isAdjacentTo(int clearingNo) {
		for(int i : adjacentByPath) {
			if(i == clearingNo) {
				return true;
			}
		}
		
		return false;
	}

	public ArrayList<Path> getAdjacencyList(boolean hidden) {
		ArrayList<Path> returnArray = new ArrayList<Path>();
		
		for(Path p : newAdjacentByPath) {
			returnArray.add(p);
		}
		if(hidden) {
			for(Path p : newAdjacentByHiddenPath) {
				returnArray.add(p);
			}			
		}
		
		return returnArray;
	}
	
	public void setTileCode(String tc) { tileCode = tc; }

	
	
    public int compareTo(Node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

	public String getTileCode() { return tileCode; }
	
	public boolean discovered = false;

}
