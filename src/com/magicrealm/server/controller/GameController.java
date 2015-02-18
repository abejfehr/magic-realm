package com.magicrealm.server.controller;

import java.util.HashMap;

import com.esotericsoftware.kryonet.Connection;
import com.magicrealm.client.ui.map.MapFactory;
import com.magicrealm.common.model.Map;

public class GameController {

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
	}

	public static Map getMap() { return map; }
}
