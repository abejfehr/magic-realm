package com.magicrealm.common.model;

import java.util.ArrayList;

import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;

public class Map {
	
	/*
	 * Private members
	 */
	private HexTile[][] tiles;
	private ArrayList<Dwellings> dwellings = new ArrayList<Dwellings>();
		
	/*
	 * Getters and setters
	 */
	public HexTile[][] getTiles() { return tiles; }
	
	public void setTiles(HexTile[][] tiles) { this.tiles = tiles; }

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
		else { return false; }
		
		// There must be no path between the tiles
		return false;
	}
	
	// TODO: implement this method
	public int getPathLength(String origin, String destination) { return 5;  }

	/*
	 * Returns the requested tile(by the tile code)
	 */
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

	public ArrayList<Dwellings> getDwellings() { return dwellings; }
	
	public int getTilePositionX(String code) {
		String tileCode = code.substring(0, 2);

		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(tileCode)) {
						return getTilePositionX(i,j);
					}
				}
			}
		}
		
		// If there was no tile
		return 0;
	}
	
	public int getTilePositionY(String code) {
		String tileCode = code.substring(0, 2);

		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(tileCode)) {
						return getTilePositionY(i,j);
					}
				}
			}
		}
		
		// If there was no tile
		return 0;
	}

	public static int getTilePositionX(int xIndex, int yIndex) { return xIndex*Config.HEX_TILE_IMAGE_WIDTH-(Config.HEX_TILE_IMAGE_WIDTH/4)*xIndex; }
	
	public static int getTilePositionY(int xIndex, int yIndex) { return yIndex*Config.HEX_TILE_IMAGE_HEIGHT+(Config.HEX_TILE_IMAGE_HEIGHT/2)*xIndex; }

	public Clearing getClearing(String code) {
		String tileCode = code.substring(0, 2);
		int clearingNumber = Integer.parseInt(code.substring(2));
		
		HexTile tile = getTile(tileCode);
		
		return tile.getClearing(clearingNumber);
	}

	public void setDwellings(ArrayList<Dwellings> dwellings) { this.dwellings = dwellings; }

	public int getTileAngle(String code) {
		String tileCode = code.substring(0, 2);

		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(tileCode)) {
						return tiles[i][j].getAngle();
					}
				}
			}
		}
		
		// If there was no tile
		return 0;
	}
}
