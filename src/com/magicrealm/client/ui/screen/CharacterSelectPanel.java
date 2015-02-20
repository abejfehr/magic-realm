package com.magicrealm.client.ui.screen;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import com.magicrealm.client.Main;
import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.character.*;
import com.magicrealm.common.character.Character;

import java.awt.*;
import java.io.IOException;


public class CharacterSelectPanel extends JPanel{
	
	private JList       characterList;
	
	//private Box         buttonBox;
	private JPanel      imagePanel = new JPanel();
	private JScrollPane scrollPane;
	
	JPanel mainPanel = new JPanel();
	
	//image and label to change on different character clicks
    private JLabel        character    = new JLabel();
    //private BufferedImage characterImg = null;
    
    private String[] characters = {"Amazon","Black Knight","Captain","Dwarf","Elf","Swordsman"};
    
    public CharacterSelectPanel(){
    	this.setPreferredSize(new Dimension(910,650));
    	mainPanel.setPreferredSize(new Dimension(910,650));
    	mainPanel.setOpaque(false);
    	setLayout(new BorderLayout());
    	
    	Font font = new Font("sans serif", Font.PLAIN, 20);
    	
    	characterList = new JList(characters);
    	characterList.setFont(font);
    	characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	characterList.setLayoutOrientation(JList.VERTICAL);
    	characterList.setVisibleRowCount(-1);
    	characterList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {				
    	    	  String img = characterList.getSelectedValue().toString().toLowerCase();  	    	  
    	    	  
    	    	  if (characterList.getSelectedValue().toString() == "Black Knight")   	    		  
    	    		  img = "black_knight";
    	    	 
    	    	  updateCharImage(""+img + ".jpg");
    	    	  System.out.println(getCharacter().toString());
    	    }
			
    	});
    	
    	scrollPane = new JScrollPane(characterList);   
    	scrollPane.setPreferredSize(new Dimension(150, 600));
    	scrollPane.getViewport().setOpaque(false);
    	scrollPane.setOpaque(false);
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(scrollPane,BorderLayout.WEST);
    		
    	updateCharImage("amazon.jpg");

    	character.setPreferredSize(new Dimension(750,650));
    	mainPanel.add(character, BorderLayout.EAST);
    	this.add(mainPanel);
    	this.setOpaque(false);
    	    	
    }   
    
    public void updateCharImage(String characterJPG){

    	ScreenController.storeImage(Config.CHARACTER_IMAGE_LOCATION + characterJPG);
    	BufferedImage characterImage = ScreenController.getImage(Config.CHARACTER_IMAGE_LOCATION + characterJPG);
		character.setIcon(new ImageIcon(characterImage));
		
	}
    
    public Character getCharacter(){
    	String characterSelectString = characterList.getSelectedValue().toString();
    	Character newCharacter = null;
    	
    	if(characterSelectString == "Amazon"){
    		newCharacter = new Amazon("blank1");
    	}
    	else if(characterSelectString == "Black Knight"){
    		newCharacter = new BlackKnight("blank2");
    	}
    	else if(characterSelectString == "Captain"){
    		newCharacter = new Captain("blank3");
    	}
    	else if(characterSelectString == "Dwarf"){
    		newCharacter = new Dwarf("blank4");
    	}
    	else if(characterSelectString == "Elf"){
    		newCharacter = new Elf("blank5");
    	}
    	else if(characterSelectString == "Swordsman"){
    		newCharacter = new Swordsman("blank6");
    	}
    	
    	return newCharacter;
    } 
    
    public static void main(String[] args) {
    	JFrame testFrame = new JFrame();
    	testFrame.getContentPane().add(new CharacterSelectPanel());
    	testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(new Dimension(910,650));
		testFrame.setResizable(false);
		
		
	}  
}
