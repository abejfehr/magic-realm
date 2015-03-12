package com.magicrealm.client.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.magicrealm.common.Player;
import com.magicrealm.server.controller.GameController;

/**
 * The CharacterHUD is a JPanel that renders an image which represents the
 * player's character as well as the victory conditions and their respective
 * stats.
 * 
 * @author      Abe Fehr
 */
@SuppressWarnings("serial")
public class PhaseInfoPanel extends JPanel {

	private Player player;
	private JLabel phaseLabel = new JLabel();
	private JLabel infoLabel = new JLabel();
	
	/**
	 * Sole constructor
	 * @param player	the player who's stats are to be displayed
	 * @see             Player
	 */
	public PhaseInfoPanel(Player player) {
		this.player = player;
		
		initPanel();
	}
	

	
	/**
	 * Initializes the panel by placing the subcomponents on it
	 */
	private void initPanel() {
		
		// Set the layout to be a grid
		setLayout(new GridLayout(2,1));
		
		// Phase label
		String phaseText = null;
		switch(GameController.getPhase()) {
			case GameController.BIRDSONG:
				phaseText = "Birdsong";
				break;
			case GameController.DAYLIGHT:
				phaseText = "Daylight";
				break;
			case GameController.SUNSET:
				phaseText = "Sunset";
				break;
			case GameController.MIDNIGHT:
				phaseText = "Midnight";
		}
		phaseLabel.setText(phaseText);
		Font phaseFont = new Font("Helvetica", Font.PLAIN, 72);
		phaseLabel.setFont(phaseFont);
		phaseLabel.setForeground(Color.WHITE);
		add(phaseLabel);
		
		// Info label
		infoLabel.setText("Day " + GameController.getDayNumber() + " - " + GameController.getCurrentPlayer().getName() + "'s turn");
		Font infoFont = new Font("Helvetica", Font.PLAIN, 24);
		infoLabel.setFont(infoFont);
		infoLabel.setForeground(Color.WHITE);
		add(infoLabel);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(400, 150);
	}
		
}
