package com.magicrealm.common.model.path;

import java.util.ArrayList;

public abstract class PathNode {

	/*
	 * Private members
	 */
	ArrayList<PathNode> adjacentByPath = new ArrayList<PathNode>();
	ArrayList<PathNode> adjacentByHiddenPath = new ArrayList<PathNode>();


	
	/*
	 * Add methods
	 */
	public void addAdjacentByPath(PathNode node) {
		adjacentByPath.add(node);	
	}

	public void addAdjacentByHiddenPath(PathNode node) {
		adjacentByHiddenPath.add(node);
	}
	
	
	
	/*
	 * Gets whether or not the requested clearing number is adjacent to this one
	 */
	public boolean isAdjacentTo(int clearingNo) {
		for(PathNode node : adjacentByPath) {
			if(node instanceof Clearing) {
				if(((Clearing) node).getNumber() == clearingNo) {
					return true;
				}
			}
		}
		
		return false;
	}

}
