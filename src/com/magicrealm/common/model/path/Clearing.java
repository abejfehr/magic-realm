package com.magicrealm.common.model.path;

public class Clearing extends PathNode {

	/*
	 * Private members
	 */
	// Stores the clearing number
	private int number = -1;
	
	// Stores the clearing's X and Y position relative to the top-left corner of the tile
	private int x = 0, y = 0;
	
	

	/*
	 * Constructors
	 */
	public Clearing(int i, int x, int y) {
		number = i;
		this.x = x;
		this.y = y;
	}

	
	
	/*
	 * Getters and setters
	 */
	public int getNumber() { return number; }
	
	public int getOffsetX() { return x; }
	
	public int getOffsetY() { return y; }
}
