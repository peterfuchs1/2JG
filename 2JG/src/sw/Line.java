/**
 * 
 */
package sw;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Linie definiert durch Anfangs-
 * und Endkoordinaten
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class Line {
	private int startX,startY,endX,endY;
	private Color c;
	private static boolean COLOR_AVAILABLE=false;

	/**
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Line(int startX, int startY, int endX, int endY) {
		this(startX,startY,endX,endY,null);
	}
	/**
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Line(int startX, int startY, int endX, int endY,Color c) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.c=c;
		if(c!=null)					// Falls Farbe vorhanden
			Line.COLOR_AVAILABLE=true;
	}
	/**
	 * Zeichnet eine Line auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		if( Line.COLOR_AVAILABLE)	// Falls Farbe vorhanden
			g.setColor(c);			// Farbe setzen
		g.drawLine(startX, startY, endX, endY);
	}
}
