package com.magicrealm.client.ui.component.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Node;

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
		ourGraphics.setColor(Color.LIGHT_GRAY);
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
		
		/*
		 * Paint the characters
		 */
		for (Player p : map.getPlayerList()) {
			
			Character c = p.getCharacter();
			
			// Some players may not have a character set for some reason. If that's the case, just ignore those players
			if(c == null)
				break;
			
			//int index = map.getDwellings().indexOf(c.getStartingPoint());
			int x, y;
			//String characterLocation = map.getDwellings().get(index).getLocation();
			int j = 0;
			for(int i=0;i<map.getDwellings().size();++i) {
				if(map.getDwellings().get(i).getDwellingType() == c.getStartingPoint().getDwellingType()) {
					j = i;
				}
			}
			String characterLocation = c.getLocation(); //map.getDwellings().get(j).getLocation();
			x = map.getTilePositionX(characterLocation);
			y = map.getTilePositionY(characterLocation);
			
			c.paint(ourGraphics, x, y, 
					map.getClearing(characterLocation).getOffsetX(), 
					map.getClearing(characterLocation).getOffsetY(),
					map.getTileAngle(characterLocation));
			
		}
		
		ScreenController.paint(ourGraphics, Config.MISC_IMAGE_LOCATION + "clouds.png", -1000, -1000, 5000, 5000,
				getCloudOpacityFromScale((float) scale, 1.0f, 0.3f, 0.6f, 0.5f));
	}
	
	public void setMapTiles(HexTile[][] tiles) {
		map.setTiles(tiles);
	}

	public HexTile[][] getMapTiles() {
		return map.getTiles();
	}
	public Map getMap() { return map; }
	
	private float getCloudOpacityFromScale(float scale, float minOpacity, float maxOpacity, float minZoom, float maxZoom) {
		float endDifference = 1.0f; // In case there's a mistake, I don't want the clouds to cover everything
		
		float opacityDifference = maxOpacity - minOpacity;
		float zoomDifference = maxZoom - minZoom;

		if(scale <= maxZoom) {
		  endDifference = maxOpacity;
		}
		else if(scale >= minZoom) {
		  endDifference = minOpacity;
		}
		else {
		  endDifference = 1.0f - (float) (minOpacity - (opacityDifference * ((scale - maxZoom) / zoomDifference))) + 0.3f;
		}
		
		return 1.0f - endDifference;
	}
	
}