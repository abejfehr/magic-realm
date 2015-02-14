package com.magicrealm.client.ui.screen;

import javax.swing.JPanel;

import com.magicrealm.client.controller.ScreenController;

@SuppressWarnings("serial")
public class Screen extends JPanel {

	protected ScreenController scrController;
	
	public void setController(ScreenController screenController) {
		scrController = screenController;
	}
}
