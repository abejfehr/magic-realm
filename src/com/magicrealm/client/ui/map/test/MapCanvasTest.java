package com.magicrealm.client.ui.map.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.common.model.hextile.HexTile;

public class MapCanvasTest {

	/*
	 * Verifies that the setter for Hex Tile list works
	 */
	@Test
	public void MapCanvas_setHexTiles_works() {
		MapCanvas canvas = new MapCanvas();
		int someWidth = 5;
		int someHeight = 5;
		HexTile[][] tiles = new HexTile[someWidth][someHeight];
		for(int i=0;i<someHeight;++i) {
			for(int j=0;j<someWidth;++j) {
				tiles[i][j] = new HexTile();
			}
		}
		
		canvas.setMapTiles(tiles);
		
		assertNotNull(canvas.getMapTiles());
	}

}
