package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851288438008701854L;
	public Oval(int startX, int startY, int endX, int endY, Color c) {
		super(startX, startY, endX, endY, c);
	}
	public Oval(int startX, int startY, int endX, int endY, Color c, boolean full) {
		super(startX, startY, endX, endY, c,full);
	}
	/**
	 * Zeichnet eine Ellipse auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);			// Farbe setzen
		int width = p.xpoints[1]-p.xpoints[0];
		int heigth= p.ypoints[1]-p.ypoints[0];
		width=(width>0)?(width):0; // Breite nicht negativ
		heigth=(width>0)?(heigth):0;// Hoehe hicht negativ
		if(full)
			g.fillOval(p.xpoints[0], p.ypoints[0], width, heigth);
		else
			g.drawOval(p.xpoints[0], p.ypoints[0], width, heigth);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		Oval d=new Oval(p.xpoints[0], p.ypoints[0], p.xpoints[1], p.ypoints[1], c,full);
		d.setHomePosition();
		return d;
	}
}
