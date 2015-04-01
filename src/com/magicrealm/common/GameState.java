package com.magicrealm.common;

/**
 * This is basically an enumeration that's meant to store different possible
 * states of the game.
 * 
 * @author Abe Fehr
 */
public class GameState {

	/**
	 * UNINITIALIZED means that there is no game. Either the player has yet to 
	 * join a game or host one of their own.
	 */
	public static final int UNINITIALIZED = 0;
	
	/**
	 * WAITING means that the game is being set up and that characters and
	 * players can join. In the future, map creation or other fun things
	 * could happen here.
	 */
	public static final int WAITING = 1;
	
	/**
	 * STARTED means that the game has officially begun and that it's already
	 * someone's turn. Most of everything should happen while the game is in
	 * this state.
	 */
	public static final int STARTED = 2;

}
