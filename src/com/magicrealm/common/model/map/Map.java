package com.magicrealm.common.model.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;
import com.magicrealm.server.controller.GameController;

public class Map {
	
	/*
	 * Private members
	 */
	private HexTile[][] tiles;
	private ArrayList<Dwellings> dwellings = new ArrayList<Dwellings>();
	private ArrayList<Character> characters = new ArrayList<Character>();
		
	/*
	 * Getters and setters
	 */
	public HexTile[][] getTiles() { return tiles; }
	
	public void setTiles(HexTile[][] tiles) { this.tiles = tiles; }

	
	
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
	
	public int getTileCoordinateX(String code) {
		String tileCode = code.substring(0, 2);

		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(tileCode)) {
						return i;
					}
				}
			}
		}
		
		// If there was no tile
		return 0;
	}
	
	public int getTileCoordinateY(String code) {
		String tileCode = code.substring(0, 2);

		for(int i=0;i<tiles.length;++i) {
			for(int j=0;j<tiles[i].length;++j) {
				if(tiles[i][j]!=null){
					if(tiles[i][j].getCode().equals(tileCode)) {
						return j;
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
	
	
	
	/*
	 * Uses breadth first search to calculate the shortest *allowable* path between two points on the map
	 */
	public List<Node> getPathBetween(String origin, String destination, boolean hidden) {
		
		Node source = GameController.getMap().getClearing(origin);
		Node target = GameController.getMap().getClearing(destination);
		
        ArrayBlockingQueue<Node> nodeQueue = new ArrayBlockingQueue<Node>(5);
        nodeQueue.add(source);
        source.discovered = true;
        
        while(!nodeQueue.isEmpty()) {
        	Node v = nodeQueue.poll();
        	
        	for(Node e: v.getAdjacencyList(hidden)) {
        		if(!e.discovered) {
        			Node w = e;
                    if(w instanceof Edge) {
                    	int xCoord = GameController.getMap().getTileCoordinateX(w.getTileCode());
                    	int yCoord = GameController.getMap().getTileCoordinateY(w.getTileCode());
               			int ctr  = GameController.getMap().getTile(w.getTileCode()).getAngle() / 60;
                    	int sideEdgeIsOn = ((((((Edge) w).getEdgeNumber()) + ctr) % 6) == 0 ? 6 : ((((Edge) w).getEdgeNumber()) + ctr) % 6);
                    	int complementarySide = ((sideEdgeIsOn + 3) % 6 == 0 ? 6 : (sideEdgeIsOn + 3) % 6);
                    	switch(sideEdgeIsOn) {
                    		case 1:
                    			xCoord = xCoord + 1;
                    			yCoord = yCoord - 1;
                    			break;
                    		case 2:
                    			xCoord = xCoord + 1;
                    			break;
                    		case 3:
                    			yCoord = yCoord + 1;
                    			break;
                    		case 4: 
                    			yCoord = yCoord + 1;
                    			xCoord = xCoord - 1;
                    			break;
                    		case 5:
                    			xCoord = xCoord - 1;
                    			break;
                    		case 6: 
                    			yCoord = yCoord - 1;
                    			break;
                    	}
                    	if(xCoord < 0 || yCoord < 0) {
                    		// The tile must have been on the edge of the map, the connecting tile doesn't exist
                    		break;
                    	}
                    	else {
	            			HexTile tile = GameController.getMap().getTile(xCoord, yCoord);
	            			if(tile != null) {
		                    	//currentTile = tile.getCode();
	                   			int vctr  = GameController.getMap().getTile(tile.getCode()).getAngle() / 60;
	                        	complementarySide = (((complementarySide + 6 - vctr) % 6) == 0 ? 6 : (complementarySide + 6 - vctr) % 6);
	            				if(!tile.getEdge(complementarySide).getConnectedClearing().discovered)
	            					w = tile.getEdge(complementarySide).getConnectedClearing();
	            			}
                    	}
                    }
                    
        			nodeQueue.add(w);
        			w.discovered = true;
        			w.previous = v;
        		}
        	}
        }
        
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.previous)
            path.add(node);

        Collections.reverse(path);
        if(path.size() > 1) {
        	return path;
        }
        else {
        	return null;
        }
        
	}

	private HexTile getTile(int i, int j) { return tiles[i][j]; }

	public ArrayList<Character>  getCharacterList() { return characters; }

	public void setCharacterList(Collection<Character> values) {
		
		characters = new ArrayList<Character>(values);
		
	}
}
