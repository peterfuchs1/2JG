package sw;

import java.awt.Color;
import java.awt.Graphics;

public class RoundedRectangle extends Drawable {

	public RoundedRectangle(int startX, int startY, int endX, int endY, Color c) {
		super(startX, startY, endX, endY, c);
	}
	public RoundedRectangle(int startX, int startY, int endX, int endY, Color c, boolean full) {
		super(startX, startY, endX, endY, c,full);
	}

	/**
	 * Zeichnet ein Rechteck mit abgerundeten Ecken 
	 * auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);// Farbe setzen	
		int width = endX-startX;
		int height= endY-startY;
		if(full)
			g.fillRoundRect(startX, startY, width,height,(int)(0.1*width),(int)(0.1*height) );
		else
			g.drawRoundRect(startX, startY, width,height,(int)(0.1*width),(int)(0.1*height) );
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		int width=endX-startX;
		int heigth=endY-startY;
		return new RoundedRectangle(0, 0, width, heigth, c,full);
	}
}
