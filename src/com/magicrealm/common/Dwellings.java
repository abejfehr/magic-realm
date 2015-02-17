package com.magicrealm.common;

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
	static final int NOT_SET        = 0;
	static final int INN            = 1;
	static final int CHAPEL	        = 2;
	static final int SMALL_CAMPFIRE = 3;
	static final int LARGE_CAMPFIRE = 4;
	static final int HUT            = 5;
	static final int GUARD_HOUSE    = 6;
	static final int HOUSE          = 7;
	static final int TWO_GHOSTS     = 8;
	
	
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

}
