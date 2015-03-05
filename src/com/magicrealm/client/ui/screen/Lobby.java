package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;
import com.magicrealm.common.network.NetworkController;
import com.magicrealm.common.packet.RegisterPlayer;

/*
 * Pre-Game Lobby, to be Displayed after Main Menu
 * CreateGame from main menu allows client to start game
 * If the client is joining the game client can only wait for host to start game
 * 
 * Functions
 * ----------
 * -none
 */

@SuppressWarnings("serial")
public class Lobby extends Screen{
		
	/*
	 * the 4 Panels
	 */
	
	JPanel               titlePanel     = new JPanel();               //NORTH PANEL
	JPanel               optionPanel    = new JPanel();               //SOUTH PANEL
	CharacterSelectPanel characterPanel = new CharacterSelectPanel(); //EAST PANEL
	JPanel               chatPanel      = new JPanel();               //WEST PANEL
	
	/*
	 * Spinner and Spinner Models for Victory Points
	 * -option of 0-5
	 * -a total of 5 points must be selected
	 */
	
    SpinnerNumberModel gold      = new SpinnerNumberModel(0,0,5,1);
    SpinnerNumberModel fame      = new SpinnerNumberModel(0,0,5,1);
    SpinnerNumberModel notoriety = new SpinnerNumberModel(0,0,5,1);
    SpinnerNumberModel treasure  = new SpinnerNumberModel(0,0,5,1);
    SpinnerNumberModel spell     = new SpinnerNumberModel(0,0,5,1);
    
    JSpinner goldPointsSpinner      = new JSpinner(gold);
    JSpinner famePointsSpinner      = new JSpinner(fame);
    JSpinner notorietyPointsSpinner = new JSpinner(notoriety);
    JSpinner treasurePointsSpinner  = new JSpinner(treasure);	    
    JSpinner spellPointsSpinner     = new JSpinner(spell);
    
    /*
     * Lobby Screen Constructor
     */
    
