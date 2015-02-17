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
	
	/*
	 * Constructors
	 */
	public HexTile() { }
	
	public HexTile(int rotationStep) { angle = rotationStep * 60; }
	
	/*
	 * Paints the contents of the tile to the graphics object passed in
	 */
	public void paint(Graphics g, int x, int y) {
		// Draw a single tile
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource(Config.TILE_IMAGE_LOCATION + imageFilename));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "The tile could not be drawn.");
		}
		double rotationRequired = Math.toRadians(angle);
		double locationX = img.getWidth() / 2;
		double locationY = img.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		g.drawImage(op.filter(img, null), x, y, null);
	}

	public void setAngle(int angle) { this.angle = angle; }
	
	public boolean isEnchanted() { return enchanted; }
	
	public void enchant() { enchanted = true; }

	public Object getCode() { return code; }

	public Clearing getClearing(int oClearingNumber) {
		for(PathNode p: pathNodes) {
			if(p instanceof Clearing) {
				if(((Clearing)p).getNumber() == oClearingNumber) {
					return ((Clearing) p);
				}
			}
		}
		return null;
	}

	public ArrayStack<PathNode> getClearings() { return pathNodes; }
}