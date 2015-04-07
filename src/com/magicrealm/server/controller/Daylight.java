package com.magicrealm.server.controller;

import com.magicrealm.common.Player;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.PhaseEndPacket;



public class Daylight {
	private static boolean allTurnsDone = false;

	public static void start() {
		System.out.println("Daylight has begun.");
		for (Player p: GameController.getPlayerList()){
			p.getCharacter().resetDaylight();
		}
		
	}
	
	public static void end() {
		System.out.println("The daylight is over");
	}
	
	public static void checkForPhaseFinish(){
		daylightOver();
		for (Player p: GameController.getPlayerList()){
			if (!p.getCharacter().isDaylightOver()){
				daylightNotOver();
				break;
			}
		}
		
		if (allTurnsDone){			
			end();
			NetworkController.sendToAllClients(PhaseEndPacket.class);
			//NetworkController.sendToServer(new PhaseEndPacket());
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
		}
		
	}
	
	public static void daylightNotOver() { allTurnsDone = false; }
	public static void daylightOver()    { allTurnsDone = true; }

}
