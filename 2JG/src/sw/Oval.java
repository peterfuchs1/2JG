package sw;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851288438008701853L;
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
		int width=(endX-startX>0)?(endX-startX):0; // Breite nicht negativ
		int heigth=(endY-startY>0)?(endY-startY):0;// Hoehe hicht negativ
		if(full)
			g.fillOval(startX, startY, width, heigth);
		else
			g.drawOval(startX, startY, width, heigth);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		Oval d=new Oval(startX, startY, endX, endY, c,full);
		d.setHomePosition();
		return d;
	}
}
