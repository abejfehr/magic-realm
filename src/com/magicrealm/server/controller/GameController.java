package com.magicrealm.server.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.model.map.MapFactory;
import com.magicrealm.common.network.Events;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.network.Subscriber;
import com.magicrealm.common.packet.PlayerList;


public class GameController implements Subscriber {

	/*
	 * Private members
	 */
	private static String chatHistory; // For the chat box in the lobby screen
	private static Map map; // The game board
	private static HashMap<Integer, Player> players; // The list of connected players
	private static int ownConnectionID;
	private static int period; // The period of the day
	private static int dayNumber = 1;
	private static int currentPlayerIndex = 0;
	private static ArrayList<Integer> playerTurns = new ArrayList<Integer>();
	private static ActionController actionController = new ActionController(); 	
	public static final int BIRDSONG = 0;
	public static final int DAYLIGHT = 1;
	public static final int SUNSET = 2;
	public static final int MIDNIGHT = 3;
	
	/*
	 * Add a player
	 */
	public static void addPlayer(int connectionID, Player player) {
		players.put(connectionID, player);
	}
	
	public static void initPlayerTurns() {
		playerTurns = new ArrayList<Integer>(players.keySet());
		Collections.shuffle(playerTurns);
	}
	
	public static ArrayList<Player> getPlayerList() {
		return new ArrayList<Player>(players.values());
	}

	public static void joinNewGame() {

		// A bunch of default values until we get the actual info
		chatHistory = "";
		map = null;
		players = new HashMap<Integer, Player>();
		period = BIRDSONG;
		
		// Create an instance of this class to subscribe to events
		GameController gc = new GameController();
		
		// Subscribes to network events
		NetworkController.subscribe(Events.PLAYER_REGISTERED, gc);
		NetworkController.subscribe(Events.CONNECTION_INFO_RECEIVED, gc);
		NetworkController.subscribe(Events.PLAYER_FINISHED_TURN, gc);
		NetworkController.subscribe(Events.PHASE_ENDED, gc);
		
		
		//NetworkController.sendToServer(new PlayerList());
		// initPlayerTurns(); -> the turn order should be received over the network
	}
	
	public static void startNewGame() {
		chatHistory = "";
		map = MapFactory.createIteration1Map();
		//map = MapFactory.createTestMap();
		players = new HashMap<Integer, Player>();
		setPeriod(BIRDSONG);

		// Create an instance of this class to subscribe to events
		GameController gc = new GameController();
		
		// Subscribes to network events
		NetworkController.subscribe(Events.PLAYER_REGISTERED, gc);
		NetworkController.subscribe(Events.GAME_STARTED, gc); // So we can begin the first turn
		NetworkController.subscribe(Events.PLAYER_FINISHED_TURN, gc);
		NetworkController.subscribe(Events.PHASE_ENDED, gc);
		
		initPlayerTurns();
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
		else if(event == Events.PLAYER_FINISHED_TURN) {
			Daylight.checkForPhaseFinish();
			//advancePlayer();
			//if(isMyTurn()) {
				//System.out.println("It must be my turn");
				//startPeriod();
			//}
		}
		else if(event == Events.GAME_STARTED) {
			System.out.println("The game has officially started!");
			//if(isMyTurn()) {
				//System.out.println("It must be my turn");
				startPeriod();
			//}			
		}
		else if (event == Events.PHASE_ENDED){
			advancePeriod();
			System.out.println("Advancing the Phase");			
			startPeriod();
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
		//map.setPlayerList(newPlayers.values());
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
	
	public static int getPeriod() { return period; }

	public static int getDayNumber() { return dayNumber; }
	
	public static ActionController getActionController() { return actionController; }
	
	public static Player getCurrentPlayer() {
		if(playerTurns.size() < 1) {
			playerTurns = new ArrayList<Integer>(players.keySet());
			Collections.shuffle(playerTurns);
		}
		int something = playerTurns.get(currentPlayerIndex);
		return players.get(something);
	}

	public static void setPeriod(int p) {
		period = p;
	}
	
	public static void startPeriod() {
		// I need to somehow notify the screen components that the aspects of the turn have changed
		switch(period) {
			case BIRDSONG:
				Birdsong.start();
				break;
			case DAYLIGHT:
				// Since my daylight period started here, I can enable the action bar now
				Daylight.start();
				break;
			case SUNSET:
				Sunset.start();
				break;
			case MIDNIGHT:
				Midnight.start();
				break;
		}

	}
	
	public static void endPeriod() {
		switch(period) {
		case BIRDSONG:
			Birdsong.end();
			break;
		case DAYLIGHT:
			// The action bar can be disabled now
			Daylight.end();
			break;
		case SUNSET:
			Sunset.end();
			break;
		case MIDNIGHT:
			Midnight.end();
			break;
		}	
	}
	
	public static boolean isMyTurn() {
		return (getCurrentPlayer() == myself());
	}

	public static void advancePlayer() {
		++currentPlayerIndex;
		if(currentPlayerIndex > players.size() - 1) {
			advancePeriod();
			currentPlayerIndex = 0;
		}

		// Notify each player that the turn has changed
	}
	
	public static void advancePeriod() {
		++period;
		if(period > MIDNIGHT) {
			advanceDay();
			period = BIRDSONG;
		}
		
		// Notify each player that the period has changed
	}

	private static void advanceDay() {
		++dayNumber;
		// The character has 4 phases again
		//myself().getCharacter().resetNumberOfPhases();
	}
}
