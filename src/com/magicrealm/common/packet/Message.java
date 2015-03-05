package com.magicrealm.common.packet;

import com.magicrealm.common.Player;

public class Message extends Packet {
	
	private String message;
	private Player player;

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
	public Player getPlayer() {
		return player;
	}
	
}
