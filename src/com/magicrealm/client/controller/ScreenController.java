package com.magicrealm.client.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Observable;

import javax.imageio.ImageIO;

//import apple.laf.JRSUIUtils.Images;
import com.magicrealm.client.ui.screen.MainMenu;
import com.magicrealm.client.ui.screen.Screen;

/*
 * ScreenController will manage which screen is currently shown in the game.
 * 
 * The Main class(the entry point of the program) registered as an observer for
 * this class.
 * 
 * If you'd like to show a screen, simply do this:
 * - Make your screen so it extends com.magicrealm.client.ui.screen.Screen;
 * - Anywhere you'd like to switch screens, simply call the following:
 *     scrController.show(MyScreen.class)
 * 
 * The above code shows MyScreen in the window instead of whatever was just
 * shown.
 * 
 * Things to keep in mind:
 * - It doesn't remember or care about the state of your previous screen. If 
 * your screen needs to store something besides what's already in the model,
 * you'd better put it in the model.
 * - It doesn't care what kind of parameter gets passed into show(). It works
 * with reflection, but I don't think I have the ability to limit parameters to
 * only be Screen types. Be careful.
 * - It expects your screen to have a constructor with NO parameters
 * 
 */
public class ScreenController extends Observable {
	
	/*
	 * Private members
	 */
	// Stores the current screen
	private Screen screen;
	private static HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	
	
	
	/**
	 * The Constructor
	 */
	public ScreenController() {
		screen = new MainMenu();
		screen.setController(this);
	}
	
	public void show(Class<?> screen) {
		Object newScreen = null;
		try {
			newScreen = screen.newInstance();
			((Screen) newScreen).setController(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.screen = (Screen)newScreen;
		setChanged();
		notifyObservers(this.screen);
	}

	public Screen getScreen() {
		return screen;
	}
	
	
	/**
	 * Paints the images to the display
	 */
	public static void paint(Graphics g, String imagePath, int x, int y, int sizeX, int sizeY, float opacity) {
		// Check if the image is already stored
		if(!images.containsKey(imagePath)) {
			BufferedImage image = null;

			try {
				image = ImageIO.read(ScreenController.class.getResource(imagePath));
			} catch(Exception e) { 
				System.out.println("Something failed");
			}
			
			AffineTransform tx = AffineTransform.getScaleInstance(2.5f, 2.5f);
			AffineTransformOp resizeOp = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			image = resizeOp.filter(image, null);
			images.put(imagePath, image);

		}
		
		Graphics2D graphics = (Graphics2D) g;
		
		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		graphics.drawImage(images.get(imagePath), x, y, null);
	}	

	/**
	 * Paints the images to the display
	 */
	public static void paint(Graphics g, String imagePath, int x, int y, int angle) {

		// Check if the image is already stored
		if(!images.containsKey(imagePath)) {
			
			BufferedImage image = null;
			
			try {
				image = ImageIO.read(ScreenController.class.getResource(imagePath));
			} catch(Exception e) { 
				System.out.println("Something failed");
			}
			
			// Calculate the rotation of the tile to store for drawing
			double angleInRadians = Math.toRadians(angle);
			int locationX = image.getWidth() / 2;
			int locationY = image.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);	
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			image = op.filter(image, null);
			
			images.put(imagePath, image);

		}
		
		g.drawImage(images.get(imagePath), x, y, null);
	}
	
	/*
	 * Store image
	 */
	public static void storeImage(String imagePath) {
		// Check if the image is already stored
		if(!images.containsKey(imagePath)) {
			
			BufferedImage image = null;
			
			try {
				image = ImageIO.read(ScreenController.class.getResource(imagePath));
			} catch(Exception e) { }

			images.put(imagePath, image);
		}

	}
		
	public static BufferedImage getImage(String imagePath) {
		return images.get(imagePath);
	}
}
