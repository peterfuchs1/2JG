package sw;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Drawable {

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
		if(full)
			g.fillRect(startX, startY, endX-startX, endY-startY);
		else
			g.drawRect(startX, startY, endX-startX, endY-startY);
	}
}
