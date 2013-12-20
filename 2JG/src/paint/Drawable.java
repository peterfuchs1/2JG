/**
 * 
 */
package paint;

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
	/**
	 * Erzeugt eine Kopie 
	 */
	public abstract Drawable clone();
	/**
	 * Element wird auf Position (0/0) gesetzt
	 */
	public void setHomePosition(){
		endX-=startX;
		endY-=startY;
		startX=startY=0;
	}
	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}
	/**
	 * @param startX the startX to set
	 */
	public void setStartX(int startX) {
		this.startX = startX;
	}
	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}
	/**
	 * @param startY the startY to set
	 */
	public void setStartY(int startY) {
		this.startY = startY;
	}
	/**
	 * @return the endX
	 */
	public int getEndX() {
		return endX;
	}
	/**
	 * @param endX the endX to set
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}
	/**
	 * @return the endY
	 */
	public int getEndY() {
		return endY;
	}
	/**
	 * @param endY the endY to set
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}
	/**
	 * @return the c
	 */
	public Color getColor() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setColor(Color c) {
		this.c = c;
	}
	
}
