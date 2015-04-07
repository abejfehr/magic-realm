package com.magicrealm.client.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.magicrealm.common.Player;
import com.magicrealm.server.controller.GameController;

/**
 * The PeriodInfoPanel is a JPanel that renders an image which represents the
 * period of the day(birdsong, daylight, sunset or midnight) and whose turn it
 * is.
 * 
 * @author      Abe Fehr
 */
@SuppressWarnings("serial")
public class PeriodInfoPanel extends JPanel {

	//private Player player;
	private JLabel periodLabel = new JLabel();
	private JLabel infoLabel = new JLabel();
	
	/**
	 * Sole constructor
	 * @param player	the player who's stats are to be displayed
	 * @see             Player
	 */
	public PeriodInfoPanel(Player player) {
		//this.player = player;
		
		initPanel();
	}
	

	
	/**
	 * Initializes the panel by placing the subcomponents on it
	 */
	private void initPanel() {
		
		// Set the layout to be a grid
		setLayout(new GridLayout(2,1));
		
		// Phase label
		Font phaseFont = new Font("Helvetica", Font.PLAIN, 72);
		periodLabel.setFont(phaseFont);
		periodLabel.setForeground(Color.WHITE);
		add(periodLabel);
		
		// Info label
		Font infoFont = new Font("Helvetica", Font.PLAIN, 24);
		infoLabel.setFont(infoFont);
		infoLabel.setForeground(Color.WHITE);
		add(infoLabel);
		
		this.update();
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(400, 150);
	}
	
	public void update() {
		String periodText = null;
		switch(GameController.getPeriod()) {
			case GameController.BIRDSONG:
				periodText = "Birdsong";
				break;
			case GameController.DAYLIGHT:
				periodText = "Daylight";
				break;
			case GameController.SUNSET:
				periodText = "Sunset";
				break;
			case GameController.MIDNIGHT:
				periodText = "Midnight";
		}
		periodLabel.setText(periodText);
		infoLabel.setText("Day " + GameController.getDayNumber() + " - " + GameController.getCurrentPlayer().getName() + "'s turn");
	}
}
