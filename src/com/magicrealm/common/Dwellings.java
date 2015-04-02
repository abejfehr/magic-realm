package com.magicrealm.common;

import java.awt.Graphics;

import com.magicrealm.client.controller.ScreenController;

/*
 * Dwellings that are either being displayed on the board 
 * or are being set as a characters starting point
 * 
 * Functions
 * ----------
 * -getLocation() returns string of dwelling location ie: CV5 = cursed valley 5
 * -setLocation(string) sets location of dwelling based on string code ie: CV5
 * -getDwellingType() returns which dwelling it is (int)
 * -paint(graphics, x-cord, y-cord, offset-x, offset-y, angle of tile) function used for painting the dwelling on the map
 */

public class Dwellings {
	
	/*
	 * Constants determining value for each dwelling
	 */
	
	public static final int NOT_SET        = 0;
	public static final int INN            = 1;
	public static final int CHAPEL	       = 2;
	public static final int SMALL_CAMPFIRE = 3;
	public static final int LARGE_CAMPFIRE = 4;
	public static final int HUT            = 5;
	public static final int GUARD_HOUSE    = 6;
	public static final int HOUSE          = 7;
	public static final int TWO_GHOSTS     = 8;
	
	/*
	 * Parameters
	 */
	
	private String location = null;
	private String imageName;
	private int    dwelling;
	
	public Dwellings() { dwelling = HUT; } // No-arg constructor for serialization
	
	//Constructor, int determines which dwelling it is
	
	public Dwellings(int dwelling){
		this.dwelling = dwelling;
		
		switch (dwelling){
		case INN:
			imageName = "inn.gif";
			setLocation("BL5");
			break;
		case CHAPEL:
			imageName = "chapel.gif";
			setLocation("AV5");
			break;
		case SMALL_CAMPFIRE:
			imageName = "small_fire.gif";
			break;
		case LARGE_CAMPFIRE:
			imageName = "large_fire.gif";
			break;
		case HUT:
			imageName = "hut.gif";
			break;
		case GUARD_HOUSE:
			imageName = "guard.gif";
			setLocation("DV5");
			break;
		case HOUSE:
			imageName = "house.gif";
			setLocation("CV5");
			break;
		case TWO_GHOSTS:
			imageName = "ghost.gif";
			break;
		default:
			// Display some kind of error image here
		}
		
	}
	
	/*
	 * Getters and Setters
	 */
	
	public String getLocation()                { return location; }
	public void   setLocation(String location) { this.location = location; }
	public int    getDwellingType()            { return dwelling; }
	
	public void paint(Graphics g, int x, int y, int oX, int oY, int angle) {
		
		// The angle, in radians
		double rotation = Math.toRadians(angle);
		
		// Get the center of the icon TODO: fix this, this is a terrible approximate of the icon size
		double dwellingCenterX = 100 / 2;
		double dwellingCenterY = 100 / 2;
				
		int centerX = Config.HEX_TILE_IMAGE_WIDTH / 2;
		int centerY = Config.HEX_TILE_IMAGE_HEIGHT / 2;

		double newX = x + centerX + (oX-centerX)*Math.cos(rotation) - (oY-centerY)*Math.sin(rotation);
		double newY = y + centerY + (oX-centerX)*Math.sin(rotation) + (oY-centerY)*Math.cos(rotation);
		
		// Draw the image
		ScreenController.paint(g, Config.DWELLINGS_IMAGE_LOCATION + imageName, (int)(newX - dwellingCenterX), (int)(newY - dwellingCenterY), 0);
		
	}
	
}
