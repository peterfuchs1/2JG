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
public abstract class Drawable implements Element,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954192751415066518L;
	protected Polygon p;
	protected Color c;
	protected boolean full=false;
	/**
	 * Konstruktor ohne Füllung
	 * @param startX Startkoordinate x
	 * @param startY Startkoordinate y
	 * @param endX Endkoordinate x
	 * @param endY Endkoordinate y
	 * @param c Farbe
	 */
	public Drawable(int startX, int startY, int endX, int endY,Color c) {
		this(startX, startY, endX, endY,c, false);
	}
	/**
	 * Konstruktor mit Füllung
	 * @param startX Startkoordinate x
	 * @param startY Startkoordinate y
	 * @param endX Endkoordinate x
	 * @param endY Endkoordinate y
	 * @param c Farbe
	 * @param 
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
	 * @param g Grafics-Kontext
	 */
	public abstract void draw(Graphics g);
	/**
	 * Erzeugt eine Kopie vom eigenen Objekt
	 */
	public abstract Drawable clone();
	/**
	 * Einen neuen Punkt hinzufügen
	 * @param x x-Koordinate
	 * @param y y-Koordinate
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
		java.awt.Rectangle r=p.getBounds();
		p.translate(-r.x, -r.y);
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
