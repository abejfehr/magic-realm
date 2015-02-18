package com.magicrealm.client.ui.map.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.magicrealm.client.ui.map.MapFactory;
import com.magicrealm.common.model.Map;

public class MapTest {

	// Create a map for these tests
	Map testMap = MapFactory.createTestMap();

	/*
	 * Describe: The Map's layout
	 */
	
	/*
	 * It shouldn't be null(the tiles should've been initialized somewhere)
	 */
	@Test
	public void testMapLayoutNotNull() {
		assertNotNull(testMap.getTiles());
	}
	
	/*
	 * Describe: Map pathfinding
	 */
	
	/*
	 * It should be able to find connections in one tile
	 */
	@Test
	public void testMapPathExistsInOneTile() {
		boolean result = testMap.isPathBetween("CL6", "CL4");
		assertTrue(result);
	}

	/*
	 * It should also fail if there isn't really a connection(with a non-hidden path)
	 */
	@Test
	public void testMapNoPathInOneTile() {
		boolean result = testMap.isPathBetween("CL1", "CL2");
		assertFalse(result);
	}
}
