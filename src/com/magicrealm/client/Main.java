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
		/* This is to test the map */
		HexTile[][] mapTiles = new HexTile[6][6];
		mapTiles[0][2] = new Cliff(4);
		mapTiles[0][3] = new EvilValley(1);
		mapTiles[0][4] = new HighPass(1);
		mapTiles[1][2] = new Ledges(3);
		mapTiles[1][3] = new Borderland(4);
		mapTiles[1][4] = new Cavern(0);
		mapTiles[2][1] = new Crag(2);
		mapTiles[2][2] = new OakWoods(3);
		mapTiles[2][3] = new BadValley(4);
		mapTiles[2][4] = new Mountain(4);
		mapTiles[3][0] = new DarkValley(1);
		mapTiles[3][1] = new DeepWoods(5);
		mapTiles[3][2] = new MapleWoods(1);
		mapTiles[3][2] = new Caves(1);
		mapTiles[3][3] = new PineWoods(5);
		mapTiles[4][0] = new CurstValley(5);
		mapTiles[4][1] = new NutWoods(2);
		mapTiles[4][2] = new Ruins(1);
		mapTiles[5][1] = new AwfulValley(5);
		mapTiles[5][2] = new LindenWoods(0);
		MapCanvas canvas = new MapCanvas(mapTiles);
		MapScroller mapScroller = new MapScroller(canvas);
		window.getContentPane().add(mapScroller);

		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
