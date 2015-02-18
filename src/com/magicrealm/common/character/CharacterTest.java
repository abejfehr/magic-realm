package com.magicrealm.common.character;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.magicrealm.client.ui.screen.CharacterSelectPanel;

public class CharacterTest {

	public static void main(String[] args) {
		
		 
		Amazon player1      = new Amazon("Beatrice");
		BlackKnight player2 = new BlackKnight("Gus");
		Captain player3     = new Captain("Bob");
		Dwarf player4       = new Dwarf("Grumpy");
		Elf player5         = new Elf("Mr.Bones");
		Swordsman player6   = new Swordsman("Winchesterton Elliot Francesca de La Maison George the IV");
		
		player1.setVictoryCondition(1, 1, 1, 1, 1);
		player2.setVictoryCondition(2, 1, 0, 2, 0);
		player3.setVictoryCondition(2, 3, 0, 0, 0);
		player4.setVictoryCondition(1, 1, 1, 2, 0);
		player5.setVictoryCondition(1, 1, 0, 1, 2);
		player6.setVictoryCondition(0, 0, 3, 1, 1);
		
		System.out.println(player1.toString());
		System.out.println(player1.victoryCondition.printVictoryCondition());
		System.out.println(player2.toString());
		System.out.println(player2.victoryCondition.printVictoryCondition());
		System.out.println(player3.toString());
		System.out.println(player3.victoryCondition.printVictoryCondition());
		System.out.println(player4.toString());
		System.out.println(player4.victoryCondition.printVictoryCondition());
		System.out.println(player5.toString());
		System.out.println(player5.victoryCondition.printVictoryCondition());
		System.out.println(player6.toString());
		System.out.println(player6.victoryCondition.printVictoryCondition());
		
		JFrame testFrame = new JFrame();
		JLabel testImage = new JLabel(new ImageIcon(player1.characterChit));
    	testFrame.getContentPane().add(testImage);
    	testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(new Dimension(910,650));
		testFrame.setResizable(false);
		// TODO Auto-generated method stub
        //FIX NULL POINTER VICTORY CONDITION ISSUE
	}

}
