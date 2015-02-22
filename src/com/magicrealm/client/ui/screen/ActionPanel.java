package com.magicrealm.client.ui.screen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

@SuppressWarnings({ "serial", "unused" })
public class ActionPanel extends JPanel {

	
	public ActionPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setForeground(Color.BLACK);
		setLayout(new GridLayout(1, 0, 0, 0));

	}

}
