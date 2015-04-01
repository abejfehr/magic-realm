package com.magicrealm.server.controller;

import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.TurnFinishedPacket;

public class Birdsong {

	public static void start() {
		System.out.println("The birds are singing");
		end();
	}
	
	public static void end() {		
		System.out.println("The birds have stopped singing");
		// Notify everyone that my turn is up
		NetworkController.sendToAllClients(TurnFinishedPacket.class);
	}
	
}