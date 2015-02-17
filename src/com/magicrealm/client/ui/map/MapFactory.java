package com.magicrealm.client.ui.map;

import com.magicrealm.common.model.hextile.AwfulValley;
import com.magicrealm.common.model.hextile.BadValley;
import com.magicrealm.common.model.hextile.Borderland;
import com.magicrealm.common.model.hextile.Cavern;
import com.magicrealm.common.model.hextile.Caves;
import com.magicrealm.common.model.hextile.Cliff;
import com.magicrealm.common.model.hextile.Crag;
import com.magicrealm.common.model.hextile.CurstValley;
import com.magicrealm.common.model.hextile.DarkValley;
import com.magicrealm.common.model.hextile.DeepWoods;
import com.magicrealm.common.model.hextile.EvilValley;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.hextile.HighPass;
import com.magicrealm.common.model.hextile.Ledges;
import com.magicrealm.common.model.hextile.LindenWoods;
import com.magicrealm.common.model.hextile.MapleWoods;
import com.magicrealm.common.model.hextile.Mountain;
import com.magicrealm.common.model.hextile.NutWoods;
import com.magicrealm.common.model.hextile.OakWoods;
import com.magicrealm.common.model.hextile.PineWoods;
import com.magicrealm.common.model.hextile.Ruins;

public abstract class MapFactory {

	public static Map createTestMap() {
		// The hextiles for the map
		HexTile[][] tiles = new HexTile[6][6];
		tiles[0][2] = new Cliff(4);
		tiles[0][3] = new EvilValley(1);
		
		Map m = new Map();
		m.setTiles(tiles);

		return m;
	}
	
	public static Map createIteration1Map() {
		
		// Lay out the tiles
		HexTile[][] tiles = new HexTile[6][6];
		tiles[0][2] = new Cliff(4);
		tiles[0][3] = new EvilValley(1);
		tiles[0][4] = new HighPass(1);
		tiles[1][2] = new Ledges(3);
		tiles[1][3] = new Borderland(4);
		tiles[1][4] = new Cavern(0);
		tiles[2][1] = new Crag(2);
		tiles[2][2] = new OakWoods(3);
		tiles[2][3] = new BadValley(4);
		tiles[2][4] = new Mountain(4);
		tiles[3][0] = new DarkValley(1);
		tiles[3][1] = new DeepWoods(5);
		tiles[3][2] = new MapleWoods(1);
		tiles[3][2] = new Caves(1);
		tiles[3][3] = new PineWoods(5);
		tiles[4][0] = new CurstValley(5);
		tiles[4][1] = new NutWoods(2);
		tiles[4][2] = new Ruins(1);
		tiles[5][1] = new AwfulValley(5);
		tiles[5][2] = new LindenWoods(0);

		Map m = new Map();
		m.setTiles(tiles);
		
		return m;
	}
	
}
