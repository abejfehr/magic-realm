package com.magicrealm.client.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;

/**
 * The DicePanel is designed to show whether or not the player is in cheat
 * mode, as well as the last dice roll made by that player.
 * 
 * @author      Abe Fehr
 */
@SuppressWarnings("serial")
public class DicePanel extends JPanel {

	private Player player;
	private Character character;
	private JLabel diceImage = null;
	private JLabel cheatModeLabel = new JLabel();
	
	/**
	 * Sole constructor
	 * @param player	the player who's die is displayed
	 * @see             Player
	 */
	public DicePanel(Player player) {
		this.player = player;
		this.character = player.getCharacter();
		
		initPanel();
	}
	

	
	/**
	 * Initializes the panel by placing the sub-components on it
	 */
	private void initPanel() {
		
		// Create the character's image
		BufferedImage image = null;
		try {
			image = ImageIO.read(ScreenController.class.getResource(Config.MISC_IMAGE_LOCATION + "dice.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		diceImage = new JLabel(new ImageIcon(image));
		this.add(diceImage);
		
		Font cheatModeFont = new Font("Helvetica", Font.BOLD, 18);
		cheatModeLabel.setFont(cheatModeFont);
		cheatModeLabel.setForeground((/*character.isCheating()*/true ? Color.GREEN : Color.RED));
		cheatModeLabel.setText("Cheat Mode: " + (true ? "on" : "off"));
		this.add(cheatModeLabel);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(200, 230);
	}
		
}
