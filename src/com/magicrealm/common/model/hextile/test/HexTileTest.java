package com.magicrealm.common.model.hextile.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.magicrealm.common.model.hextile.Cliff;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;

public class HexTileTest {
	
	/*
	 * Describe: A default HexTile
	 */
	
	/*
	 * It: Contains clearings or other path nodes
	 */
	@Test
	public void TestHexTileContainsClearings() {
		HexTile test = new Cliff(0);
		assertNotNull(test.getClearings());
	}
	
	/*
	 * It: Can return individual clearings
	 */
	@Test
	public void TestHexTileReturnsAdjacentClearings() {
		HexTile test = new Cliff(0);
		int someClearingNumber = 1;
		Clearing requestedClearing = test.getClearing(someClearingNumber);
		System.out.println(requestedClearing);
		assertEquals(requestedClearing.getNumber(), someClearingNumber);
	}
}
