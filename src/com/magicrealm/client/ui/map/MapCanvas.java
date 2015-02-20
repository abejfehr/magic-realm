package com.magicrealm.client.ui.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import com.magicrealm.common.Dwellings;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.map.Map;

@SuppressWarnings("serial")
public class MapCanvas extends JPanel {
	
	/*
	 * Publicly accessible properties 
	 */
	protected double translateX;
	protected double translateY;
	protected double scale;
	
	/*
	 * Privately accessible properties
	 */
	private Map map;
	
	/*
	 * Constructors
	 */
	public MapCanvas(Map map) {
		translateX = 0;
		translateY = 0;
		scale = 1;
		setOpaque(true);
		setDoubleBuffered(true);
		this.map = map;
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

		/*
		 * Paint the tiles
		 */
		HexTile[][] tiles = map.getTiles();
		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				// Check to make sure the tile exists
				if(tiles[i][j] != null) {
					tiles[i][j].paint(ourGraphics, Map.getTilePositionX(i, j), Map.getTilePositionY(i, j) );
				}
			}
		}
		
		
		/*
		 * Paint the dwellings
		 */
		for(Dwellings dwelling : map.getDwellings()) {
			// Get the location of the tile that it's on
						
			dwelling.paint(ourGraphics,
					map.getTilePositionX(dwelling.getLocation()), 
					map.getTilePositionY(dwelling.getLocation()),
					map.getClearing(dwelling.getLocation()).getOffsetX(),
					map.getClearing(dwelling.getLocation()).getOffsetY(),
					map.getTileAngle(dwelling.getLocation()));
		}
	}
	
	public void setMapTiles(HexTile[][] tiles) {
		map.setTiles(tiles);
	}

	public HexTile[][] getMapTiles() {
		return map.getTiles();
	}
}