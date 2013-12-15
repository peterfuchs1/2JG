package sw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

/**
 * Ein JPanel, mit inneren anonymen Adapterklassen.
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class MyDrawingPanel3 extends JPanel {
	public final static int MAX_LINES = 10000;
	// damit die erste Linie beliebig starten kann
	private boolean gestartet;
	private Line[] lines;
	private int index;
	

	/**
	 * Konstruktor meldet sich bei MouseListener, MouseMotionListener an
	 */
	public MyDrawingPanel3(LineController lc) {
		index = 0; // Wir starten bei 0
		lines = new Line[MAX_LINES]; // Array angelegt
		gestartet = false; // noch kein Mausereignis stattgefunden
		this.addMouseListener(lc);// Unsere innere Klasse kümmert sich um
									// Mausereignisse
		this.addMouseMotionListener(lc);// Unsere innere Klasse kümmert sich um
										// Mausereignisse 
	}
	public void setColor(Color c){
		getGraphics().setColor(c);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		if (gestartet){
			for (int i = 0; i < index; i++)
				lines[i].draw(g);
		}
	}
	/**
	 * Linie speichern und zeichnen
	 * @param l
	 */
	public void addLine(Line l){
		if (index < MAX_LINES){
			lines[index] = l;
			l.draw(getGraphics());
			index++;
		}
	}

	/**
	 * @return the gestartet
	 */
	public boolean isGestartet() {
		return gestartet;
	}

	/**
	 * @param gestartet the gestartet to set
	 */
	public void setGestartet(boolean gestartet) {
		this.gestartet = gestartet;
	}

	
}