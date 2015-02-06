package com.magicrealm.client.ui.map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
 
public class MapScroller {
 
	private static double width = 500;
	private static double height = 500;
	
	private static MapCanvas canvas;
		
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		canvas = new MapCanvas();
		TranslateHandler translater = new TranslateHandler();
		canvas.addMouseListener(translater);
		canvas.addMouseMotionListener(translater);
		canvas.addMouseWheelListener(new ScaleHandler());
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
 
	private static class TranslateHandler implements MouseListener,
			MouseMotionListener {
		private int lastOffsetX;
		private int lastOffsetY;
 
		public void mousePressed(MouseEvent e) {
			// capture starting point
			lastOffsetX = e.getX();
			lastOffsetY = e.getY();
		}
 
		public void mouseDragged(MouseEvent e) {
			
			// new x and y are defined by current mouse location subtracted
			// by previously processed mouse location
			int newX = e.getX() - lastOffsetX;
			int newY = e.getY() - lastOffsetY;
 
			// increment last offset to last processed by drag event.
			lastOffsetX += newX;
			lastOffsetY += newY;
 
			// update the canvas locations
			canvas.translateX += newX;
			canvas.translateY += newY;
			
			// schedule a repaint.
			canvas.repaint();
		}
 
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
 
	private static class ScaleHandler implements MouseWheelListener {
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
								
	            // Get the position of the mouse with respect to 
	            //  the origin of the map (or image or whatever).
	            // Let us call these the map coordinates
	            double mouse_x = width / 2  - canvas.getX();
	            double mouse_y = height / 2 - canvas.getY();

	            double oldscale = canvas.scale;

				// make it a reasonable amount of zoom
				// .1 gives a nice slow transition
				canvas.scale += (.1 * e.getWheelRotation());
				// don't cross negative threshold.
				// also, setting scale to 0 has bad effects
				canvas.scale = Math.max(0.1, canvas.scale);

	            // Get the position of the mouse
	            // in map coordinates after scaling
	            double newx = mouse_x * (canvas.scale / oldscale);
	            double newy = mouse_y * (canvas.scale / oldscale);

	            // reverse the translation caused by scaling
	            canvas.translateX += mouse_x - newx;
	            canvas.translateY += mouse_y - newy;

								
				canvas.repaint();
			}
		}
	}
 
}
