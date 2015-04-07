package com.magicrealm.common.model.map;

import java.util.ArrayList;

import com.magicrealm.chit.Chit;
import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
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

		Map m = new Map();

		HexTile[][] tiles = new HexTile[6][6];

		tiles[0][2] = new Cliff(4);
		tiles[0][3] = new EvilValley(1);
		
		m.setTiles(tiles);

		return m;
	}
	
	public static Map createIteration1Map() {

		Map m = new Map();

		HexTile[][] tiles = new HexTile[6][6];

		// First column
		tiles[0][2] = new Cliff(4);
		tiles[0][3] = new EvilValley(1);
		tiles[0][4] = new HighPass(1);
		
		// Second column
		tiles[1][2] = new Ledges(3);
		tiles[1][3] = new Borderland(4);
		tiles[1][4] = new Cavern(0);
		
		// Third column
		tiles[2][1] = new Crag(2);
		tiles[2][2] = new OakWoods(3);
		tiles[2][3] = new BadValley(4);
		tiles[2][4] = new Mountain(4);
		
		// Fourth column
		tiles[3][0] = new DarkValley(1);
		tiles[3][1] = new DeepWoods(5);
		tiles[3][2] = new MapleWoods(1);
		tiles[3][3] = new Caves(1);
		tiles[3][4] = new PineWoods(5);
		
		// Fifth column
		tiles[4][0] = new CurstValley(5);
		tiles[4][1] = new NutWoods(2);
		tiles[4][2] = new Ruins(1);
		
		// Sixth column
		tiles[5][1] = new AwfulValley(5);
		tiles[5][2] = new LindenWoods(0);

		ArrayList<Dwellings> dwellings = new ArrayList<Dwellings>();
		
		// Inn
		Dwellings inn = new Dwellings(Dwellings.INN);
		//inn.setLocation("BV5");
		dwellings.add(inn);
		
		// Guard
		Dwellings guardHouse = new Dwellings(Dwellings.GUARD_HOUSE);
		//guardHouse.setLocation("DV5");
		dwellings.add(guardHouse);
		
		// House
		Dwellings house = new Dwellings(Dwellings.HOUSE);
		//house.setLocation("CV5");
		dwellings.add(house);
		
		// Chapel
		Dwellings chapel = new Dwellings(Dwellings.CHAPEL);
		//chapel.setLocation("AV5");
		dwellings.add(chapel);

		ArrayList<Chit> chits   = new ArrayList<Chit>();
		Chit            newChit = null;
		for(int i=0;i<Config.MAX_NUM_CHITS;i++){
			if(i<5){
				newChit =  new Chit("V");
			}
			else if(i<10){
				newChit =  new Chit("C");
			}
			else if(i<15){
				newChit =  new Chit("W");
			}
			else if(i<20){
				newChit =  new Chit("M");
			}			
			chits.add(newChit);
		}
		
		
		m.setTiles(tiles);
		m.setDwellings(dwellings);
		m.setChits(chits);
		
		return m;
	}
	
}
