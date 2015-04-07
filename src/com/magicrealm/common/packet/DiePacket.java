package com.magicrealm.common.packet;

import com.magicrealm.common.die.Die;

public class DiePacket extends Packet{
	
	public Die attackDie;
	public Die defendDie;
	
	DiePacket(){
		attackDie = new Die();
		defendDie = new Die();
	}

}
