package com.magicrealm.server.controller;

import java.util.ArrayList;

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
	
	/**
	 * Moves the Clients Character to an adjacent clearing, updates the playerlist and map of everyone connected to the server
	 */
	public void moveCharacter(){
		
		String          location           = GameController.myself().getCharacter().getLocation();		
		ArrayList<Node> checkClearingsList = GameController.getMap().getClearing(location).getAdjacencyList(false);//.getAdjacentClearings(GameController.getMap(), false);
		Object[]        options            = new Object[checkClearingsList.size()];
		int             i                  = 0;
		
		System.out.println("Starting position of character " + location);
		
		
		for(Node p: checkClearingsList) {
			
			if(p instanceof Clearing) {
				System.out.println("Node is a Clearing ");
				System.out.println("Adjacent Node Clearing" + ((Clearing)p).getCode());
				options[i] = ((Clearing)p).getCode();  				
			} 
			
			else if (p instanceof Edge){
				
				int edgeNum      = ((Edge) p).getEdgeNumber();				
				int xCoord       = GameController.getMap().getTileCoordinateX(location.substring(0, 2));
				int yCoord       = GameController.getMap().getTileCoordinateY(location.substring(0, 2));				
				int ctr          = GameController.getMap().getTile(location.substring(0, 2)).getAngle() / 60;
            	int sideEdgeIsOn = ((edgeNum + ctr) % 6) == 0 ? 6 : ((edgeNum + ctr) % 6);
            	
            	System.out.println("Node is an Edge");
            	System.out.println("Adjacent Node Edge" + ((Edge)p).getEdgeNumber());
            	System.out.println("Current Tiles x and y dual array coordinates " + xCoord + " " + yCoord);
            	System.out.println("Current tiles rotation center " + ctr);
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
            	           	
            	if ((xCoord < 0 || yCoord < 0) || (xCoord > 6 || yCoord >6)){
            		System.out.println("Turn back, You've reached the end of the World");
            		break;
            	}
            	
            	System.out.println("Adjacent tiles  dual array coordinates " + xCoord + " " + yCoord);
            	
            	HexTile adjacentTile = GameController.getMap().getTiles()[xCoord][yCoord];
            	
            	if (adjacentTile == null){
            		System.out.println("No tile that way, turn back!");
            		break;
            	}
            	
            	System.out.println("Tile adjacent to side edge is on (" + sideEdgeIsOn + ") is " + adjacentTile.getCode());
            	
            	int adjCtr     = adjacentTile.getAngle() / 60;
            	int adjEdgeNum = ((((sideEdgeIsOn + 3) % 6) + (6-adjCtr)) % 6) == 0 ? 6 : ((((sideEdgeIsOn + 3) % 6) + (6-adjCtr)) % 6);

            	System.out.println("The adjacent tiles rotation center is " + adjCtr);
            	System.out.println("The adjacent Edge number is " + adjEdgeNum);
            	
            	if (adjEdgeNum == 0){
            		System.out.println("There has been an error in edge calculation");
            	}
            	else{
            		System.out.println("Making adjacency list for adjacent edge");
            		
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
		}
		
		System.out.println("Number of options " + options.length);
		String l = (String) JOptionPane.showInputDialog(null, 
					   					  				"Move to which clearing?", 
					   					  				"Available Clearings", 
					   					  				JOptionPane.QUESTION_MESSAGE,
					   					  				null, 
					   					  				options, 
					   					  				options[0]);
		
		if (l != null){

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
