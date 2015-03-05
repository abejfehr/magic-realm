package com.magicrealm.common.packet;

import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;

public class RegisterCharacter extends Packet {
	private Player player;
	private Character character;
	
	public void setPlayer(Player p) { player = p; }
	public void setCharacter(Character c) { character = c; }
	public Character getCharacter() { return character; }
	public Player getPlayer() { return player; }
}
