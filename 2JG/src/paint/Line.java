/**
 * 
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Linie definiert durch Anfangs-
 * und Endkoordinaten
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class Line extends Drawable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 13046123995638211L;
	/**
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Line(int startX, int startY, int endX, int endY,Color c) {
		super(startX, startY, endX, endY,c);
	}
	/**
	 * Zeichnet eine Line auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);		// Farbe setzen
		g.drawLine(startX, startY, endX, endY);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		Line d=new Line(startX, startY, endX, endY, c);
		d.setHomePosition();
		return d;
	}

}
