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
	private Drawable[] drawables;				// Array of Line 
	private int index;					// aktueller Index des Arrays
	/**
	 * Konstruktor mit Controller-Klasse
	 * @param lc Controller
	 */
	public MyDrawingPanel3(LineController lc) {

		index = 0; 						// Wir starten bei 0
		drawables = new Drawable[MAX_LINES]; 	// Array angelegt
		gestartet = false; 				// noch kein Mausereignis stattgefunden
		this.addMouseListener(lc);// Externe Controller-Klasse kümmert sich um Mausereignisse
		this.addMouseMotionListener(lc);// Externe Controller-Klasse kümmert sich um Mausereignisse 
	}

	/*
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 		// SEHR WICHTIG!
		if (gestartet){
			for (int i = 0; i < index; i++)
				drawables[i].draw(g);		// Zeichnet alle Linien nach
		}
	}
	/**
	 * Linie speichern und zeichnen
	 * @param l
	 */
	public void addDrawable(Drawable d){
		if (index < MAX_LINES){  			// Solange noch Platz im Array
			drawables[index] = d;				// Line wird gespeichert
			Graphics g=getGraphics();		
			g.setColor(getForeground());	// Stiftfarbe setzen
			d.draw(g);						// Linie zeichnen
			index++;						// Index erhöhen
		}
	}
	public void deleteLine(){
		if(index>0)
			index--;
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

	public void draw(Drawable d) {
		Graphics g=getGraphics();		
		g.setColor(getForeground());	// Stiftfarbe setzen
		d.draw(g);						// Linie zeichnen
	}
}