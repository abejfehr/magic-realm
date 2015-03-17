package com.magicrealm.client.ui.component;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
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
		
		JPanel picturePanel = new JPanel();
		picturePanel.setLayout(new BoxLayout(picturePanel, BoxLayout.PAGE_AXIS));
		picturePanel.setOpaque(false);
		
		// Create the player's name
		JLabel playerNameLabel = new JLabel(player.getName(), SwingConstants.CENTER);
		Font nameFont = new Font("Helvetica", Font.BOLD, 16);
		playerNameLabel.setFont(nameFont);
		playerNameLabel.setForeground(Color.WHITE);
		//playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		picturePanel.add(playerNameLabel);

		// Create the character's image
		ScreenController.storeImage(Config.CHARACTER_HUD_IMAGE_LOCATION + character.getImageName());
		characterImage = new JLabel(new ImageIcon(ScreenController.getImage(Config.CHARACTER_HUD_IMAGE_LOCATION + character.getImageName()) ));
		//characterImage.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		picturePanel.add(characterImage);
		
		this.add(picturePanel);
		
		JPanel conditionsPanel = new JPanel();
		conditionsPanel.setLayout(new GridLayout(5,1));
		conditionsPanel.setOpaque(false);
		
		// Make the individual labels for the victory conditions
		this.victoryConditionLabels = new JLabel[5];
		
		// Populate the labels
		
		// The label for Fame
		if(character.getVictoryCondition().getFamePoints() > 0) {
			victoryConditionLabels[0] = new JLabel("Fame: " + character.getFamePoints() + "/" + character.getVictoryCondition().getFamePoints());
		}

		// The label for Gold
		if(character.getVictoryCondition().getGoldPoints() > 0) {
			victoryConditionLabels[1] = new JLabel("Gold: " + character.getGoldPoints() + "/" + character.getVictoryCondition().getGoldPoints());
		}

		// The label for Notoriety
		if(character.getVictoryCondition().getNotorietyPoints() > 0) {
			victoryConditionLabels[2] = new JLabel("Notoriety: " + character.getNotorietyPoints() + "/" + character.getVictoryCondition().getNotorietyPoints());
		}

		// The label for Spell
		if(character.getVictoryCondition().getSpellPoints() > 0) {
			victoryConditionLabels[3] = new JLabel("Spell: " + character.getSpellPoints() + "/" + character.getVictoryCondition().getSpellPoints());
		}

		// The label for Treasure
		if(character.getVictoryCondition().getTresurePoints() > 0) {
			victoryConditionLabels[4] = new JLabel("Treasure: " + character.getTreasurePoints() + "/" + character.getVictoryCondition().getTresurePoints());
		}

		// TODO: change the above to the correct number
		for(int i=0;i<victoryConditionLabels.length;++i) {
			if(victoryConditionLabels[i] != null) {
				Font conditionFont = new Font("Helvetica", Font.PLAIN, 16);
				victoryConditionLabels[i].setFont(conditionFont);
				victoryConditionLabels[i].setForeground(Color.WHITE);
				conditionsPanel.add(victoryConditionLabels[i]);
			}
		}
		
		this.add(conditionsPanel);
		
		// Don't draw the background
		this.setOpaque(false);
		
		this.setSize(300, 200);
	}
		
}
