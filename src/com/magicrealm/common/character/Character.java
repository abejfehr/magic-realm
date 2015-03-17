package com.magicrealm.common.character;

/*
 * Character
 * -Base class of all character "classes"
 * 
 * Functions
 * ----------
 * -setStartingPoint()
 * -setStartingPoint(int)
 * -getStartingPoint() returns starting point dwelling
 * -setVictoryCondition(int,int,int,int,int) sets characters victory condition
 * -paint(Graphics, x-cord, y-cord, offset-X, offset-Y, angle of tile) function used in display character chits
 */

import java.awt.Graphics;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.VictoryCondition;
import com.magicrealm.common.Vulnerability;
import com.magicrealm.common.model.hextile.HexTile;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.weapon.Weapon;

public abstract class Character {
	
	/*
	 * Parameters
	 */
	
	public    Vulnerability    vulnerability;
	protected Weapon           weapon;
	protected String           imageFilename;
	protected String           name;	
    protected int treasurePoints, goldPoints, notorietyPoints, famePoints, spellPoints;
	protected VictoryCondition victoryCondition;
	protected Dwellings        startingPoint;
	protected String           location;
	protected HexTile          currentHexTile;
	//Armour
	//Combat chits
	//List of active chits
	//Active belongings
	//inactive belongings
	//Friendly
	//Unfriendly
	//Ally
	//Enemy
    
    /*
     * Constructors
     */
	
    public Character(int vulnerability, String name, String imgFilename){
    	
    	this.vulnerability   = new Vulnerability(vulnerability);
    	this.startingPoint   = new Dwellings(Dwellings.NOT_SET);
    	this.name            = name;
    	this.imageFilename   = imgFilename;
    	this.goldPoints      = 10;
    	this.treasurePoints  = 0;
    	this.notorietyPoints = 0;
    	this.famePoints      = 0;
    	this.spellPoints     = 0;
    	this.location        = startingPoint.getLocation();
    	
    }
    
    //No-args constructor for serialization
    
    public Character(){ 
    	
    	this.vulnerability   = new Vulnerability(1);
    	this.startingPoint   = new Dwellings(Dwellings.NOT_SET);
    	this.name            = "new character";
    	this.goldPoints      = 10;
    	this.treasurePoints  = 0;
    	this.notorietyPoints = 0;
    	this.famePoints      = 0;
    	this.spellPoints     = 0;
    	this.location        = startingPoint.getLocation();
    	
    }
    
    /*
     *paint function used to display character chit 
     */
    
    public void paint(Graphics g, int x, int y, int oX, int oY, int angle) {
    	
    	double rotation = Math.toRadians(angle);
		
		// Get the center of the icon TODO: fix this, this is a terrible approximate of the icon size
		double characterCenterX = 100 / 2;
		double characterCenterY = 100 / 2;
				
		int centerX = Config.HEX_TILE_IMAGE_WIDTH / 2;
		int centerY = Config.HEX_TILE_IMAGE_HEIGHT / 2;

		double newX = x + centerX + (oX-centerX)*Math.cos(rotation) - (oY-centerY)*Math.sin(rotation);
		double newY = y + centerY + (oX-centerX)*Math.sin(rotation) + (oY-centerY)*Math.cos(rotation);

		// Draw a single tile
		ScreenController.paint(g, Config.CHARACTER_CHIT_IMAGE_LOCATION + imageFilename, (int)(newX - characterCenterX), (int)(newY - characterCenterY), 0);
    	
    }
    
    public void moveCharacter(){
    	
    }
    
    /*
     * Getters/Setters
     */
    
    //getting your victory points


    public  int              getGoldPoints()       { return goldPoints; }
    public  int              getFamePoints()       { return famePoints; }
    public  int              getNotorietyPoints()  { return notorietyPoints; }
    public  int              getTreasurePoints()   { return treasurePoints; }
    public  int              getSpellPoints()      { return spellPoints; }
    public  VictoryCondition getVictoryCondition() { return victoryCondition; }

    
    public  Dwellings getStartingPoint()                    { return startingPoint; }
    public  void      setStartingPoint()                    { startingPoint = new Dwellings(Dwellings.INN); }
    public  void      setStartingPoint(int startingDwelling){ startingPoint = new Dwellings(startingDwelling); }
    public  void      setVictoryCondition(int treasure,int fame, int notoriety,int gold,int spell){
    	victoryCondition = new VictoryCondition(treasure, fame, notoriety, gold, spell);   	
    }

	public String getImageName() {
		return imageFilename;
	}
    
}
