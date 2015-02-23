package com.magicrealm.common.packet;

import java.util.HashMap;

import com.magicrealm.common.Player;

public class PlayerList extends Packet {
	
	private HashMap<Integer,Player> players;

	public void setPlayers(HashMap<Integer,Player> players) { this.players = players; }
	
	public HashMap<Integer, Player> getPlayers() { return players; }
	
}
