package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;
import com.magicrealm.common.NetworkController;
import com.magicrealm.common.config.Errors;
import com.magicrealm.server.controller.GameController;

@SuppressWarnings("serial")
public class MainMenu extends Screen {
	
	public MainMenu() {
		setLayout(new BorderLayout());
		
		// Larger font to use
		Font font = new Font("sans serif", Font.PLAIN, 20);
		
		// Background image
	    JLabel background = null;
	    BufferedImage imgBackground = null;
	    try {
			imgBackground = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "background.jpg"));
	    } catch(Exception e) {}
	    background = new JLabel(new ImageIcon(imgBackground));
		background.setLayout(new BorderLayout());

		// Button Panel
		Box buttonBox = Box.createVerticalBox();

		// Top glue to center the buttons
	    buttonBox.add(Box.createVerticalGlue());

	    // Logo
	    JLabel logo = null;
	    BufferedImage imgLogo = null;		
	    try {
			imgLogo = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "logo2glow.png"));
		} catch(Exception e) { } // Should fail silently if images aren't available
		logo = new JLabel(new ImageIcon(imgLogo));
		logo.setAlignmentX(CENTER_ALIGNMENT);
		buttonBox.add(logo);

		// Extra glue between the logo and the buttons
	    buttonBox.add(Box.createVerticalGlue());

		// Create Game button
		JButton createGameButton = new JButton("Create Game");
		createGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		createGameButton.setFont(font);
		createGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrController.show(Game.class);
				scrController.show(Lobby.class);

				/*
				try {
					NetworkController.StartServer(Config.GAME_PORT);
					// Connects to localhost, since we started our own server
					NetworkController.StartClient("127.0.0.1", Config.GAME_PORT); 
					// We're connected! Yay.

					// Create a new game
					GameController.startNewGame();
					
					// Show the game screen
					scrController.show(Game.class);
					
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, Errors.ERROR_STARTING_SERVER);
				}
				*/

			}
		});
		buttonBox.add(createGameButton);
	
		// Join Game button
		JButton joinGameButton = new JButton("Join Game");
		joinGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		joinGameButton.setFont(font);
		joinGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ipAddress = JOptionPane.showInputDialog("Enter the IP Address of the host", Config.DEFAULT_IP_ADDRESS);
				
				try {
					NetworkController.StartClient(ipAddress, Config.GAME_PORT);
					
					JOptionPane.showMessageDialog(null, "Successfully connected to host!");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, Errors.ERROR_CONNECTING_TO_HOST);
				}
				
			}
		});
		buttonBox.add(joinGameButton);
		
		// Exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setFont(font);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonBox.add(exitButton);
		
		// Bottom glue to center the buttons
	    buttonBox.add(Box.createVerticalGlue());
	
	    // Put the buttonBox on the screen
		background.add(buttonBox, BorderLayout.CENTER);
		add(background);
	}
}
