package com.magicrealm.server.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.Node;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.network.Subscriber;
import com.magicrealm.common.packet.MapPacket;
import com.magicrealm.common.packet.PlayerList;
import com.magicrealm.common.packet.RequestMapPacket;

public class ActionController {
	
	public ActionController(){}
	
	public void moveCharacter(){
		
		String location = GameController.myself().getCharacter().getLocation();
		ArrayList<Node> checkClearingsList = GameController.getMap().getClearing(location).getAdjacencyList(false);
		Object[] options = new Object[checkClearingsList.size()];
		int i = 0;
		
		for(Node p: checkClearingsList) {
			if(p instanceof Clearing) {
				options[i] = ((Clearing)p).getCode();  
				i++;
			}
		}
		
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
		
		
	}
	public void search(){}


}
