package com.magicrealm.common.packet;
import com.magicrealm.common.Player;

public class RegisterPlayer extends Packet {
	private Player player;
	private int connectionID;

	public Player getPlayer(){ return player; }
	public void setPlayer(Player player){
		this.player = player;
	}
	public void setConnectionID(int id) {
		this.connectionID = id;
	}
	public int getConnectionID() { return connectionID; }
	

}
