package com.magicrealm.client.ui.screen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.magicrealm.client.controller.ScreenController;
import com.magicrealm.common.Config;
import com.magicrealm.common.character.Amazon;
import com.magicrealm.common.character.BlackKnight;
import com.magicrealm.common.character.Captain;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.character.Dwarf;
import com.magicrealm.common.character.Elf;
import com.magicrealm.common.character.Swordsman;


@SuppressWarnings("serial")
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
    	    	  //System.out.println(getCharacter().toString());
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
    	
    	String name = JOptionPane.showInputDialog(null, "What's your Characters name?", "Name");
    	
    	if(characterSelectString == "Amazon"){
    		newCharacter = new Amazon(name);
    	}
    	else if(characterSelectString == "Black Knight"){
    		newCharacter = new BlackKnight(name);
    	}
    	else if(characterSelectString == "Captain"){
    		newCharacter = new Captain(name);
    	}
    	else if(characterSelectString == "Dwarf"){
    		newCharacter = new Dwarf(name);
    	}
    	else if(characterSelectString == "Elf"){
    		newCharacter = new Elf(name);
    	}
    	else if(characterSelectString == "Swordsman"){
    		newCharacter = new Swordsman(name);
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
    public JList getCharacterList(){
    	return characterList;
    }
}
