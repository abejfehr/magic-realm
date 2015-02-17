package com.magicrealm.common;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.magicrealm.client.Main;

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
	
	/*
	 * Parameters
	 */
	int dwelling;
	BufferedImage dwellingImage = null;
	
	public Dwellings(int dwelling){
		this.dwelling = dwelling;
		
		switch (dwelling){
		case 1:
			setImage("inn.gif");
			break;
		case 2:
			setImage("chapel.gif");
			break;
		case 3:
			setImage("small_fire.gif");
			break;
		case 4:
			setImage("large_fire.gif");
			break;
		case 5:
			setImage("hut.gif");
			break;
		case 6:
			setImage("guard.gif");
			break;
		case 7:
			setImage("house.gif");
			break;
		case 8:
			//setImage("");
			//SHOULD BE GHOST IMAGE BUT CAN'T FIND IT AT THE MOMENT
			try {
				dwellingImage = ImageIO.read(Main.class.getResource(Config.ERROR_IMAGE_LOCATION + "missingImage.png"));
			} catch (IOException e) {}	
			break;
		default:
			try {
				dwellingImage = ImageIO.read(Main.class.getResource(Config.ERROR_IMAGE_LOCATION + "missingImage.png"));
			} catch (IOException e) {}					
		}
		
	}
	/*
	 * Sets dwelling image to anyone of the 7 dwellings depending on what dwelling the particular instance is
	 */
	public void setImage(String dwellingGIF){
		try {
			dwellingImage = ImageIO.read(Main.class.getResource(Config.DWELLINGS_IMAGE_LOCATION + dwellingGIF));
		} catch (IOException e) {}		
	}
	
	/*
	 * returns dwellingImage to be displayed
	 */
	public BufferedImage getImage(){ return dwellingImage; } 
	
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }

	public void paint(Graphics g, int x, int y, int oX, int oY, int angle) {
		
		// The angle, in radians
		double rotation = Math.toRadians(angle);
		
		// Get the center of the icon
		double dwellingCenterX = dwellingImage.getWidth() / 2;
		double dwellingCenterY = dwellingImage.getHeight() / 2;
				
		int centerX = Config.HEX_TILE_IMAGE_WIDTH / 2;
		int centerY = Config.HEX_TILE_IMAGE_HEIGHT / 2;

		double newX = x + centerX + (oX-centerX)*Math.cos(rotation) - (oY-centerY)*Math.sin(rotation);
		double newY = y + centerY + (oX-centerX)*Math.sin(rotation) + (oY-centerY)*Math.cos(rotation);
		
		// Draw the image
		g.drawImage(dwellingImage, (int)(newX - dwellingCenterX), (int)(newY - dwellingCenterY), null);
		
	}
}
