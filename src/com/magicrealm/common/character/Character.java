package com.magicrealm.common.character;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.VictoryCondition;
import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.weapon.*;

public abstract class Character {
	/*
	 * Parameters
	 */
	protected Weapon weapon;
	//Armour
	//Combat chits
	//List of active chits
	//Active belongings
	//inactive belongings
	//Friendly
	//Unfriendly
	//Ally
	//Enemy
	protected BufferedImage characterChit = null;
	protected String name;
	public    Vulnerability vulnerability;
    protected int treasureCount, gold, notorietyCount, fameCount, spellCount;
	protected VictoryCondition victoryCondition;
	protected Dwellings startingPoint;
    
    /*
     * Constructors
     */
    public Character(int vulnerability, String name){
    	this.vulnerability  = new Vulnerability(vulnerability);
    	this.startingPoint  = new Dwellings(Dwellings.NOT_SET);
    	this.name           = name;
    	this.gold           = 10;
    	this.treasureCount  = 0;
    	this.notorietyCount = 0;
    	this.fameCount      = 0;
    	this.spellCount     = 0;
    	
    }
    
    /*
     * Default Starting Position for Most Characters, at the INN
     */
    public void setStartingPoint(){
    	startingPoint.dwelling = Dwellings.INN;
    }
    /*
     * Optional Cheat set startingPoint for potential to set start any of the dwellings
     */
    public void setStartingPoint(int startingDwelling){
    	startingPoint.dwelling = startingDwelling;   	
    }
    
    protected void setVictoryCondition(int treasure,int fame, int notoriety,int gold,int spell){
    	victoryCondition = new VictoryCondition(treasure, fame, notoriety, gold, spell);   	
    }
    
    public void setImage(String characterChitImg){
		try {
			characterChit = ImageIO.read(Main.class.getResource(Config.CHARACTER_CHIT_IMAGE_LOCATION + characterChitImg));
		} catch (IOException e) {}		
	}
            
}
