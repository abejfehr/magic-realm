package com.magicrealm.common.model.path;

import java.util.ArrayList;

public abstract class PathNode {

	/*
	 * Private members
	 */
	ArrayList<Integer> adjacentByPath = new ArrayList<Integer>();
	ArrayList<Integer> adjacentByHiddenPath = new ArrayList<Integer>();


	
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

}
