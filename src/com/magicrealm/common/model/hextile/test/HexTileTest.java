package com.magicrealm.common.model.hextile.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.magicrealm.common.model.hextile.Cliff;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.map.MapFactory;
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
