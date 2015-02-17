package com.magicrealm.client.ui.screen;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.magicrealm.client.Main;
import com.magicrealm.common.Config;

import java.awt.*;
import java.io.IOException;


public class CharacterSelectPanel extends JPanel{
	
	private JList       characterList;
	
	//private Box         buttonBox;
	private JPanel      imagePanel = new JPanel();
	private JScrollPane scrollPane;
	
	
	//image and label to change on different character clicks
    private JLabel        character    = new JLabel();
    private BufferedImage characterImg = null;
    
    private String[] characters = {"Amazon","Black Knight","Captain","Dwarf","Elf","Swordsman"};
    
    public CharacterSelectPanel(){
    	
    	setLayout(new BorderLayout());
    	
    	Font font = new Font("sans serif", Font.PLAIN, 20);
    	
    	characterList = new JList(characters);
    	characterList.setFont(font);
    	characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	characterList.setLayoutOrientation(JList.VERTICAL);
    	characterList.setVisibleRowCount(-1);
    	characterList.setBackground(Color.LIGHT_GRAY);
    	characterList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {				
    	    	  String img = characterList.getSelectedValue().toString().toLowerCase();  	    	  
    	    	  
    	    	  if (characterList.getSelectedValue().toString() == "Black Knight")   	    		  
    	    		  img = "black_knight";
    	    	 
    	    	  updateCharImage(""+img + ".jpg");	    	
    	      }
    	});
    	
    	scrollPane = new JScrollPane(characterList);   
    	scrollPane.setPreferredSize(new Dimension(150, 600));
    	scrollPane.setBackground(Color.LIGHT_GRAY);
    	scrollPane.setBorder(null);
    	this.add(scrollPane, BorderLayout.WEST);
    		
    	updateCharImage("amazon.jpg");
    	imagePanel.setLayout(new BorderLayout());
    	imagePanel.add(character, BorderLayout.CENTER);
    	imagePanel.setBackground(Color.LIGHT_GRAY);
    	this.add(imagePanel, BorderLayout.EAST);
    	this.setBackground(Color.LIGHT_GRAY);
    	this.setSize(new Dimension(910,650));
    	    	
    }   
    public void updateCharImage(String characterJPG){
		try {
			characterImg = ImageIO.read(Main.class.getResource(Config.CHARACTER_IMAGE_LOCATION + characterJPG));
		} catch (IOException e) {}
		character.setIcon(new ImageIcon(characterImg));
	}
    
    public static void main(String[] args) {
    	JFrame testFrame = new JFrame();
    	testFrame.getContentPane().add(new CharacterSelectPanel());
    	testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(new Dimension(910,650));
		testFrame.setResizable(false);
	}
    
   // public Character getCharacter(){
   // 	
   // }
}
