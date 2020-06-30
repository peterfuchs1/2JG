package listener;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class PunkteGrafik extends JPanel {

	private Punkt p;
	private Color c;

	/**
	 * @param p the p to set
	 */
	public void setPunkt(Punkt p, Color c) {
		this.p = p;
		this.c = c;
		this.repaint();
	}
	/**
	 * Zeichnet die Grafik mit den aktuellen Werten des Rasters
	 * @param g die Grafikoberflaeche
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (p!= null) {
			int zx = p.getX() - p.getD()/2;
	        int zy = p.getY() - p.getD()/2;
			g.setColor(this.c);
			g.fillOval(zx, zy, p.getD(), p.getD());
		}
	}

}
