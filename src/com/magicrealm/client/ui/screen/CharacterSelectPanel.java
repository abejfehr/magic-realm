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
import com.magicrealm.common.Dwellings;
import com.magicrealm.common.character.Amazon;
import com.magicrealm.common.character.BlackKnight;
import com.magicrealm.common.character.Captain;
import com.magicrealm.common.character.Character;
import com.magicrealm.common.character.Dwarf;
import com.magicrealm.common.character.Elf;
import com.magicrealm.common.character.Swordsman;

/*
 * Character Select Panel
 * -Displayed In pre-Game Lobby
 * -List of possible characters to choose
 * -Label displaying the image of character information
 * 
 * Functions
 * ----------
 * -getCharacter()     (returns a new character depending on JList selection)
 * -updateCharImage()  (updates the image in character JLabel) 
 * -getCharacterList() (returns JList of characters)
 */

@SuppressWarnings("serial")
public class CharacterSelectPanel extends JPanel{
	
	/*
	 * Parameters
	 **************
	 *-JList of characters
	 *-String Array with character classes
	 *-ScrollPane to display JList
	 *-Character JLabel for characterInfo
	 *-MainPanel to display everything in
	 */
	
	private JList       characterList;
	private String[]    characters = {"Amazon","Black Knight","Captain","Dwarf","Elf","Swordsman"};
	private JScrollPane scrollPane;
	
	private JLabel      character  = new JLabel();
		
	//JPanel mainPanel = new JPanel();
       
    public CharacterSelectPanel(){
    	
    	this.setPreferredSize(new Dimension(910,650));
    	this.setOpaque(false);
    	
    	setLayout(new BorderLayout());
    	
    	Font font = new Font("sans serif", Font.PLAIN, 20);
    	
    	//setting up the character list and action listener
    	
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
    	    	  
    	    }
			
    	});
    	
    	//Adding list to the scroll pane and setting scroll pane settings
    	
    	scrollPane = new JScrollPane(characterList);   
    	scrollPane.setPreferredSize(new Dimension(150, 600));
    	scrollPane.getViewport().setOpaque(false);
    	scrollPane.setOpaque(false);
    	
    	//default starting image is the amazon
    	
    	updateCharImage("amazon.jpg");
    	character.setPreferredSize(new Dimension(750,650));
    	
    	this.add(scrollPane,BorderLayout.WEST);
    	this.add(character, BorderLayout.EAST);
    	    	    	
    }   
    
    /*
     * Updates the character JLabel Image Icon to a new characterInfo image
     */
    
    public void updateCharImage(String characterJPG){

    	ScreenController.storeImage(Config.CHARACTER_IMAGE_LOCATION + characterJPG);
    	BufferedImage characterImage = ScreenController.getImage(Config.CHARACTER_IMAGE_LOCATION + characterJPG);
		character.setIcon(new ImageIcon(characterImage));
		
	}
    
    /*
     *getCharacter()
     *-called when createCharacter is clicked in lobby screen
     *returns an instance of a new character based on which character "class" is seleceted
     *in the JList scrollpane.
     */
    
    public Character getCharacter(){
    	
    	String    characterSelectString = characterList.getSelectedValue().toString();
    	Character newCharacter          = null;   	
    	String    name                  = JOptionPane.showInputDialog(null, 
    																 "What's your Characters name?", 
    																 "Name");
    	
    	//Determine which character class is being selected and create new instance of it
    	
    	if(characterSelectString == "Amazon"){
    		newCharacter = new Amazon(name);
    	}
    	else if(characterSelectString == "Black Knight"){
    		newCharacter = new BlackKnight(name);
    	}
    	else if(characterSelectString == "Captain"){ //Captain has to select one of 3 locations to start at
    		newCharacter = new Captain(name);
    		Object[] options = {"The Inn",
                    "The House",
                    "The GuardHouse"};
    		int n = JOptionPane.showOptionDialog(null,
    											"As the Captain please choose your starting Location",
    											"Starting Location",
    											JOptionPane.YES_NO_CANCEL_OPTION,
    											JOptionPane.QUESTION_MESSAGE,
    											null,
    											options,
    											options[0]);
    		switch (n){
    			case 0:
    				n = Dwellings.INN;
    				break;
    			case 1:
    				n = Dwellings.HOUSE;
    				break;
    			case 2:
    				n = Dwellings.GUARD_HOUSE;
    				break;
    		}
    		newCharacter.setStartingPoint(n);
    		
    	}
    	else if(characterSelectString == "Dwarf"){ //Dwarf has to select one of 2 locations to start at
    		newCharacter = new Dwarf(name);
    		Object[] options = {"The Inn",
                    "The GuardHouse"};
    		int n = JOptionPane.showOptionDialog(null,
    											"As the Dwarf please choose your starting Location",
    											"Starting Location",
    											JOptionPane.YES_NO_OPTION,
    											JOptionPane.QUESTION_MESSAGE,
    											null,
    											options,
    											options[0]);
    		switch (n){
    			case 0:
    				n = Dwellings.INN;
    				break;
    			case 1:
    				n = Dwellings.GUARD_HOUSE;
    		}   		
    		newCharacter.setStartingPoint(n);
    		
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
    
    /*
     * Getters and Setters
     */
    
    public JList getCharacterList(){ return characterList; }
    
}
