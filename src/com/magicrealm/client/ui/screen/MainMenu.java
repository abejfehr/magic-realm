package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;

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
			imgLogo = ImageIO.read(Main.class.getResource(Config.MISC_IMAGE_LOCATION + "logo.png"));
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
				scrController.show(Game.class);
				//scrController.show(Lobby.class);
			}
		});
		buttonBox.add(createGameButton);
	
		// Join Game button
		JButton joinGameButton = new JButton("Join Game");
		joinGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		joinGameButton.setFont(font);
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
