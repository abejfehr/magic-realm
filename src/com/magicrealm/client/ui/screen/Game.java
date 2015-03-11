package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

import com.magicrealm.client.ui.component.CharacterHUD;
import com.magicrealm.client.ui.component.map.MapCanvas;
import com.magicrealm.client.ui.component.map.MapScroller;
import com.magicrealm.common.model.map.Map;
import com.magicrealm.common.network.Events;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.network.Subscriber;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

/**
 * The Game screen is what displays all of the game, including the map, the
 * character HUD, the action bars, the chat and info panel, and the details
 * about the phase of the day as well as whose turn it is
 * 
 * @author	Abe Fehr
 */
@SuppressWarnings("serial")
public class Game extends Screen implements Subscriber {
	
	private MapCanvas canvas;
	private MapScroller scroller;
	private CharacterHUD hud;

	private int MARGIN = 30;
	
	public Game() {
		// Set the layout of the outside panel
	    this.setLayout(new BorderLayout());
		
	    
		// Request the map from the server
		NetworkController.subscribe(Events.MAP_UPDATED, this);
		NetworkController.sendToServer(RequestMapPacket.class);
		
	}
	
	public void drawMap(Map map) {
				
		
		// Create a new panel to have everything in it
		JLayeredPane panel = new JLayeredPane();
		panel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		hud = new CharacterHUD(GameController.myself());
		hud.setBounds(MARGIN,this.getHeight()-MARGIN-hud.getHeight(),hud.getWidth(),this.getHeight());
		panel.add(hud, JLayeredPane.PALETTE_LAYER);
		
		canvas = new MapCanvas(map);
		scroller = new MapScroller(canvas);	
		scroller.setBounds(0,0,this.getWidth(),this.getHeight());
		panel.add(scroller, JLayeredPane.DEFAULT_LAYER);

		add(panel, BorderLayout.CENTER);

		validate();
		repaint();
		
	}

	
	
	/*
	 * Called whenever the network gets updated
	 */
	public void eventFired(int event) {
		
		switch(event) {
			case Events.MAP_UPDATED:
				drawMap(GameController.getMap());				
				break;
		}
				
	}
}
