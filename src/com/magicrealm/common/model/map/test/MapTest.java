package com.magicrealm.common.model.map.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.map.MapFactory;

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
		ArrayList<String> result = testMap.getPathBetween("CL6", "CL4", false);
		assertNotNull(result);
	}

	/*
	 * It should also fail if there isn't really a connection(with a non-hidden path)
	 */
	@Test
	public void testMapNoPathInOneTile() {
		ArrayList<String> result = testMap.getPathBetween("CL1", "CL2", false);
		assertNull(result);
	}
	
	/*
	 * It should be able to find connections between more than one tile
	 */
	@Test 
	public void testMapPathBetweenTwoTiles() {
		ArrayList<String> result = testMap.getPathBetween("CL1", "EV5", false);
		assertNotNull(result);		
	}
}
