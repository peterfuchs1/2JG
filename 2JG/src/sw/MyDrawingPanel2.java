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
public class MyDrawingPanel2 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1973761341931614840L;
	public final static int MAX_LINES = 10000;
	// damit die erste Linie beliebig starten kann
	private boolean gestartet;
	private Line[] lines;
	private int index;
	private int lastX = 0, lastY = 0; // Initialisierung

	/**
	 * Konstruktor meldet sich bei MouseListener, MouseMotionListener an
	 */
	public MyDrawingPanel2() {
		index = 0; // Wir starten bei 0
		lines = new Line[MAX_LINES]; // Array angelegt
		MausEreignisse me = new MausEreignisse();
		gestartet = false; // noch kein Mausereignis stattgefunden
		this.addMouseListener(me);// Unsere innere Klasse kümmert sich um
									// Mausereignisse
		this.addMouseMotionListener(me);// Unsere innere Klasse kümmert sich um
										// Mausereignisse
		this.setBackground(new Color(240, 230, 140)); 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (gestartet){
			for (int i = 0; i < index; i++)
				lines[i].draw(g);
		}
	}

	/**
	 * Klasse erweitert MouseAdapter
	 * 
	 * @author Walter Rafeiner-Magor
	 * @version 1.1
	 */
	public class MausEreignisse extends MouseAdapter {
		/**
		 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der
		 * User einen Mousebutton drueckt.
		 */
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!gestartet) {
				gestartet = true;
				merkeKoordinaten(x, y);
			}
			Graphics g = getGraphics();
			// Punkt speichern und zeichnen
			if (index < MAX_LINES){
				lines[index] = new Line(x, y, x, y,g.getColor());
				lines[index].draw(g);
				index++;
			}
			merkeKoordinaten(x, y);
		}

		/**
		 * Eine Methode des MouseMotionListener interface. Wird aufgerufen, wenn
		 * der User die Maus mit gedruecktem Button zieht.
		 */
		public void mouseDragged(MouseEvent e) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!gestartet) {
				gestartet = true;
				merkeKoordinaten(x, y);
			}
			Graphics g = getGraphics();
			// Linie speichern und zeichnen
			if (index < MAX_LINES){
				lines[index] = new Line(lastX, lastY, x, y,g.getColor());
				lines[index].draw(g);
				index++;
			}	
			merkeKoordinaten(x, y);
		}
	}

	/**
	 * Sichert die letzten Koordinaten
	 * 
	 * @param x
	 * @param y
	 */
	private void merkeKoordinaten(int x, int y) {
		lastX = x;
		lastY = y;
	}
}