package com.magicrealm.client.ui.component;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.magicrealm.common.Player;
import com.magicrealm.common.character.Character;

/**
 * The CharacterHUD is a JPanel that renders an image which represents the
 * player's character as well as the victory conditions and their respective
 * stats.
 * 
 * @author      Abe Fehr
 */
@SuppressWarnings("serial")
public class CharacterHUD extends JPanel {

	private Player player;
	private Character character;
	private JLabel characterImage = null;
	private JLabel[] victoryConditionLabels;
	
	/**
	 * Sole constructor
	 * @param player	the player who's stats are to be displayed
	 * @see             Player
	 */
	public CharacterHUD(Player player) {
		this.player = player;
		this.character = player.getCharacter();
		
		initHUD();
	}
	

	
	/**
	 * Initializes the CharacterHUD by placing the components on the screen
	 */
	private void initHUD() {
		
		// Create the character's image
		try {
			characterImage = new JLabel(new ImageIcon(new URL("https://dl.dropboxusercontent.com/u/1330689/captain.png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(characterImage);
		
		// Make the individual labels for the victory conditions
		this.victoryConditionLabels = new JLabel[5];
		// TODO: change the above to the correct number
		for(int i=0;i<victoryConditionLabels.length;++i) {
			JLabel conditionLabel = new JLabel("Fame: 0/10");
			victoryConditionLabels[i] = conditionLabel;
			this.add(victoryConditionLabels[i]);
		}
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(400, 240);
	}
		
}
