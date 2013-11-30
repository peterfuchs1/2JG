/**
 * 
 */
package awt;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFirstPanel extends Panel {
	private Label l;		//Label zur Darstellung des Textes
	private TextField tf;
	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyFirstPanel(String t) {
		l=new Label(t);		// Ein neues Label mit Text wird erstellt
		l.setForeground(Color.BLACK);	// Farbe für Schrift gesetzt
		this.add(l);		// Das Label wird dem Panel hinzugefügt
		tf=new TextField("SEW"); // Ein Textfield mit einem Standardtext wird erstellt.
		this.add(tf);		// und dem Panel hinzugefügt
	}
}
