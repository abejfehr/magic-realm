package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapScroller;
import com.magicrealm.common.NetworkController;
import com.magicrealm.common.NetworkEvents;
import com.magicrealm.common.NetworkObserver;
import com.magicrealm.common.model.Map;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

@SuppressWarnings("serial")
public class Game extends Screen implements NetworkObserver {
	
	public Game() {

		setLayout(new BorderLayout());
		
		// Create a back button for testing
		JButton test = new JButton("Back to Main Menu");
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrController.show(MainMenu.class);
			}
		});
		add(test, BorderLayout.NORTH);
		
		// Request the map from the server
		NetworkController.subscribe(NetworkEvents.MAP_UPDATED, this);
		NetworkController.sendToServer(RequestMapPacket.class);
		
	}
	
	public void drawMap(Map map) {
		
		MapCanvas canvas = new MapCanvas(map);
		MapScroller scroller = new MapScroller(canvas);
		add(scroller, BorderLayout.CENTER);
		validate();
		repaint();
		
	}

	
	
	/*
	 * Called whenever the network gets updated
	 */
	public void eventFired(int event) {
		
		switch(event) {
			case NetworkEvents.MAP_UPDATED:
				drawMap(GameController.getMap());				
				break;
		}
				
	}
}
