/**
 * 
 */
package sw;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Drawable definiert durch Anfangs-
 * und Endkoordinaten
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public abstract class Drawable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954192751415066519L;
	protected int startX,startY,endX,endY;
	protected Color c;
	protected boolean full=false;

	/**
	 * Konstruktor ohne Füllung
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Drawable(int startX, int startY, int endX, int endY,Color c) {
		this(startX, startY, endX, endY,c, false);
	}
	/**
	 * Konstruktor mit Füllung
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public Drawable(int startX, int startY, int endX, int endY,Color c, boolean full) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.c=c;
		this.full=full;
	}
	/**
	 * Zeichnet eine Figur auf dem Graphics-Kontext
	 * @param g
	 */
	public abstract void draw(Graphics g);
}