	public Lobby(){
		
		//setLayout Manager
		setLayout(new BorderLayout());
		
		// Larger font to use
		Font font = new Font("sans serif", Font.PLAIN, 20);
		
		
		/*
		 *  Setting Up Background image
		 */
		
	    JLabel        background    = null;
	    BufferedImage imgBackground = null;
	    try {
			imgBackground = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "LobbyBackground.png"));
	    } catch(Exception e) {}
	    background = new JLabel(new ImageIcon(imgBackground));
		background.setLayout(new BorderLayout());
				
		/*
		 *  Setting Up Title Panel
		 *  Contains:
		 *  -Label for game logo
		 *  -label for name of game
		 */
		
	    JLabel        logo      = null;
	    JLabel        gameTitle = new JLabel("GAME TITLE");
	    BufferedImage imgLogo   = null;
	    
	    gameTitle.setFont(font);
	    
	    //Setting Game Logo Label's image
	    try {
			imgLogo = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "logo2smaller.png"));
		} catch(Exception e) { } // Should fail silently if images aren't available
		logo = new JLabel(new ImageIcon(imgLogo));
		logo.setAlignmentX(CENTER_ALIGNMENT);
		
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setPreferredSize(new Dimension(1000,200));
		titlePanel.setOpaque(false);
		titlePanel.add(logo);
		titlePanel.add(gameTitle);
		
		/*
		 * OptionPanel,
		 * Contains:
		 * -start game button
		 * -Create Character Button
		 * -JLabel for text display
		 */
				
		JLabel info = new JLabel("<html>**Based On Magic Realm, by Avalon Hills**<br> **Code Written by: Abe, Nataly, Nathan**</html>");
		info.setFont(font);
		info.setForeground(Color.CYAN);
		info.setPreferredSize(new Dimension(515,80));
		JButton startGameButton       = new JButton("Start Game");
		JButton createCharacterButton = new JButton("Create Character");
		createCharacterButton.setPreferredSize(new Dimension(450,80));
		
		/*
		 * create character button actionlistener with error checking
		 */
		
		createCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalVictory = 0;
				totalVictory += (Integer)goldPointsSpinner.getValue();
				totalVictory += (Integer)famePointsSpinner.getValue();
				totalVictory += (Integer)notorietyPointsSpinner.getValue();
				totalVictory += (Integer)treasurePointsSpinner.getValue();
				totalVictory += (Integer)spellPointsSpinner.getValue();				
				if (totalVictory != 5){
					JOptionPane.showMessageDialog(null, "Victory Points not properly set");
					
				}else if(characterPanel.getCharacterList().getSelectedValue() == null){
					JOptionPane.showMessageDialog(null, "No character class selected");
				}else {
					RegisterPlayer newPlayer = new RegisterPlayer();
					newPlayer.setPlayer(characterPanel.getCharacter((Integer)treasurePointsSpinner.getValue(), 
																	(Integer)famePointsSpinner.getValue(),
																	(Integer)notorietyPointsSpinner.getValue(),
																	(Integer)goldPointsSpinner.getValue(),
																	(Integer)spellPointsSpinner.getValue()));
					NetworkController.sendToServer(newPlayer);
				}
			}
		});
		
		/*
		 * Start Game Button actionlistener to display board
		 */
		
		startGameButton.setPreferredSize(new Dimension(450,80));
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrController.show(Game.class);
			}
		});
		
		optionPanel.setLayout(new FlowLayout());
		optionPanel.setOpaque(false);
		optionPanel.add(info);
		optionPanel.add(createCharacterButton);
		optionPanel.add(startGameButton);
		
	    /*
	     * Chat Panel
	     * -Designed to have A textarea display chat text
	     * -A text area to send text
	     * -a send text button
	     * -a list of all the players currently connected and in the chat/lobby
	     * -also has the spinners for victory point selection
	     */
	    	    
	    chatPanel.setOpaque(false);
	    chatPanel.setPreferredSize(new Dimension(500,650));
	    chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
	    
	    /*
	     * ChatPanel-Top Panel
	     * -Victory point JSpinners
	     */
	    
	    JPanel chatTopPanel       = new JPanel();
	    JPanel spinnerPanel       = new JPanel();
	    JPanel victorySpinners    = new JPanel();
	    JLabel victoryPointsLabel = new JLabel("Distribute your 5 Victory Points");
	    
	    victoryPointsLabel.setFont(font);
	        
	    spinnerPanel.setLayout(new BorderLayout());
	    spinnerPanel.add(victoryPointsLabel, BorderLayout.NORTH);	    
	    
	    victorySpinners.setLayout(new BoxLayout(victorySpinners, BoxLayout.X_AXIS));
	    victorySpinners.add(new JLabel("Gold:"));
	    victorySpinners.add(goldPointsSpinner);
	    victorySpinners.add(new JLabel("Fame:"));
	    victorySpinners.add(famePointsSpinner);
	    victorySpinners.add(new JLabel("Notoriety:"));
	    victorySpinners.add(notorietyPointsSpinner);
	    victorySpinners.add(new JLabel("Treasure:"));
	    victorySpinners.add(treasurePointsSpinner);
	    victorySpinners.add(new JLabel("Spell:"));
	    victorySpinners.add(spellPointsSpinner);
	    
	    spinnerPanel.add(victorySpinners,BorderLayout.SOUTH);
	    
	    chatTopPanel.setOpaque(false);
	    chatTopPanel.add(spinnerPanel);	    
	    
	    /*
	     * ChatPanel-Middle Panel 
	     * -Chat Box
	     * -Players connected
	     */
	    
	    JPanel    chatMiddlePanel  = new JPanel();
	    JTextArea chatText         = new JTextArea();
	    JTextArea connectedPlayers = new JTextArea();
	    
	    chatText.setBorder(BorderFactory.createEtchedBorder());
	    chatText.setText("chat text");
	    connectedPlayers.setText("Players Connected text");
	    connectedPlayers.setBorder(BorderFactory.createEtchedBorder());
	    chatMiddlePanel.setPreferredSize(new Dimension(500,490));
	    chatText.setPreferredSize(new Dimension(350,490));
	    connectedPlayers.setPreferredSize(new Dimension(120,490));
	    chatMiddlePanel.setLayout(new FlowLayout());
	    chatMiddlePanel.add(chatText);
	    chatMiddlePanel.add(connectedPlayers);
	    chatMiddlePanel.setOpaque(false);
	    
	    /*
	     * ChatPanel-Bottom Panel
	     * -Textarea for game development info
	     * -startgame button
	     * -createcharacter button
	     */
	    JPanel    chatBottomPanel  = new JPanel();	   	    
	    JTextArea sendText         = new JTextArea("text to be sent");	    
	    JButton   sendButton       = new JButton("Send Message");
	    chatBottomPanel.setPreferredSize(new Dimension(500,160));
	    sendButton.setPreferredSize(new Dimension(120,130));
	    sendText.setPreferredSize(new Dimension(350,130));
	    sendText.setLineWrap(true);
	    sendText.setBorder(BorderFactory.createEtchedBorder());
	    chatBottomPanel.setLayout(new FlowLayout());
	    chatBottomPanel.add(sendText);
	    chatBottomPanel.add(sendButton);
	    chatBottomPanel.setOpaque(false);
	    
	    chatPanel.add(chatTopPanel);
	    chatPanel.add(chatMiddlePanel);
	    chatPanel.add(chatBottomPanel);
	    
	    /*
	     * Orient the 4 Panels on top of the background
	     */
	    
		background.add(characterPanel, BorderLayout.EAST);
		background.add(titlePanel,BorderLayout.NORTH);
		background.add(chatPanel,BorderLayout.WEST);
		background.add(optionPanel,BorderLayout.SOUTH);
		add(background);

	}

}
