package com.magicrealm.server.controller;

import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.PhaseEndPacket;

public class Sunset {

	public static void start() {
		System.out.println("The sun is setting.");
		end();
		
	}

	public static void end() {
		System.out.println("The night is nigh.");
		
		NetworkController.sendToAllClients(PhaseEndPacket.class);
		//NetworkController.sendToServer(new PhaseEndPacket());
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("PhaseEndPacket sent");
	}
}
