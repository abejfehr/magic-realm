package com.magicrealm.common.model.map.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

import com.magicrealm.common.model.map.Map;
import com.magicrealm.server.controller.GameController;

public class MapTest {

	/*
	 * Describe: The Map's layout
	 */
	
	/*
	 * It shouldn't be null(the tiles should've been initialized somewhere)
	 */
	@Test
	public void testMapLayoutNotNull() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
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
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		ArrayList<String> result = testMap.getPathBetween("CL6", "CL4", false);
		assertNotNull(result);
	}

	/*
	 * It should also fail if there isn't really a connection(with a non-hidden path)
	 */
	@Test
	public void testMapNoPathInOneTile() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		ArrayList<String> result = testMap.getPathBetween("CL1", "CL2", false);
		assertNull(result);
	}
	
	/*
	 * It should be able to find connections between more than one tile
	 */
	@Test 
	public void testMapPathBetweenTwoTiles() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		ArrayList<String> result = testMap.getPathBetween("CL1", "EV5", false);
		assertNotNull(result);		
	}
}
