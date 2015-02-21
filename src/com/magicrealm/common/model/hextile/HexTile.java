package com.magicrealm.common.model.hextile;

import java.awt.Graphics;
import java.util.ArrayList;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;

public abstract class HexTile {

	/*
	 * Private/protected members
	 */
	private int angle = 0;
	protected String imageFilename = "caves1.gif";
	protected String code = null;
	protected boolean enchanted = false;
	protected ArrayList<Node> pathNodes = new ArrayList<Node>();
	protected ArrayList<Node> enchantedPathNodes = new ArrayList<Node>();

	
	
	/*
	 * Constructors
	 */
	public HexTile(int rotationStep, String filename) {

		imageFilename = filename;
		angle = rotationStep * 60;

	}
	
	public HexTile() { // For the serialization
		imageFilename = "cavern1.gif";
		angle = 0;
	}

	/*
	 * Paints the contents of the tile to the graphics object passed in
	 */
	public void paint(Graphics g, int x, int y) {

		// Draw a single tile
		ScreenController.paint(g, Config.TILE_IMAGE_LOCATION + imageFilename, x, y, angle);
		
	}

	
	
	/*
	 * Getters and setters
	 */
	public void setAngle(int angle) { this.angle = angle; }
	
	public boolean isEnchanted() { return enchanted; }
	
	public void enchant() { enchanted = true; }

	public String getCode() { return code; }

	public Clearing getClearing(int oClearingNumber) {
		for(Node p: (enchanted ? enchantedPathNodes : pathNodes)) {
			if(p instanceof Clearing) {
				if(((Clearing)p).getNumber() == oClearingNumber) {
					return ((Clearing) p);
				}
			}
		}
		return null;
	}

	public ArrayList<Node> getClearings() { return (enchanted ? enchantedPathNodes : pathNodes); }

	public int getAngle() { return angle; }

	public Edge getEdge(int edgeNumber) {
		
		for(Node node : pathNodes) {
			if(node instanceof Edge) {
				if(((Edge)node).getEdgeNumber() == edgeNumber) {
					return (Edge)node;
				}
			}
		}
		
		return null;
	}
}