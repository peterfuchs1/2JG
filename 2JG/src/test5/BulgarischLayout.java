package test5;

import javax.swing.*;
import java.awt.*;
/**
 * View-Komponente fuer den Vokabeltrainer
 * @author wrafeiner
 * @version 1.0
 */
public class BulgarischLayout extends JPanel {

	private JLabel lGesucht;		/* zur Uebersetzung gesuchter Begriff */
	private JLabel[] lAngebote;		/* 3 Angebote fuer die Uebersetzung */
	private JButton[] buttons; 		/* 3 Buttons zur Auswahl der Antwort */
	private JLabel lVersuche; 		/* Anzahl der Versuche insgesamt */
	private JLabel lKorrekt;		/* Anzahl der korrekten Antworten */
	private JLabel lFalsch; 		/* Anzahl der falschen Antworten - wird nicht verwendet */
	private JLabel lMsg; 			/* Die Information im PAGE_END Bereich */
	private Bulgarisch myModel; 	/* das Model */
	/**
	 * Konstruktor der View-Komponente
	 * @param c	Controller
	 * @param myModel Model
	 */
	public BulgarischLayout(BulgarischController c, Bulgarisch myModel) {
		this.myModel = myModel;
		// Wir benoetigen ein BorderLayout
		this.setLayout(new BorderLayout());
		// Fuer jeden Bereich ein JPanel erstellen
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		JPanel bottom = new JPanel();
		/**************** top start *************************/
		// Da wir mehr als eine Komponente anzeigen, wird ein JPanel benoetigt!
		// Alle Komponenten kommen vorerst in das neue JPanel!
		JPanel oben=new JPanel();
		JLabel hinweis=new JLabel("Der bulgarische Begriff lautet: ");
		oben.add(hinweis);
		lGesucht = new JLabel("Gesuchter Begriff");
		// Damit der Hintergrund auch gezeichnet wird!
		lGesucht.setOpaque(true);
		lGesucht.setBackground(Color.WHITE);
		oben.add(lGesucht);
		JLabel frage=new JLabel(" Wie lautet die korrekte Uebersetzung?");
		oben.add(frage);
		// Am Ende muss noch das Panel OBEN dem TOP hinzugefuegt werden!!!
		top.add(oben);
		/**************** top ready *************************/
		/**************** center start *************************/
		// Da wir mehr als eine Komponente anzeigen, wird ein JPanel benoetigt!
		// Alle Komponenten kommen vorerst in das neue JPanel!
		JPanel felder = new JPanel(new GridLayout(4, 3, 5, 5));
		// Zeile 1
		// Label-Array erstellen
		lAngebote = new JLabel[3];
		for (int i = 0; i < lAngebote.length; ++i) {
			// Neues Label erstellen
			lAngebote[i] = new JLabel(" ");
			// Damit der Hintergrund auch gezeichnet wird!
			lAngebote[i].setOpaque(true);
			felder.add(lAngebote[i]);
		}
		// Zeile 2
		// Button-Array erstellen
		buttons = new JButton[3];
		for (int i = 0; i < buttons.length; ++i) {
			buttons[i] = new JButton("" + (i + 1));
			buttons[i].addActionListener(c);
			felder.add(buttons[i]);
		}
		// Zeile 3
		JLabel lBVersuche=new JLabel("Versuche:");
		lBVersuche.setHorizontalAlignment(JLabel.CENTER);
		felder.add(lBVersuche);
		JLabel lBKorrekt=new JLabel("Korrekt:");
		lBKorrekt.setHorizontalAlignment(JLabel.CENTER);
		felder.add(lBKorrekt);
		// Bleibt LEER, muss aber an der Stelle
		// hinzugefuegt werden!
		JLabel lBFalsch=new JLabel("");
		felder.add(lBFalsch);
		// Zeile 4
		lVersuche = new JLabel("0");
		lVersuche.setHorizontalAlignment(JLabel.CENTER);
		felder.add(lVersuche);
		lKorrekt = new JLabel("0");
		lKorrekt.setHorizontalAlignment(JLabel.CENTER);
		felder.add(lKorrekt);
		// Bleibt LEER!!
		// muesste eigentlich nicht mehr hinzugefuegt werden
		lFalsch = new JLabel("");
		felder.add(lFalsch);
		// Am Ende muss noch das Panel FELDER dem CENTER hinzugefuegt werden!!!
		center.add(felder);
		/**************** center ready *************************/
		/**************** bottom start *************************/
		// Da wir mehr als eine Komponente anzeigen, wird ein JPanel benoetigt!
		// Alle Komponenten kommen vorerst in das neue JPanel!
		JPanel ausgabe = new JPanel();
		JButton neu = new JButton("Neu");
		neu.addActionListener(c);
		ausgabe.add(neu);
		JButton weiter = new JButton("Weiter");
		weiter.addActionListener(c);
		ausgabe.add(weiter);
		lMsg = new JLabel("Bitte die korrekte Auswahl klicken - oder neu");
		ausgabe.add(lMsg);
		// Am Ende muss noch das Panel AUSGABE dem BOTTOM hinzugefuegt werden!!!
		bottom.add(ausgabe);
		/**************** bottom ready *************************/
		// Nun bauen wir alle Teile zusammen
		this.add(top,BorderLayout.PAGE_START);
		this.add(center,BorderLayout.CENTER);
		this.add(bottom,BorderLayout.PAGE_END);
		// FERTIG!!
	}
	/**
	 * Welcher Begriff war zu erraten
	 * @return gesuchter Begriff
	 */
	public String getGesucht() {
		return this.lGesucht.getText();
	}
	/**
	 * Der HIntergrund der korrekten Antwort wird eingefaerbt
	 * @param i Loesung [1,3]
	 */
	public void setBackgroundKorrekt(int i) {
		this.lAngebote[i-1].setBackground(Color.GREEN);
	}
	/**
	 * Die Anzeige der Versuche wird aktualisiert
	 * @param versuche als int
	 */
	public void setVersuche(int versuche) {
		this.lVersuche.setText("" + versuche);

	}
	/**
	 * Die Anzeige der korrekten Antworten wird aktualisiert
	 * @param korrekt als int
	 */
	public void setKorrekt(int korrekt) {
		this.lKorrekt.setText("" + korrekt);
	}
	/**
	 * Die Darstellung wird initialisiert
	 * und die ersten Begriffe werden geladen und angezeigt
	 */
	public void init() {
		String[] begriffe = myModel.getAufgabe();
		this.setBegriffe(begriffe);
		this.lVersuche.setText("0");
		this.lKorrekt.setText("0");
	}
	/**
	 * geuchter Begriff und Angebote werden angezeigt
	 * @param begriffe ein String-Array Index 0 enthaelt den gesuchten Begriff
	 */
	public void setBegriffe(String[] begriffe) {
		this.lGesucht.setText(begriffe[0]);
		for (int i = 0; i < lAngebote.length; ++i) {
			this.lAngebote[i].setText(begriffe[i+1]);
			this.lAngebote[i].setBackground(Color.YELLOW);
		}
		this.lMsg.setText("Bitte die korrekte Auswahl klicken, danach weiter oder neu");
	}

}
