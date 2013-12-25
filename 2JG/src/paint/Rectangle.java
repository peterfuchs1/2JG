package paint;

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
		int width = p.xpoints[1]-p.xpoints[0];
		int heigth= p.ypoints[1]-p.ypoints[0];
		width=(endX-startX>0)?(width):0; // Breite nicht negativ
		heigth=(endY-startY>0)?(heigth):0;// Hoehe hicht negativ
		if(full)
			g.fillRect(p.xpoints[0], p.ypoints[0], width, heigth);
		else
			g.drawRect(p.xpoints[0], p.ypoints[0], width, heigth);
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
