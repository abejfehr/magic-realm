package com.magicrealm.common.model.path;

public class Path {

	public Path() {
		
	}
	
	public Path(double weight, Node node) {
		this.target = node;
		this.weight = weight;
	}
	
	public Node target;
	public double weight;

}
