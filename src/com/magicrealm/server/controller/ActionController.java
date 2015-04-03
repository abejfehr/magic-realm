package com.magicrealm.server.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Edge;
import com.magicrealm.common.model.path.Node;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.MapPacket;
import com.magicrealm.common.packet.PlayerList;

public class ActionController {
	
	public ActionController(){}
	
	public void moveCharacter(){
		
		String location = GameController.myself().getCharacter().getLocation();
		System.out.println("Starting position of character " + location);
		ArrayList<Clearing> checkClearingsList = GameController.getMap().getClearing(location).getAdjacentClearings(GameController.getMap(), false);
		Object[] options = new Object[checkClearingsList.size()];
		
		for (int i = 0; i<checkClearingsList.size();i++){
			if(checkClearingsList.get(i) !=null){
				options[i] = checkClearingsList.get(i).getCode();
				System.out.println("Possible Moves " + checkClearingsList.get(i).getCode());
			}
		}
		/*for(Node p: checkClearingsList) {
			
			if(p instanceof Clearing) {
				System.out.println("Node is a Clearing");
				options[i] = ((Clearing)p).getCode();  				
			} 
			
			else if (p instanceof Edge){
				System.out.println("Node is an Edge");
				int edgeNum = ((Edge) p).getEdgeNumber();
				System.out.println("Edge Number " + edgeNum);
				//Note we need tile x,y in array, and angle
				int xCoord = GameController.getMap().getTileCoordinateX(location.substring(0, 2));
				int yCoord = GameController.getMap().getTileCoordinateX(location.substring(0, 2));
				System.out.println("Current Tiles x and y dual array coordinates " + xCoord + " " + yCoord);
				//HashMap<HexTile,Integer> neighbouringTiles = GameController.getMap().getNeighbourTiles(location);
				int ctr  = GameController.getMap().getTile(location.substring(0, 2)).getAngle() / 60;
				System.out.println("Current tiles rotation center " + ctr);
            	int sideEdgeIsOn = ((edgeNum + ctr) % 6) == 0 ? 6 : ((edgeNum + ctr) % 6);
            	System.out.println("Edge " + edgeNum + " is currently on side " + sideEdgeIsOn);
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
            	System.out.println("Adjacent tiles  dual array coordinates " + xCoord + " " + yCoord);
            	HexTile adjacentTile = GameController.getMap().getTiles()[xCoord][yCoord];
            	System.out.println("Tile adjacent to side edge is on (" + sideEdgeIsOn + ") is " + adjacentTile.getCode());
            	int adjEdgeNum = 0;
            	int adjCtr  = adjacentTile.getAngle() / 60;
            	System.out.println("The adjacent tiles rotation center is " + adjCtr);
            	//THIS MATH IS NOT RIGHT*****************************
            	//adjEdgeNum = ((((sideEdgeIsOn + 3) % 6) - adjCtr) % 6);// == 0 ? 6 : ((((sideEdgeIsOn + 3) % 6) - adjCtr) % 6);
            	/*switch(adjCtr) {
    				case 1:
    					adjEdgeNum = ((4 + adjCtr) % 6) == 0 ? 6 : ((4 + adjCtr) % 6);
    					break;
    				case 2:
    					adjEdgeNum = ((5 + adjCtr) % 6) == 0 ? 6 : ((5 + adjCtr) % 6);
    					break;
    				case 3:
    					adjEdgeNum = ((6 + adjCtr) % 6) == 0 ? 6 : ((6 + adjCtr) % 6);
    					break;
    				case 4: 
    					adjEdgeNum = ((1 + adjCtr) % 6) == 0 ? 6 : ((1 + adjCtr) % 6);
    					break;
    				case 5:
    					adjEdgeNum = ((2 + adjCtr) % 6) == 0 ? 6 : ((2 + adjCtr) % 6);
    					break;
    				case 6: 
    					adjEdgeNum = ((3 + adjCtr) % 6) == 0 ? 6 : ((3 + adjCtr) % 6);
    					break;
            	}
            	//****************************************
            	System.out.println("The adjacent Edge number is " + adjEdgeNum);
            	if (adjEdgeNum == 0){
            		System.out.println("There has been an error in edge calculation");
            	}
            	else{
            		//adjEdgeNum = 6; //pure testing purposes
            		System.out.println("Makeing adjacency list for adjacent edge");
            		ArrayList<Node> adjClearingsList = adjacentTile.getEdge(adjEdgeNum).getAdjacencyList(false);
            		System.out.println("Looping over adjacenylist");
            		for(Node c: adjClearingsList) {
            			System.out.println(c.toString());
            			if(c instanceof Clearing) {
            				System.out.println("adding " + ((Clearing)c).getCode() + " to list of of possible moves");
            				options[i] = ((Clearing)c).getCode();             				
            			}
            		}	
            	}           	
			}
			i++;
		}*/
		System.out.println("options length " + options.length);
		String l = (String) JOptionPane.showInputDialog(null, 
					   					  				"Move to which clearing?", 
					   					  				"Available Clearings", 
					   					  				JOptionPane.QUESTION_MESSAGE,
					   					  				null, 
					   					  				options, 
					   					  				options[0]);
		if (l != null){
			GameController.getMap().getNeighbourTiles(location.substring(0, 2));
			System.out.println(l);
			PlayerList newPlayerList = new PlayerList();
			
			//Updates players location then sends a new playerlist to the server
			GameController.myself().getCharacter().setLocation(l);
			newPlayerList.setPlayers(GameController.getPlayerHashMap());
			NetworkController.sendToServer(newPlayerList);

			//Updates the gamecontrollers map, then sends the new map to the server
			GameController.getMap().setPlayerList(GameController.getPlayerList());
			MapPacket newMap = new MapPacket(GameController.getMap());
		    System.out.println("sending to server request map packet");
			NetworkController.sendToServer(newMap);
			
			System.out.println(GameController.myself().getCharacter() + " moved to " + l);
			System.out.println(GameController.myself().getCharacter().getLocation());
		}
		else {
			System.out.println("Character Move Cancelled");
		}
		
		System.out.println("Character now at " + GameController.myself().getCharacter().getLocation());
	}
	public void search(){}

	public void hideCharacter(){
		
		// Confirm that character is now hiding
		System.out.println(GameController.myself().getCharacter() + " is now hiding.");
		
		// Change character image
		
	}

}
