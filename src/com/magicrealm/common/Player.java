package com.magicrealm.common;

import java.util.Random;

public class Player {

	/*
	 * Private members
	 */
	private String name;
	private Character character;
	
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
}
