package com.magicrealm.common.model.path;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.magicrealm.common.model.map.Map;

public class Clearing extends Node implements Serializable {

	private static final long serialVersionUID = -1948441044656692582L;

	/*
	 * Private members
	 */
	// Stores the clearing number
	private int number = -1;
		
	// Stores the clearing's X and Y position relative to the top-left corner of the tile
	private int x = 0, y = 0;
	
	

	/*
	 * Constructors
	 */
	public Clearing() { // This is required for serialization
		number = 0;
		x = 0;
		y = 0;
	}
	
	public Clearing(int i, int x, int y) {
		number = i;
		this.x = x;
		this.y = y;
	}
    

    /*
     * Getting the adjacent clearings
     */
    public ArrayList<Clearing> getAdjacentClearings(Map m, boolean hidden) {
            ArrayList<Clearing> results = new ArrayList<Clearing>();
           
            // Go through the map's hextiles and print out each clearing that has a
            // path length of 1
            for(int i=0;i<m.getTiles().length;++i) {
                    for(int j=0;j<m.getTiles()[i].length;++j) {
                    	if(m.getTiles()[i][j] != null){
                            for(int k=0;k<m.getTiles()[i][j].getClearings().size();++k) {
                            	if(m.getTiles()[i][j].getClearings().get(k) instanceof Edge){
                            		break;
                            	}	
                                Clearing otherClearing = (Clearing) m.getTiles()[i][j].getClearings().get(k);
                                //System.out.println(" Other Clearings code " + otherClearing.getCode());
                                System.out.println(" Clearings code " + this.getCode());
                                List<Node> pathBetween = m.getPathBetween(this.getCode(), otherClearing.getCode(), hidden);
                                if(pathBetween != null){
                                	if(pathBetween.size() == 2) {
                                        results.add(otherClearing);
                                	}
                                }
                            }
                    	}    
                    }
            }
            return results;
    }
	
	
	/*
	 * Getters and setters
	 */
	public int getNumber() { return number; }
	
	public int getOffsetX() { return x; }
	
	public int getOffsetY() { return y; }
	
	public String getCode() { return tileCode + number; }

}
