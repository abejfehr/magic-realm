package com.magicrealm.common.model.path;

import java.io.Serializable;

public class Edge extends Node implements Serializable {
	
	private static final long serialVersionUID = 5521563298361690292L;
	
	int number = -1;
	
	public Edge(int number) {
		this.number = number;
	}
	
	public Edge() {
		
	}
	
	public int getEdgeNumber() { return number; }

	/*
	 * Returns the single clearing that is connected to the edge.
	 * 
	 * It's only ever possible for one to be connected, and it can never be hidden, so I've just returned it like this.
	 */
	public Clearing getConnectedClearing() { return (Clearing) adjacencyListByNormalPath.get(0); }
}
