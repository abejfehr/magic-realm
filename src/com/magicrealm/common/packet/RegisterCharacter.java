package com.magicrealm.common.packet;

import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;

public class RegisterCharacter extends Packet {
	//private Player player;
	private Character character;
	private int connectionID;
	
	public void setCharacter(Character c) { character = c; }
	public void setConnectionID(int i) { connectionID = i; }
	public Character getCharacter() { return character; }
	public int getConnectionID() { return connectionID; }
}
