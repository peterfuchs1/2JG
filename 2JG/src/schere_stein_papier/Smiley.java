/**
 * 
 */
package schere_stein_papier;

import java.awt.*;
import javax.swing.JPanel;

/**
 * Zeichnet das Smiley rot gruen oder gelb
 * 
 * @author Daniel May
 * @version 1.0
 * 
 */
public class Smiley extends JPanel {

	private static final long serialVersionUID = 1L;
	private int zustand;

	/**
	 * STD Konstruktor
	 * 
	 */
	public Smiley() {
		this(0);
	}
	public Smiley(int z) {
		zustand = z;
	}

	/**
	 * @return the zustand
	 */
	public int getZustand() {
		return zustand;
	}

	/**
	 * @param zustand
	 *            the zustand to set
	 */
	public void setZustand(int zustand) {
		this.zustand = zustand;
		repaint();
	}

	/**
	 * Zeichnet entweder ein lachendes neutrales oder trauriges smiley
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size, x, y;
		if (this.getHeight() < this.getWidth()) {
			size = (int) (this.getHeight() / 1.5);
		} else {
			size = (int) (this.getWidth() / 1.5);
		}
		x = (int) ((this.getWidth() / 2.0) - size / 2.0);
		y = (int) ((this.getHeight() / 2.0) - size / 2.0);
		int eyesize = (int) (size / 8.0);
		int eyex = (int) (x + size * 0.3 - eyesize / 2.0);
		int eyey = (int) (y + size * 0.4 - eyesize / 2.0);
		int eyex2 = (int) (x + size * 0.7 - eyesize / 2.0);
		int[] xpoints = {x, x + size, (int) (x + size / 2.0)};
		int[] ypoints = {(int) (y + size / 5.0), (int) (y + size / 5.0),
				(int) (y - size / 10.0)};
		Polygon hat = new Polygon(xpoints, ypoints, 3);
		
		if (zustand >0) {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, size, size);
			g.setColor(Color.BLACK);
			g.fillOval(eyex, eyey, eyesize, eyesize);
			g.fillOval(eyex2, eyey, eyesize, eyesize);
			g.fillPolygon(hat);
			g.fillArc((int) (x + size / 5.0), (int) (y + size * 0.5),
					(int) (size * 0.6), (int) (size * 0.4), 0, -180);
		} else if (zustand == 0) {
			g.setColor(Color.YELLOW);
			g.fillOval(x, y, size, size);
			g.setColor(Color.BLACK);
			g.fillOval(eyex, eyey, eyesize, eyesize);
			g.fillOval(eyex2, eyey, eyesize, eyesize);
			g.fillPolygon(hat);
			g.fillRect(eyex, (int) (y + size * 0.75), eyex2 + eyesize - eyex,
					(int) (eyesize / 2.0));
		} else {
			g.setColor(Color.RED);
			g.fillOval(x, y, size, size);
			g.setColor(Color.BLACK);
			g.fillOval(eyex, eyey, eyesize, eyesize);
			g.fillOval(eyex2, eyey, eyesize, eyesize);
			g.fillPolygon(hat);
			g.fillArc((int) (x + size / 5.0), (int) (y + size * 0.6),
					(int) (size * 0.6), (int) (size * 0.4), 0, 180);
		}
	}
}
