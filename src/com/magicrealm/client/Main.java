package com.magicrealm.client;

import javax.swing.JFrame;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapScroller;
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

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(500, 500);
		
		HexTile[][] mapTiles = new HexTile[6][6];
		mapTiles[0][2] = new Cliff();
		mapTiles[0][3] = new EvilValley();
		mapTiles[0][4] = new HighPass();
		mapTiles[1][2] = new Ledges();
		mapTiles[1][3] = new Borderland();
		mapTiles[1][4] = new Cavern();
		mapTiles[2][1] = new Crag();
		mapTiles[2][2] = new OakWoods();
		mapTiles[2][3] = new BadValley();
		mapTiles[2][4] = new Mountain();
		mapTiles[3][0] = new DarkValley();
		mapTiles[3][1] = new DeepWoods();
		mapTiles[3][2] = new MapleWoods();
		mapTiles[3][2] = new Caves();
		mapTiles[3][3] = new PineWoods();
		mapTiles[4][0] = new CurstValley();
		mapTiles[4][1] = new NutWoods();
		mapTiles[4][2] = new Ruins();
		mapTiles[5][1] = new AwfulValley();
		mapTiles[5][2] = new LindenWoods();
		MapCanvas canvas = new MapCanvas(mapTiles);
		MapScroller mapScroller = new MapScroller(canvas);
		window.getContentPane().add(mapScroller);
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
