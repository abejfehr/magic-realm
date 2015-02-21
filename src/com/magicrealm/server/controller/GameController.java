package com.magicrealm.server.controller;

import java.util.HashMap;

import com.esotericsoftware.kryonet.Connection;
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
	private static String name; // The name of the game
	private static String chatHistory; // For the chat box in the lobby screen
	private static Map map; // The game board
	private static HashMap<Connection, Character> players; // The list of connected players
	
	/*
	 * Add a player
	 */
	public static void addPlayer(Connection connection, Character character) {
		players.put(connection, character);
	}

	public static void startNewGame() {
		name = "GameName1";
		chatHistory = "";
		map = MapFactory.createIteration1Map();
		players = new HashMap<Connection, Character>();
		
		// Create an instance of this class to subscribe to events
		GameController gc = new GameController();
		
		// Subscribes to network events
		NetworkController.subscribe(Events.PLAYER_REGISTERED, gc);
	}

	public static Map getMap() { return map; }
	public static Character getPlayer(Connection connection){
		return players.get(connection);
	}

	public static void setMap(Map newMap) {
		map = newMap;
	}

	@Override
	public void eventFired(int event) {
		if(event == Events.PLAYER_REGISTERED) {
			map.setCharacterList(players.values());
		}
	}
	
}
