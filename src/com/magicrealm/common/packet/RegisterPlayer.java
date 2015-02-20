package com.magicrealm.common.packet;
import com.magicrealm.common.character.Character;

public class RegisterPlayer extends Packet {
	Character player;

	public Character getPlayer(){ return player;}
	public void setPlayer(Character character){
		player = character;
	}
	

}
