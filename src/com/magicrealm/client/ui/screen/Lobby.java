package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;

@SuppressWarnings("serial")
public class Lobby extends Screen{
	
	public Lobby(){
		setLayout(new BorderLayout());
		
		// Larger font to use
		Font font = new Font("sans serif", Font.PLAIN, 20);
		
		/*
		 *  Setting Up Background image
		 */
		
	    JLabel background = null;
	    BufferedImage imgBackground = null;
	    try {
			imgBackground = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "LobbyBackground.png"));
	    } catch(Exception e) {}
	    background = new JLabel(new ImageIcon(imgBackground));
		background.setLayout(new BorderLayout());

		/*
		 *  Setting Up Title Panel
		 */
		JPanel titlePanel = new JPanel();

	    JLabel logo = null;
	    JLabel gameTitle = new JLabel("GAME TITLE");
	    gameTitle.setFont(font);
	    BufferedImage imgLogo = null;		
	    try {
			imgLogo = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "logo.png"));
		} catch(Exception e) { } // Should fail silently if images aren't available
		logo = new JLabel(new ImageIcon(imgLogo));
		logo.setAlignmentX(CENTER_ALIGNMENT);
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setPreferredSize(new Dimension(1000,200));
		titlePanel.setOpaque(false);
		titlePanel.add(logo);
		titlePanel.add(gameTitle);
		
		/*
		 * OptionPanel, start game/ other notes on the bottom
		 */
		JPanel optionPanel = new JPanel();
		
		JLabel info = new JLabel("<html>**Based On Magic Realm, by Avalon Hills**<br> **Code Written by: Abe, Nataly, Nathan**</html>");
		info.setFont(font);
		info.setForeground(Color.CYAN);
		info.setPreferredSize(new Dimension(500,80));
		JButton startGameButton = new JButton("Start Game");
		JButton selectCharacterButton = new JButton("Select Character");
		selectCharacterButton.setPreferredSize(new Dimension(450,80));
		startGameButton.setPreferredSize(new Dimension(450,80));
		optionPanel.setLayout(new FlowLayout());
		optionPanel.setOpaque(false);
		optionPanel.add(info);
		optionPanel.add(selectCharacterButton);
		optionPanel.add(startGameButton);
		
		

	    /*
	     * Character selection panel
	     */
	    CharacterSelectPanel characterPanel = new CharacterSelectPanel();
	    
	    /*
	     * Chat Panel
	     */
	    
	    JPanel chatPanel = new JPanel();
	    chatPanel.setOpaque(false);
	    chatPanel.setPreferredSize(new Dimension(500,650));
	    chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
	    
	    
	    JPanel    chatTopPanel     = new JPanel();
	    JTextArea chatText         = new JTextArea();
	    JTextArea connectedPlayers = new JTextArea();
	    chatText.setText("chat text");
	    connectedPlayers.setText("Players Connected text");
	    chatTopPanel.setPreferredSize(new Dimension(500,490));
	    chatText.setPreferredSize(new Dimension(350,490));
	    connectedPlayers.setPreferredSize(new Dimension(120,490));
	    chatTopPanel.setLayout(new FlowLayout());
	    chatTopPanel.add(chatText);
	    chatTopPanel.add(connectedPlayers);
	    chatTopPanel.setOpaque(false);
	    
	    
	    JPanel    chatBottomPanel  = new JPanel();	   	    
	    JTextArea sendText         = new JTextArea("text to be sent");	    
	    JButton   sendButton       = new JButton("Send Message");
	    chatBottomPanel.setPreferredSize(new Dimension(500,160));
	    sendButton.setPreferredSize(new Dimension(120,130));
	    sendText.setPreferredSize(new Dimension(350,130));
	    sendText.setLineWrap(true);
	    chatBottomPanel.setLayout(new FlowLayout());
	    chatBottomPanel.add(sendText);
	    chatBottomPanel.add(sendButton);
	    chatBottomPanel.setOpaque(false);
	    
	    chatPanel.add(chatTopPanel);
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
