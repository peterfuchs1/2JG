/**
 * 
 */
package myawt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFifthPanel extends Panel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6834375535429853934L;
	public static final String[] VALUES={"gelb","weiss", "rosa","cyan"};
	public static final Color[] COLORS={Color.YELLOW,Color.WHITE, Color.PINK,Color.CYAN};
	private Label header;					// �berschrift
	private Button buttons[];				// Buttons zur Farbwahl
	/**
	 * Konstruktor
	 * @param t Text, der im Label dargestellt werden soll 
	 */
	public MyFifthPanel(String t) {
		header=new Label(t+" SEW");			// Label erstellt
		this.add(header);					// und dem Panel hinzugef�gt
		buttons=new Button[VALUES.length]; 	// Arrays f�r Buttons erstellt
		for(int i=0;i<VALUES.length;i++){
			buttons[i]=new Button(VALUES[i]); // Ein neuer Button mit Text wird erstellt
			buttons[i].addActionListener(this); // F�r Buttonereignisse anmelden 
			this.add(buttons[i]); 			// Der Button wird dem Panel hinzugef�gt
		}
	}
	/**
	 * Unsere Klasse k�mmert sich selbst um Buttonereignisse
	 * Falls ein Button gedr�ckt wurde, wird die Methode
	 * actionPerformed unserer Klasse aufgerufen 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		for(int i=0;i<VALUES.length;i++){
			//Teste welche Buttons gedr�ckt wurden
			if(ae.getSource().equals(buttons[i])){
				Color c=COLORS[i];			// W�hle die entsprechende Farbe
				header.setBackground(c);	// Setzen den Hintergrund des Textes
				this.setBackground(c);		// und Hintergrund des Panels
			}
		}
		
	}
}