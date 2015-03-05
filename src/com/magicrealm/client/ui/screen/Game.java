package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;

import com.magicrealm.client.ui.component.map.MapCanvas;
import com.magicrealm.client.ui.component.map.MapScroller;
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
