package com.magicrealm.common.model.hextile;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import ods.ArrayStack;

import com.magicrealm.common.Config;
import com.magicrealm.common.model.path.Clearing;
import com.magicrealm.common.model.path.PathNode;

public abstract class HexTile {

	/*
	 * Private/protected members
	 */
	private int angle = 0;	
	protected String imageFilename = "caves1.gif";
	protected String code = null;
	protected boolean enchanted = false;
	protected ArrayStack<PathNode> pathNodes = new ArrayStack<PathNode>(PathNode.class);
	protected ArrayStack<PathNode> enchantedPathNodes = new ArrayStack<PathNode>(PathNode.class);
	protected BufferedImage tileImage = null;

	private double angleInRadians = 0;
	private double locationX, locationY;
	private AffineTransformOp op = null;
	private AffineTransform tx;
	private BufferedImage filteredImage = null;
	
	/*
	 * Constructors
	 */
	public HexTile(int rotationStep, String filename) {

		imageFilename = filename;
		angle = rotationStep * 60;
		try {
			tileImage = ImageIO.read(getClass().getResource(Config.TILE_IMAGE_LOCATION + imageFilename));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "The tile could not be drawn.");
		}
		
		// Calculate the rotation of the tile to store for drawing
		angleInRadians = Math.toRadians(angle);
		locationX = tileImage.getWidth() / 2;
		locationY = tileImage.getHeight() / 2;
		tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);	
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		filteredImage = op.filter(tileImage, null);
	}
	
	/*
	 * Paints the contents of the tile to the graphics object passed in
	 */
	public void paint(Graphics g, int x, int y) {

		// Draw a single tile
		g.drawImage(filteredImage, x, y, null);
	}

	
	
	/*
	 * Getters and setters
	 */
	public void setAngle(int angle) { this.angle = angle; }
	
	public boolean isEnchanted() { return enchanted; }
	
	public void enchant() { enchanted = true; }

	public Object getCode() { return code; }

	public Clearing getClearing(int oClearingNumber) {
		for(PathNode p: (enchanted ? enchantedPathNodes : pathNodes)) {
			if(p instanceof Clearing) {
				if(((Clearing)p).getNumber() == oClearingNumber) {
					return ((Clearing) p);
				}
			}
		}
		return null;
	}

	public ArrayStack<PathNode> getClearings() { return (enchanted ? enchantedPathNodes : pathNodes); }

	public int getAngle() { return angle; }
}