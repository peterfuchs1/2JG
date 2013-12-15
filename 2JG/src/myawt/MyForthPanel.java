/**
 * 
 */
package myawt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.BoxLayout;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyForthPanel extends Panel {
	public static final int ANZAHL_ELEMENTE=8;	// Anzahl der Elemente
	private Label labels[];					// Labels zur Darstellung des Textes
	private TextField fields[];				// Textfields zur Eingabe
	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyForthPanel(String t) {

		/*
		 * Neues GridLayout erstellt
		 * 8 Zeilen, 2 Spalten
		 * 5 Pixel Abstand horizontal
		 * 5 Pixel Abstand vertikal
		 */
		GridLayout bl=new GridLayout(8,2,5,5);
		this.setLayout(bl);	// neuen LayoutManager zuweisen
		labels=new Label[ANZAHL_ELEMENTE]; // Arrays für Labels erstellt
		fields=new TextField[ANZAHL_ELEMENTE]; // Arrays für Textfields erstellt

		for(int i=0;i<ANZAHL_ELEMENTE;i++){
			labels[i]=new Label(t); // Ein neues Label mit Text wird erstellt
			this.add(labels[i]); // Das Label wird dem Panel hinzugefügt
			fields[i]=new TextField("SEW"); // Textfield mit Standardtext erstellt
			this.add(fields[i]);		// und dem Panel hinzugefügt
		}
	}
}