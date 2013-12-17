package sw;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Drawable {

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
		if(full)
			g.fillOval(startX, startY, endX-startX, endY-startY);
		else
			g.drawOval(startX, startY, endX-startX, endY-startY);
	}
}
