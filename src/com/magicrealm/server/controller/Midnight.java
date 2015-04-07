package com.magicrealm.server.controller;

import java.util.ArrayList;

import com.magicrealm.common.Config;
import com.magicrealm.common.Player;
import com.magicrealm.common.die.Die;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.PhaseEndPacket;

public class Midnight {

	public static void start() {
		System.out.println("It is now midnight.");	
		ArrayList<Player> players = GameController.getPlayerList();
		for (int i=0; i<players.size();i++){
			ArrayList<Player> compareList = players;
			compareList.remove(players.get(i));
			for (int k=0; k<players.size();k++){
				System.out.println(players.get(k));
				System.out.println(compareList.get(k));
			}
			for (int j=0;j<compareList.size();j++){
				if (players.get(i).getCharacter().getLocation() == compareList.get(j).getCharacter().getLocation()){
					System.out.println("Two Characters are in the same Clearing prepare to Battle");
					resolveCombat(players.get(i), compareList.get(j));
					//for (int k=0; i< Config.MAX_NUM_COMBAT_ROUNDS;k++){
						//DiePacket firstRolls = new DiePacket();
						//NetworkController.sen
					//}
				}
			}
			
		}
		end();
	}
	
	public static void end() {
		System.out.println("Everyone rests until the next day");
		
		
		NetworkController.sendToAllClients(PhaseEndPacket.class);
		//NetworkController.sendToServer(new PhaseEndPacket());
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("PhaseEndPacket sent");
	}
	
	public static void resolveCombat(Player player1, Player player2){
		
		System.out.println(player1.getCharacter().getName() + " and " + player2.getCharacter().getName() + " have entered combat!");
		
		for (int i=0; i<Config.MAX_NUM_COMBAT_ROUNDS; i++){
			Die attackDie = new Die();
			Die defendDie = new Die();
			
			int damage = attackDie.getCurrentNumber() - defendDie.getCurrentNumber();
			System.out.println(player1.getCharacter().getName() + " Attacks with a roll of: " + attackDie.getCurrentNumber());
			System.out.println(player2.getCharacter().getName() + " Defends with a roll of: " + defendDie.getCurrentNumber());
			if (damage <= 0){
				System.out.println(player2.getCharacter().getName() +  " defends no damage done");
			}
			else {
				System.out.println(player2.getCharacter().getName() + " Takes: " + damage + " damage");
				player2.getCharacter().takeDamage(damage);
			}
			
			attackDie.roll();
			defendDie.roll();
			
			damage = attackDie.getCurrentNumber() - defendDie.getCurrentNumber();
			System.out.println(player2.getCharacter().getName() + " Attacks with a roll of: " + attackDie.getCurrentNumber());
			System.out.println(player1.getCharacter().getName() + " Defends with a roll of: " + defendDie.getCurrentNumber());
			if (damage <= 0){
				System.out.println(player1.getCharacter().getName() +  " defends no damage done");
			}
			else {
				System.out.println(player1.getCharacter().getName() + " Takes: " + damage + " damage");
				player2.getCharacter().takeDamage(damage);
			}
			
			
			System.out.println(player1.getCharacter().getName() + " is at " + player1.getCharacter().getHealthPoints());
			System.out.println(player2.getCharacter().getName() + " is at " + player2.getCharacter().getHealthPoints());
			
			if ((player1.getCharacter().getHealthPoints() <= 0) && (player2.getCharacter().getHealthPoints()) <= 0){
				System.out.println("It appears both combatants have perished!");
				break;
			}
			else if (player1.getCharacter().getHealthPoints() <= 0){
				System.out.println("It appears " + player1.getCharacter().getName() + " has been vanquished!");
				break;
			}
			else if (player2.getCharacter().getHealthPoints() <= 0){
				System.out.println("It appears " + player2.getCharacter().getName() + " has been vanquished!");
				break;
			}
			
			
			System.out.println("Round " + i + " of combat is over!");
			
			
		}
		
		
	}

}
