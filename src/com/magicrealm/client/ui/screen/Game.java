package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapScroller;

import com.magicrealm.common.model.map.Map;

import com.magicrealm.common.network.Events;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.network.Subscriber;
import com.magicrealm.common.packet.RequestMapPacket;
import com.magicrealm.server.controller.GameController;

@SuppressWarnings("serial")
public class Game extends Screen implements Subscriber {
	
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
		NetworkController.subscribe(Events.MAP_UPDATED, this);
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
			case Events.MAP_UPDATED:
				drawMap(GameController.getMap());				
				break;
		}
				
	}
}
