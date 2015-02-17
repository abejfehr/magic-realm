package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.magicrealm.client.ui.map.Map;
import com.magicrealm.client.ui.map.MapCanvas;
import com.magicrealm.client.ui.map.MapFactory;
import com.magicrealm.client.ui.map.MapScroller;

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
		
		Map map = MapFactory.createIteration1Map();
		MapCanvas canvas = new MapCanvas(map);
		MapScroller mapScroller = new MapScroller(canvas);
		
		add(mapScroller, BorderLayout.CENTER);
		
		// Somehow, this is the place where the character dialog box should show up.
	}
}
