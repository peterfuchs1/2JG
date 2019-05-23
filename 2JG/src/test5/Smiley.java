/**
 * 
 */
package test5;
import java.awt.*;
import javax.swing.*;


/**
 * @author wrafeiner
 *
 */
public class Smiley extends JPanel {
	private int status;
	private Color c;
 	public Smiley() {
		this.setStatus(0);
	}
 	/**
 	 * Zeichnet das Smiley
 	 * @param g grafische Oberflaeche
 	 */
	@Override
	public void paintComponent(Graphics g) {
		int space = 10;
		int staerke = 4;
		super.paintComponent(g);
		int height = super.getHeight()-2*space;
		int width=super.getWidth()-2*space;
		Polygon kappe=new Polygon();
		kappe.addPoint(space,2*space);
		kappe.addPoint(width+space,2*space);
		kappe.addPoint(width/2+space,space-staerke);
		kappe.addPoint(space,2*space);
		int linkesAuge=(space+width/4);
		int rechtesAuge=(space+3*width/4);
		int mundUnten= rechtesAuge-(int)(1.5*space);
		int mundLinks=  linkesAuge+staerke;
		int mundLaenge= rechtesAuge-linkesAuge-staerke;
		g.setColor(c);
		g.fillOval(space, space, width, height);

		switch(this.status) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		}
		// zeichne Kappe
		g.setColor(Color.BLACK);
		g.fillPolygon(kappe.xpoints, kappe.ypoints, kappe.npoints);
		// zeichne Augen
		g.fillOval(linkesAuge, linkesAuge, staerke,staerke);
		g.fillOval(rechtesAuge, linkesAuge, staerke, staerke);
		// zeichne Mund
		g.fillRect(mundLinks, mundUnten, mundLaenge,staerke/2);

	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * setzt status und Farbe
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
		if(status ==0) {
			this.c=Color.YELLOW;
		} else if(status==1) {
			this.c=Color.GREEN;
		}
		else {
			this.c=Color.RED;
		}
		this.repaint();
	}
	
}
