package test5;

import java.awt.*;
import javax.swing.*;

/**
 * Panel Rechentrainer
 *  * 
 * @author Walter Rafeiner-Magor
 * @version 1.0 
 * 
 */
public class VierGewinntLayout extends JPanel {
	private static final long serialVersionUID = 4581784888223628483L;
	public static final Color[] farben= {Color.RED,Color.YELLOW};
	private JButton[] bSpalten;
	private JButton bNeu;
	private JLabel status;
	private VierGewinntGrafik grafik;
	private JPanel top;
	private int spalten;
	private int zeilen;
	
	/**
	 * Standard Konstruktor setzt alle Komponenten ins Panel
	 */
	public VierGewinntLayout(VierGewinntController c,  VierGewinntGrafik g, int zeilen, int spalten) {
		this.zeilen=zeilen;
		this.spalten=spalten;
		this.setLayout(new BorderLayout());
		bSpalten=new JButton[spalten];
		top=new JPanel(new GridLayout(1,spalten,30,30));
		// Zusätzlicher Abstand oben, links, unten und rechts
		top.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		this.grafik=g;
		JPanel bottom=new JPanel();

		/*************** start top **********************/
		for(int i=1;i<=spalten;++i) {
			bSpalten[i-1]=new JButton(""+i);
			bSpalten[i-1].addActionListener(c);
			top.add(bSpalten[i-1]);
		}
		/*************** top ready **********************/
		
		/*************** start end ********************/
		status=new JLabel("Spieler 1 (rot) Spalte wählen");
		
		bottom.add(status);
		bNeu=new JButton("Neu");
		bNeu.addActionListener(c);
		bottom.add(bNeu);
		/*************** end ready ********************/

		/*************** start this **********************/
		this.add(top,BorderLayout.PAGE_START);
		this.add(grafik,BorderLayout.CENTER);
		this.add(bottom,BorderLayout.PAGE_END);
		/*************** this ready **********************/
		this.init(); // Spieldarstellung initialisieren
	}

	/**
	 * @param grafik the grafik to set
	 */
	public void setGrafik(VierGewinntGrafik grafik) {
		// Entferne den Container aus dem Center
		BorderLayout layout = (BorderLayout)this.getLayout();
		this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		
		this.grafik = grafik;
		// Speichere die neue Grafik im Center
		this.add(grafik,BorderLayout.CENTER);
		this.validate(); // Container wurde geaendert!
		this.init(); // Spieldarstellung initialisieren
	}
	/**
	 * Alle Spalten sperren bzw. entsperren
	 */
	public void spaltenEntsperren(boolean sperre) {
		for(int i=0;i<bSpalten.length;++i) {
			bSpalten[i].setEnabled(sperre);
		}
	}
	/**
	 * Statustext wird gesetzt
	 * @param s Text
	 */
	public void setStatus(String s) {
		this.status.setText(s);
	}
	/**
	 * Hintergrundfarbe wird gesetzt
	 * @param spieler als int
	 */
	public void setBackground(int spieler) {
		this.top.setBackground(farben[spieler-1]);
	}
	/**
	 * Spieldarstellung initialisieren 
	 */
	public void init() {
		this.spaltenEntsperren(true);
		top.setBackground(Color.RED);
		this.setStatus("Spieler 1 (rot) Spalte wählen");
	}
}
