package test5;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class VierGewinntGrafik extends JPanel {
	public final static Color[] farben = { Color.WHITE, Color.RED, Color.YELLOW };
	private Color[][] raster; // Raster mit allen Farb-Elementen
	/**
	 * Konstruktor
	 * @param zeilen Anzahl der Zeilen
	 * @param spalten Anzahl der Spalter
	 */
	public VierGewinntGrafik(int zeilen, int spalten) {
		this.raster = new Color[zeilen][spalten];
		// Das Array wird initialisiert mit White
		for (int i = 0; i < raster.length; ++i)
			for (int j = 0; j < raster[i].length; ++j) {
				raster[i][j] = farben[0];
			}
	}
	/**
	 * Ein Stein wird im Raster gesetzt
	 * @param zeile fuer den Stein
	 * @param spalte fuer den Stein
	 * @param spieler Spieler (1 oder 2)
	 */
	public void setStein(int zeile, int spalte, int spieler) {
		// Sicherheitshalber werden die Werte abgefragt
		// Bevor die Farbe gesetzt wird
		if (zeile>=0 && spalte>=0 &&
				zeile <= raster.length && spalte <= raster[0].length) {
			raster[zeile][spalte] = farben[spieler];
			// Anschliessend die Grafik neu zeichnen
			this.repaint();
		}
	}
	/**
	 * Zeichnet die Grafik mit den aktuellen Werten des Rasters
	 * @param g die Grafikoberflaeche
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Groesse des Containers ermitteln
		int h = super.getHeight();
		int b = super.getWidth();
		// Hintergrund blau
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, b, h);
		// Groesse der Scheibe ermitteln
		int size = b / raster[0].length;
		// Abstand zur naechsten Scheibe ermitteln
		int space = size / 4;
		for (int i = 0; i < raster.length; ++i)
			for (int j = 0; j < raster[i].length; ++j) {
				// Farbe setzen
				g.setColor(raster[i][j]);
				// Scheibe zeichnen
				g.fillOval(j * size + space, i * size + space, size / 2, size / 2);
			}
	}

}
