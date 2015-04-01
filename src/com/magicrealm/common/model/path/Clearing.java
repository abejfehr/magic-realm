package com.magicrealm.common.model.path;

import java.io.Serializable;
import java.util.ArrayList;

import com.magicrealm.common.model.map.Map;

public class Clearing extends Node implements Serializable {

	private static final long serialVersionUID = -1948441044656692582L;

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
	public Clearing() { // This is required for serialization
		number = 0;
		x = 0;
		y = 0;
	}
	
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
	
	public String getCode() { return tileCode + number; }
	
}
