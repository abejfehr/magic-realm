package com.magicrealm.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.map.MapFactory;
import com.magicrealm.common.network.Events;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.network.Subscriber;


public class GameController implements Subscriber {

	/*
	 * Private members
	 */
	private static String name; // The name of the game(not yet used)
	private static String chatHistory; // For the chat box in the lobby screen
	private static Map map; // The game board
	private static HashMap<Integer, Player> players; // The list of connected players
	private static int ownConnectionID;
	
	/*
	 * Add a player
	 */
	public static void addPlayer(int connectionID, Player player) {
		players.put(connectionID, player);
	}
	
	public static ArrayList<Player> getPlayerList() {
		return new ArrayList<Player>(players.values());
	}

	public static void joinNewGame() {

		// A bunch of default values until we get the actual info
		name = "";
		chatHistory = "";
		map = null;
		players = new HashMap<Integer, Player>();
		
		// Create an instance of this class to subscribe to events
		GameController gc = new GameController();
		
		// Subscribes to network events
		NetworkController.subscribe(Events.PLAYER_REGISTERED, gc);
		NetworkController.subscribe(Events.CONNECTION_INFO_RECEIVED, gc);

	}
	
	public static void startNewGame() {
		name = "GameName1";
		chatHistory = "";
		map = MapFactory.createIteration1Map();
		//map = MapFactory.createTestMap();
		players = new HashMap<Integer, Player>();
		
		// Create an instance of this class to subscribe to events
		GameController gc = new GameController();
		
		// Subscribes to network events
		NetworkController.subscribe(Events.PLAYER_REGISTERED, gc);
	}

	public static Map getMap() { return map; }
	
	public static Player getPlayer(int i){
		return players.get(i);
	}

	public static void setMap(Map newMap) {
		map = newMap;
	}

	@Override
	public void eventFired(int event) {
		if(event == Events.PLAYER_REGISTERED) {
			if(map != null) {
				map.setPlayerList(players.values());
			}
		}
	}
	
	public static String getChatHistory() {
		return chatHistory;
	}
	
	public static void updateChatHistory(Player player, String message) {
		chatHistory += player.getName() + ": " + message + "\n";
	}
	
	public static Player myself() {
		return players.get(ownConnectionID);
	}
	
	public static void setOwnConnectionID(int i) { ownConnectionID = i; }

	public static void setNewPlayerList(HashMap<Integer, Player> newPlayers) {
		players = newPlayers;
	}
	
	public static HashMap<Integer, Player> getPlayerHashMap() {
		return players;
	}

	public static void setCharacter(int connectionID, Character character) {
		// Loop through the list of players and see if we can find the player, and add their character
	    Player p = players.get(connectionID);
	    p.setCharacter(character);
	    players.put(connectionID, p);
	}
	
	public static int getConnectionID() {
		return ownConnectionID;
	}
}
