/**
 * 
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
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
	private static final long serialVersionUID = -7954192751415066518L;
	protected Polygon p;
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
		this.c=c;
		p=new Polygon();
		p.addPoint(startX, startY);
		p.addPoint(endX, endY);
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
	 * Einen neuen Punkt hinzufügen
	 * @param x
	 * @param y
	 */
	public void addPoint(int x, int y){
		p.addPoint(x, y);
	}
	public void removeLastPoint(){
		p.npoints--;
	}
	/**
	 * Element wird auf Position (0/0) gesetzt
	 */
	public void setHomePosition(){
		p.translate(-p.xpoints[0], -p.ypoints[0]);
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
