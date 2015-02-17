package com.magicrealm.client.ui.map;

import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;

public class Map {
	
	HexTile[][] tiles;
		
	public HexTile[][] getTiles() {
		return tiles;
	}
	
	protected void setTiles(HexTile[][] tiles) {
		this.tiles = tiles;
	}

	public boolean isPathBetween(String origin, String destination) {
		String oTileCode = origin.substring(0, 2);
		String dTileCode = destination.substring(0, 2);
		
		int oClearingNumber = Integer.parseInt(origin.substring(2));
		int dClearingNumber = Integer.parseInt(destination.substring(2));
		
		// If the destination and origin tile are the same
		if(dTileCode.equals(oTileCode)) {
			// Loop through the tile numbers in the origin and see if there's a path between the numbers
			HexTile originTile = getTile(oTileCode);
			Clearing originClearing = originTile.getClearing(oClearingNumber);
			if(originClearing.isAdjacentTo(dClearingNumber)) {
				return true;
			}
		}
		else {
			return false;
		}
		
		// There must be no path between the tiles
		return false;
	}
	
	public int getPathLength(String origin, String destination) {
		return 5;
		// TODO: implement this method
	}

	private HexTile getTile(String code) {
		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(code)) {
						return tiles[i][j];
					}
				}
			}
		}
		
		// If there was no tile
		return null;
	}
}
