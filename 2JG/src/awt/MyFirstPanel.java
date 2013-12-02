/**
 * 
 */
package awt;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFirstPanel extends Panel {
	public static final int ANZAHL_ELEMENTE=8;	// Anzahl der Elemente
	private Label labels[];					// Labels zur Darstellung des Textes
	private TextField fields[];				// Textfields zur Eingabe
	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyFirstPanel(String t) {

		/*
		 * Neues FlowLayout erstellt
		 * Die Ausrichtung ist linksb�ndig
		 */
		FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
		fl.setVgap(25);		// vertikaler Abstand 25 Pixel
		fl.setHgap(10);		// horizontaler Abstand 10 Pixel
		this.setLayout(fl);	// neuen LayoutManager zuweisen
		
		labels=new Label[ANZAHL_ELEMENTE]; // Arrays f�r Labels erstellt
		fields=new TextField[ANZAHL_ELEMENTE]; // Arrays f�r Textfields erstellt

		for(int i=0;i<ANZAHL_ELEMENTE;i++){
			labels[i]=new Label(t); // Ein neues Label mit Text wird erstellt
			this.add(labels[i]); // Das Label wird dem Panel hinzugef�gt
			fields[i]=new TextField("SEW"); // Ein Textfield mit einem Standardtext wird erstellt.
			this.add(fields[i]);		// und dem Panel hinzugef�gt
		}
	}
}
