/**
 * 
 */
package awt;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFirstPanel extends Panel {
	private Label l;		//Label zur Darstellung des Textes

	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyFirstPanel(String t) {
		l=new Label(t);		// Ein neues Label mit Text wird erstellt
		l.setForeground(Color.BLACK);	// Farbe für Schrift gesetzt
		l.setBackground(Color.WHITE);	// Farbe für Hintergrund gesetzt
		this.add(l);		// Das Label wird dem Panel hinzugefügt
	}
}
