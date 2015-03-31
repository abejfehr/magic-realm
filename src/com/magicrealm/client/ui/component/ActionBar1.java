package com.magicrealm.client.ui.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
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
public class ActionBar1 extends JPanel {

	private Player player; // May not be necessary, but we'll see
	protected boolean nextClick = false;
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
		JButton button1 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "hide.gif")));
		this.add(button1);
		
		ScreenController.storeImage(Config.ACTION_IMAGE_LOCATION + "move.gif");
		JButton button2 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "move.gif")));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Move Button Pressed");
				GameController.getActionController().moveCharacter();
				//GameController.getMap().enterMoveMode();
			}
		});
		this.add(button2);
		
		ScreenController.storeImage(Config.ACTION_IMAGE_LOCATION + "rest.gif");
		JButton button3 = new JButton(new ImageIcon(ScreenController.getImage(Config.ACTION_IMAGE_LOCATION + "rest.gif")));
		this.add(button3);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(300, 60);
	}




		
}
