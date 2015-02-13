package com.magicrealm.client;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.magicrealm.client.ui.screen.MainMenu;

public class Main {
	public static void main(String[] args) {
		// Create the window
		JFrame window = new JFrame();
						
		JPanel screen = new MainMenu();

		//window.add(background);
		window.add(screen);
			
		// Build and show the window
		window.pack();
		window.setVisible(true);
	    window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
