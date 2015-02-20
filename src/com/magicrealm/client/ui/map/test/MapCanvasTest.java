package com.magicrealm.client.ui.map.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapFactory;
import com.magicrealm.common.model.map.Map;

public class MapCanvasTest {

	/*
	 * Describe: A MapCanvas
	 */
	
	/*
	 * It: Contains tiles after being instantiated
	 */
	@Test
	public void MapCanvas_setHexTiles_works() {
		Map map = MapFactory.createTestMap();
		MapCanvas canvas = new MapCanvas(map);		
		assertNotNull(canvas.getMapTiles());
	}

}
