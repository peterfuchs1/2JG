package paint;

import java.awt.Color;
import java.awt.Graphics;

public class RoundedRectangle extends Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6748740901241131063L;
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
		int width = p.xpoints[1]-p.xpoints[0];
		int height= p.ypoints[1]-p.ypoints[0];
		if(full)
			g.fillRoundRect(p.xpoints[0], p.ypoints[0], width,height,(int)(0.1*width),(int)(0.1*height) );
		else
			g.drawRoundRect(p.xpoints[0], p.ypoints[0], width,height,(int)(0.1*width),(int)(0.1*height) );
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		RoundedRectangle d=new RoundedRectangle(startX, startY, endX, endY, c,full);
		d.setHomePosition();
		return d;
	}
}
