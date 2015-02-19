package com.magicrealm.common;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.magicrealm.client.Main;
import com.magicrealm.client.controller.ScreenController;

public class Dwellings {
	/*
	 * List of functions
	 * - setImage(String) sets the dwelling image, takes a string (the name of image file in /res/dwellings/)
	 * - getImage() returns the dwellingImage to be used
	 */
	
	/*
	 * Constants determining value for each dwelling
	 */	
	public static final int NOT_SET        = 0;
	public static final int INN            = 1;
	public static final int CHAPEL	        = 2;
	public static final int SMALL_CAMPFIRE = 3;
	public static final int LARGE_CAMPFIRE = 4;
	public static final int HUT            = 5;
	public static final int GUARD_HOUSE    = 6;
	public static final int HOUSE          = 7;
	public static final int TWO_GHOSTS     = 8;
	
	private String location = null;
	private String imageName;
	
	/*
	 * Parameters
	 */
	int dwelling;
	
	public Dwellings() { dwelling = HUT; } // No-arg constructor for serialization
	
	public Dwellings(int dwelling){
		this.dwelling = dwelling;
		
		switch (dwelling){
		case INN:
			imageName = "inn.gif";
			break;
		case CHAPEL:
			imageName = "chapel.gif";
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
			break;
		case HOUSE:
			imageName = "house.gif";
			break;
		case TWO_GHOSTS:
			imageName = "ghost.gif";
			break;
		default:
			// Display some kind of error image here
		}
		
	}
	
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }

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
