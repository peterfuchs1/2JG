/**
 * 
 */
package myawt;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyThirdPanel extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6087480571024800443L;
	private Label east, south, west, north;		// Labels zur Darstellung des Textes
	private TextField center;				// Textfields zur Eingabe
	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyThirdPanel(String t) {

		/*
		 * Neues BorderLayout erstellt
		 */
		BorderLayout bl=new BorderLayout();
		this.setLayout(bl);	// neuen LayoutManager zuweisen
		// Elemente erstellen
		east=new Label("East"); 
		west=new Label("West");
		north=new Label("North");
		south=new Label("South");
		center=new TextField(t+" SEW");
		// Elemente austrichten
		north.setAlignment(Label.CENTER);
		south.setAlignment(Label.CENTER);
		east.setAlignment(Label.RIGHT);
		// Elemente werden im Container abgelegt
		this.add(east,BorderLayout.EAST);
		this.add(west,BorderLayout.WEST);
		this.add(north,BorderLayout.NORTH);
		this.add(south,BorderLayout.SOUTH);
		this.add(center);
	}
}
