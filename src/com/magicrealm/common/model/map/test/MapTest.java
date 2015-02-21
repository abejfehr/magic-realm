package com.magicrealm.common.model.map.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.path.Node;
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
	 * Describe Map tile retrieval
	 */
	
	/*
	 * It should allow you to get a map tile's X values based on the tile code
	 */
	@Test
	public void testMapGetTileXFromCode() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		int x = testMap.getTileCoordinateX("CL");
		assertEquals(x, 0);
	}

	/*
	 * It should allow you to get a map tile's Y values based on the tile code
	 */
	@Test
	public void testMapGetTileYFromCode() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		int y = testMap.getTileCoordinateY("CL");
		assertEquals(y, 2);
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
		List<Node> result = testMap.getPathBetween("CL1", "CL4", false);
		assertEquals(result.size(), 3);
	}

	/*
	 * It doesn't show hidden paths in one tile unless you ask for it
	 */
	@Test
	public void testMapHiddenPathInaccessibleInOneTile() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		List<Node> result = testMap.getPathBetween("CL1", "CL3", false);
		assertNull(result);
	}

	/*
	 * It should be able to find hidden paths in one tile
	 */
	@Test
	public void testMapHiddenPathExistsInOneTile() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		List<Node> result = testMap.getPathBetween("CL1", "CL3", true);
		assertNotNull(result);
	}

	/*
	 * It should also fail if there isn't really a connection(with a non-hidden path)
	 */
	@Test
	public void testMapNoPathInOneTile() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		List<Node> result = testMap.getPathBetween("CL1", "CL2", false);
		assertNull(result);
	}
	
	/*
	 * It should be able to find connections between more than one tile
	 */
	@Test 
	public void testMapPathBetweenTwoTiles() {
		GameController.startNewGame();
		Map testMap = GameController.getMap();
		List<Node> result = testMap.getPathBetween("CL1", "EV5", false);
		System.out.println(result);
		assertNotNull(result);
	}
}
