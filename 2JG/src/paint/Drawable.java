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
	private static final long serialVersionUID = -7954192751415066519L;
	protected int startX,startY,endX,endY;
	protected Polygon p;
	protected Color c;
	protected boolean full=false;
	public Drawable(Polygon p,Color c) {
		this(p.xpoints[0], p.ypoints[0], p.xpoints[p.npoints-1], p.ypoints[p.npoints-1],c, false);
	}
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
//		endX-=startX;
//		endY-=startY;
//		startX=startY=0;
	}
	/**
	 * @return the startX
	 */
	public int getStartX() {
		return p.xpoints[0];
	}
	/**
	 * @param startX the startX to set
	 */
	public void setStartX(int startX) {
		p.xpoints[0] = startX;
	}
	/**
	 * @return the startY
	 */
	public int getStartY() {
		return p.ypoints[0];
	}
	/**
	 * @param startY the startY to set
	 */
	public void setStartY(int startY) {
		p.ypoints[0]= startY;
	}
	/**
	 * @return the endX
	 */
	public int getEndX() {
		return p.xpoints[1];
	}
	/**
	 * @param endX the endX to set
	 */
	public void setEndX(int endX) {
		p.xpoints[1] = endX;
	}
	/**
	 * @return the endY
	 */
	public int getEndY() {
		return p.ypoints[1];
	}
	/**
	 * @param endY the endY to set
	 */
	public void setEndY(int endY) {
		p.ypoints[1]= endY;
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
