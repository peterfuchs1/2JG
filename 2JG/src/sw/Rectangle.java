package sw;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5865576014296148372L;
	public Rectangle(int startX, int startY, int endX, int endY, Color c) {
		super(startX, startY, endX, endY, c);
	}
	public Rectangle(int startX, int startY, int endX, int endY, Color c, boolean full) {
		super(startX, startY, endX, endY, c,full);
	}

	/**
	 * Zeichnet ein Rechteck auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);			// Farbe setzen
		int width=(endX-startX>0)?(endX-startX):0; // Breite nicht negativ
		int heigth=(endY-startY>0)?(endY-startY):0;// Hoehe hicht negativ
		if(full)
			g.fillRect(startX, startY, width, heigth);
		else
			g.drawRect(startX, startY, width, heigth);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		Rectangle d=new Rectangle(startX, startY, endX, endY, c,full);
		d.setHomePosition();
		return d;
	}
}
