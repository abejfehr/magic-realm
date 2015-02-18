package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapScroller;
import com.magicrealm.common.NetworkController;
import com.magicrealm.common.model.Map;
import com.magicrealm.common.packet.RequestMapPacket;

@SuppressWarnings("serial")
public class Game extends Screen {

	public Game() {
		setLayout(new BorderLayout());
		
		// Create a back button for testing
		JButton test = new JButton("Back to Main Menu");
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(scrController);
				scrController.show(MainMenu.class);
			}
		});
		add(test);
		
		// Request the map from the server
		NetworkController.sendToServer(RequestMapPacket.class);
	}
	
	public void drawMap(Map map) {
		
		MapCanvas canvas = new MapCanvas(map);
		MapScroller mapScroller = new MapScroller(canvas);
		add(mapScroller, BorderLayout.CENTER);
		
	}
}
