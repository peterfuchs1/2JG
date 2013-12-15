/**
 * 
 */
package sw;

import java.awt.Graphics;

/**
 * Linie definiert durch Anfangs-
 * und Endkoordinaten
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class Line {
	private int startX,startY,endX,endY;

	/**
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Line(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	/**
	 * Zeichnet eine Line auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.drawLine(startX, startY, endX, endY);
	}
}
