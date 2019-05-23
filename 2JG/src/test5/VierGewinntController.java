package test5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class VierGewinntController implements ActionListener {
	private VierGewinntGrafik grafik; // My Grafik
	private VierGewinntLayout myPanel;
	private VierGewinnt myModel; // My Model for this game
	private int zeilen; // Anzahl Zeilen
	private int spalten; // Anzahl Spalten
	public static String titel = "VierGewinnt"; // Titel des Spiels
	public static int height = 530; // Hoehe des Frames
	public static int width = 580; // Breite des Frames

	/**
	 * Konstruktor erstellt die Objekte nach MVC
	 */
	public VierGewinntController(int zeilen, int spalten) {
		this.zeilen = zeilen;
		this.spalten = spalten;
		myModel = new VierGewinnt(zeilen, spalten);
		grafik = new VierGewinntGrafik(zeilen, spalten);
		myPanel = new VierGewinntLayout(this, grafik, zeilen, spalten);
		new MyFrame(myPanel, titel, width, height);
	}

	/**
	 * Alle Events werden behandelt
	 * 
	 * @param e eingetretenes ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals("Neu")) {
			neuesSpiel();
		}
		else {
			spielAuswerten(ac);
		}
	}
	/**
	 * Neues Spiel initialisieren
	 */
	private void neuesSpiel() {
		// Neue Grafik erstellen
		this.grafik = new VierGewinntGrafik(this.zeilen, this.spalten);
		// Grafik einbinden
		myPanel.setGrafik(grafik);
		// Model initialisieren
		this.myModel.init();
	}
	/**
	 * Spiel wird auf Basis des gedrueckten Buttons ausgewertet
	 * @param ac Button als String 
	 */
	private void spielAuswerten(String ac) {
		// Aktiven Spieler holen
		int spieler = myModel.getAktiverSpieler();
		// Button auswerten
		int spalte = Integer.parseInt(ac)-1;
		// Freie Zeile finden
		int zeile = myModel.spielerWahl(spalte);
		// Neuen Stein setzen
		grafik.setStein(zeile, spalte, spieler);
		// Gewinnstatus abfragen
		int sieger = myModel.spielerGewonnen();
		String status;
		boolean gewinn=false;
		if (sieger > 0) {
			// Hurra, gewonnen!
			gewinn=true;
			status = setText(spieler, gewinn);
			myPanel.setStatus(status);
			// Spalten sperren
			myPanel.spaltenEntsperren(false);
		} else {
			// Spieler wechseln
			myModel.naechsterSpieler();
			spieler = myModel.getAktiverSpieler();
			// Hintergrund neu setzen
			myPanel.setBackground(spieler);
			// Spielerhinweis ausgeben
			status = setText(spieler, gewinn);
			myPanel.setStatus(status);
		}
		
	}
	/**
	 * Erstellt passenden Spielerhinweis
	 * @param spieler welcher an der Reihe ist
	 * @param gewinn Hat er schon gewonnen?
	 * @return Statustext zur Ausgabe 
	 */
	public String setText(int spieler, boolean gewinn) {
		String farbe = (spieler == 1) ? "(rot)" : "(gelb)";
		String t = "Spieler " + spieler + " " + farbe;
		if (gewinn)
			t += " hat GEWONNEN!";
		else
			t += ": Spalte wählen";
		return t;
	}
	/**
	 * Start des Spiels
	 * @param args Commandline Argumente
	 */
	public static void main(String[] args) {
		new VierGewinntController(6,7);
	}

}
