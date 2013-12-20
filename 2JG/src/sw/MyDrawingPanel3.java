package sw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

/**
 * Ein JPanel, mit inneren anonymen Adapterklassen.
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.3
 */
public class MyDrawingPanel3 extends JPanel {
	public final static int MAX_DRAWABLES = 10000;
	// damit die erste Linie beliebig starten kann
	private boolean gestartet;
	private Drawable[] drawables;				// Array of Line 
	private int index;							// aktueller Index des Arrays
	/**
	 * Konstruktor mit Controller-Klasse
	 * @param lc Controller
	 */
	public MyDrawingPanel3(LineController lc) {

		index = 0; 								// Wir starten bei 0
		drawables = new Drawable[MAX_DRAWABLES];// Array angelegt
		gestartet = false; 						// noch kein Mausereignis stattgefunden
		this.addMouseListener(lc);		// Externe Controller-Klasse kümmert sich um Mausereignisse
		this.addMouseMotionListener(lc);// Externe Controller-Klasse kümmert sich um Mausereignisse 
		this.setFocusable(true);		// Fokus gesetzt, damit KeyEvents ausgelöste werden können!
		this.addKeyListener(lc);		// Externe Controller-Klasse kümmert sich um KeyEvents
	}

	/*
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 			// SEHR WICHTIG!
		if (gestartet){
			for (int i = 0; i < index; i++)
				drawables[i].draw(g);		// Zeichnet alle Figuren nach
		}
	}
	/**
	 * Linie speichern und zeichnen
	 * @param l
	 */
	public void addDrawable(Drawable d){
		if (index < MAX_DRAWABLES){  		// Solange noch Platz im Array
			drawables[index] = d;			// Figur wird gespeichert
			Graphics g=getGraphics();		// Graphic-Kontext holen
			g.setColor(getForeground());	// Stiftfarbe setzen
			d.draw(g);						// Figur zeichnen
			index++;						// Index erhöhen
		}
	}
	/**
	 * Letzen Eintrag ausblenden
	 */
	public void deleteDrawable(){
		if(index>0)
			index--;
	}
	/**
	 * Einen Eintrag wiederherstellen
	 */
	public void restoreDrawable(){
		if(index<MAX_DRAWABLES-1 && drawables[index]!=null)
			index++;
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
	/**
	 * Die Liste ist leer,
	 * falls das erste Element null ist
	 * @return
	 */
	public boolean isEmtpy(){
		return(drawables[0]==null);
	}
	/**
	 * Liste leeren
	 */
	public void setEmtpy(){
		index=0;
		drawables[0]=null;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the drawables
	 */
	public Drawable[] getDrawables() {
		return drawables;
	}

	/**
	 * @param drawables the drawables to set
	 */
	public void setDrawables(Drawable[] drawables) {
		this.drawables = drawables;
	}
	
}