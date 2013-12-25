/**
 * 
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * MyPolygon definiert durch ein Polygon
 * Endkoordinate=Anfangskoordinate
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class MyPolygon extends Drawable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 13046123995638212L;
	/**
	 * Umrandung
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public MyPolygon(int startX, int startY, int endX, int endY,Color c) {
		super(startX, startY, endX, endY,c);
	}
	/**
	 * Gefülltes Polygon
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param full
	 */
	public MyPolygon(int startX, int startY, int endX, int endY,Color c, boolean full) {
		super(startX, startY, endX, endY,c,full);
	}	
	/**
	 * Zeichnet eine Line auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);		// Farbe setzen
		if(full)
			g.fillPolygon(p);
		else
			g.drawPolygon(p);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		MyPolygon d=new MyPolygon(p.xpoints[0], p.ypoints[0], p.xpoints[1], p.ypoints[1], c);
		d.setHomePosition();
		return d;
	}

}
