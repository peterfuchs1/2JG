package test5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ItalienischController implements ActionListener {
	private ItalienischLayout myPanel;				/* My JPanel              */
	private Italienisch myModel; 					/* My Model for this game */
	public static String titel = "Vokabeltrainer";  /* Titel des Spiels       */
	public static int height = 280; 				/* Hohe des Frames        */
	public static int width = 580; 					/* Breite des Frames      */

	/**
	 * Konstruktor erstellt die Objekte nach MVC
	 */
	public ItalienischController() {
		myModel = new Italienisch();
		myPanel = new ItalienischLayout(this, myModel);
		new MyFrame(myPanel, titel, width, height);
		weiter();
	}

	/**
	 * Alle Events werden behandelt
	 * 
	 * @param e eingetretenes ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		switch (ac) {
		case "Neu":
			myModel.init();
			myPanel.init();
			break;
		case "Weiter": weiter();
			break;
		default:
			/* gedrueckter Button als int */
			int gewaehlt = Integer.parseInt(ac);
			// Welche Begriff war zu erraten?
			String gesucht = myPanel.getGesucht();
			// Welches Angebot war nun richtig
			int korrekterBegriff = myModel.vergleich(gesucht, gewaehlt);
			// Hintergrund des korrekten Begriffes einfaerben
			myPanel.setBackgroundKorrekt(korrekterBegriff);
		}
		myPanel.setVersuche(myModel.getVersuche());
		myPanel.setKorrekt(myModel.getKorrekt());
	}
	/**
	 * Es wurde die Taste Weiter gedrueckt
	 */
	public void weiter() {
		// Neue Begriffe holen
		String[] begriffe= myModel.getAufgabe();
		int versuche=myModel.getVersuche();
		// Versuche aktualisieren
		myPanel.setVersuche(versuche);
		// neue Begriffe setzen
		myPanel.setBegriffe(begriffe);
	}
	
	/**
	 * Start der Uebung
	 * @param args Commandline Argumente
	 */
	public static void main(String[] args) {
		new ItalienischController();
	}
}
