package com.magicrealm.common.packet;

import com.magicrealm.common.model.hextile.HexTile;

public class MapTilesPacket extends Packet {

	private HexTile[][] tiles;
	
	public MapTilesPacket(HexTile[][] tiles) { this.tiles = tiles; }
	
	public HexTile[][] getTiles() { return tiles; }

}
