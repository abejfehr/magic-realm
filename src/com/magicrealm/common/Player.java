package com.magicrealm.common;

import java.util.Random;
import com.magicrealm.common.character.Character;

public class Player {

	/*
	 * Private members
	 */
	private String name;
	private Character character;
	private boolean cheating; // Whether or not they're in cheat mode
	
	private String[] defaultNames = {
			"Ordjen",
			"Saramac",
			"Bertjo",
			"Canwil",
			"Alded",
			"Ar",
			"Royleof",
			"Berlifrith",
			"Brytles",
			"Ceolcrow",
			"Ceoleli",
			"Fridrah",
			"Jenle",
			"Garwyn",
			"Kacrowacar",
			"Ceo",
			"Leofnas",
			"Doded",
			"Kimmax",
			"Irich",
			"Werdfer",
			"Fridjo",
			"Naldsean",
			"Lesferum",
			"Artol",
			"Leofuphia",
			"Cynbet",
			"Dogard",
			"Tonris",
			"Dobardthy",
			"Drytard",
			"Dinoald",
			"Joanste",
			"Ja-red",
			"Eli-anne",
			"Crowchris",
			"Ing-ri",
			"Ri"
			};

	/*
	 * Constructors
	 */
	public Player() {
		
		Random random = new Random();
		this.name = defaultNames[random.nextInt(defaultNames.length)];
		
	}
	
	public Player(String name) { this.name = name; }
	
	
	
	/*
	 * Getters and setters
	 */
	public void setName(String name) { this.name = name; }
	
	public String getName() { return name; }
	
	public void setCharacter(Character character) { this.character = character; }
	
	public Character getCharacter() { return character; }
	
	@Override
	public String toString() {
		return "Player: " + name;
	}
	
	public boolean isCheating() {
		return cheating;
	}
	
	public void toggleCheatMode() {
		cheating = !cheating;
	}
}
