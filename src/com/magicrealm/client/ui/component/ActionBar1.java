package com.magicrealm.client.ui.component;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
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
	private boolean enabled; // Can be disabled
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
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
		setLayout(new GridLayout(1,8));
		
		// Get the icons for the buttons
		ScreenController.storeImage(Config.ACTION_IMAGE_LOCATION + "hide.gif");
		button1 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "hide.gif")));
		button1.setEnabled(enabled);
		this.add(button1);
		
		ScreenController.storeImage(Config.ACTION_IMAGE_LOCATION + "move.gif");
		button2 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "move.gif")));
		button2.setEnabled(enabled);
		this.add(button2);
		
		ScreenController.storeImage(Config.ACTION_IMAGE_LOCATION + "rest.gif");
		button3 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "rest.gif")));
		button3.setEnabled(enabled);
		this.add(button3);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(300, 60);
	}
	
	
	
	/**
	 * Enables the action bar
	 */
	public void enable() { enabled = true; update(); }
	
	
	
	/**
	 * Disables the action bar
	 */
	public void disable() { enabled = false; update(); }
		
	
	
	/**
	 * Updates the buttons
	 */
	private void update() {
		button1.setEnabled(enabled);
		button2.setEnabled(enabled);
		button3.setEnabled(enabled);
	}
}
