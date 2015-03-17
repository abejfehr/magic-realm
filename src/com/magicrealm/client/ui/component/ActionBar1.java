package com.magicrealm.client.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.magicrealm.common.Player;

/**
 * The CharacterHUD is a JPanel that renders an image which represents the
 * player's character as well as the victory conditions and their respective
 * stats.
 * 
 * @author      Abe Fehr
 */
@SuppressWarnings("serial")
public class ActionBar1 extends JPanel {

	private Player player; // May not be necessary, but we'll see
	
	/**
	 * Sole constructor
	 * @param player	the player who's action is being requested
	 * @see             Player
	 */
	public ActionBar1(Player player) {
		this.player = player;
		
		initPanel();
	}
	

	
	/**
	 * Initializes the panel by placing the subcomponents on it
	 */
	private void initPanel() {
		
		// Set the layout to be a grid
		setLayout(new GridLayout(1,6));
		
		// Get the icons for the buttons
		JButton button1 = new JButton("MOVE");
		this.add(button1);
		
		JButton button2 = new JButton("SEEK");
		this.add(button2);
		
		JButton button3 = new JButton("END");
		this.add(button3);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(400, 75);
	}
		
}
