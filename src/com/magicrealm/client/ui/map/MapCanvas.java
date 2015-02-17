package com.magicrealm.client.ui.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import com.magicrealm.common.model.hextile.HexTile;

@SuppressWarnings("serial")
public class MapCanvas extends JPanel {
	
	/*
	 * Constants
	 */
	private final int MAX_WIDTH = 6;
	private final int MAX_HEIGHT = 6;
	
	/*
	 * Publicly accessible properties 
	 */
	protected double translateX;
	protected double translateY;
	protected double scale;
	
	/*
	 * Privately accessible properties
	 */
	private HexTile[][] tiles = new HexTile[MAX_WIDTH][MAX_HEIGHT];
  
	/*
	 * Constructors
	 */
	public MapCanvas(Map map) {
		translateX = 0;
		translateY = 0;
		scale = 1;
		setOpaque(true);
		setDoubleBuffered(true);
		this.tiles = map.getTiles();
	}

	@Override
	public void paint(Graphics g) {
 
		AffineTransform tx = new AffineTransform();
		tx.translate(translateX, translateY);
		tx.scale(scale, scale);
		Graphics2D ourGraphics = (Graphics2D) g;
		
		// Paint the background white before each print
		ourGraphics.setColor(Color.WHITE);
		ourGraphics.fillRect(0, 0, getWidth(), getHeight());
		ourGraphics.setTransform(tx);
		ourGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ourGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// Go through the tiles and draw each one that exists
		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				// Check to make sure the tile exists
				if(tiles[i][j] != null) {
					tiles[i][j].paint(ourGraphics,i*497-(497/4)*i,j*431+(431/2)*i);
				}
			}
		}
	}
	
	public void setMapTiles(HexTile[][] tiles) {
		this.tiles = tiles;
	}

	public HexTile[][] getMapTiles() {
		return this.tiles;
	}
}