package com.magicrealm.chit;

import java.awt.Graphics;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;

public class Chit {
	
	protected String type;
	
	public Chit(String chit){
		type = chit;
	}
	public Chit(){
		type ="";
	}
	
	
	public void paint(Graphics g, int x, int y) {
						
		// Draw the image
		x += Config.HEX_TILE_IMAGE_WIDTH/2;
		y += Config.HEX_TILE_IMAGE_HEIGHT/2;
		ScreenController.paint(g, Config.CHIT_IMAGE_LOCATION, x, y, 0);
		
	}
	
	public String getType() { return type; }
}
