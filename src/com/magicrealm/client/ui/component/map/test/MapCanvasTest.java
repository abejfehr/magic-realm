package com.magicrealm.client.ui.component.map.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.magicrealm.client.ui.component.map.MapCanvas;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.map.MapFactory;

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
