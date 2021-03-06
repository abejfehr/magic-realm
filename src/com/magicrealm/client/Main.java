package com.magicrealm.client;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import com.esotericsoftware.minlog.Log;
import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.client.ui.screen.Screen;

@SuppressWarnings("serial")
public class Main extends JFrame implements Observer {

	// Used to switch between screens
	ScreenController scrController;
	
	Main() {
		// Start the screen controller
		scrController = new ScreenController();
		
		//window.add(background);
		add(scrController.getScreen());		
		
		// Set the logger
		Log.setLogger(new com.magicrealm.common.Logger());
		
		// Build and show the window
		pack();
		setVisible(true);
	    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Main program = new Main();
		program.scrController.addObserver(program);
	}

	@Override
	public void update(Observable o, Object screen) {
		getContentPane().removeAll();
		add((Screen)screen);
		validate();
		repaint();
	}
}
