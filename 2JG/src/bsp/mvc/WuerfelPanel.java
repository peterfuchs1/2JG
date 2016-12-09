package bsp.mvc;

import javax.swing.*;

import java.awt.*;

public class WuerfelPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7842200755185789394L;
	private JLabel[] lWuerfel;
	private JButton[] bWuerfel;
	private JLabel lStatus;
	private JButton bNeu;
	/**
	 * Übernimmt den Controller und initialisiert das Layout
	 * @param wControl der Controller für diese GUI
	 */
	public WuerfelPanel(WuerfelControl wControl) {
		this.setLayout(new BorderLayout());
		
		JPanel main = new JPanel(new GridLayout(2,3));
		lWuerfel = new JLabel[3];
		for(int i = 0; i < lWuerfel.length; i++) {
			lWuerfel[i] = new JLabel("", SwingConstants.CENTER);
			main.add(lWuerfel[i]);
		}
		
		bWuerfel = new JButton[lWuerfel.length];
		for(int i = 0; i < bWuerfel.length; i++) {
			bWuerfel[i] = new JButton("Spieler " + (i+1));
			main.add(bWuerfel[i]);
			bWuerfel[i].addActionListener(wControl);
		}
		this.add(main);
		
		JPanel unten = new JPanel(new FlowLayout());
		lStatus = new JLabel("Zum Würfeln entspr. Button klicken!");
		unten.add(lStatus);
		
		bNeu = new JButton("Neues Spiel");
		bNeu.setActionCommand("neu");
		bNeu.addActionListener(wControl);
		unten.add(bNeu);
		
		this.add(unten, BorderLayout.PAGE_END);
	}
	
	/**
	 * Gibt die Anzahl an Spielern in der GUI zurücl
	 * @return
	 */
	public int getSpielerzahl() {
		return bWuerfel.length;
	}
	
	/**
	 * Setzt das Ergebnis für einen bestimmten Spieler im entsprechenden
	 * Label
	 * @param spielerNr der Index des betreffenden Spielers
	 * @param ergebnis das Würfelergebnis, das im Label angezeigt werden soll
	 */
	public void setErgebnis(int spielerNr, int ergebnis) {
		if(spielerNr >= 0 && spielerNr < lWuerfel.length) {
			lWuerfel[spielerNr].setText(String.valueOf(ergebnis));
		}
		this.disable(spielerNr);
	}
	
	/**
	 * Deaktiviert den Button für den Spieler mit dem entsprechenden Index
	 * @param spielerNr der Index des Spieler, dessen Button deaktiviert werden
	 * 		muss
	 */
	public void disable(int spielerNr){
		if(spielerNr >= 0 && spielerNr < lWuerfel.length) {
			bWuerfel[spielerNr].setEnabled(false);
		}
	}

	/**
	 * Aktiviert alle Buttons und löscht die Labels für das WürfelErgebnis
	 */
	public void reset() {
		for(int i = 0; i < lWuerfel.length; i++) {
			lWuerfel[i].setText("");
			bWuerfel[i].setEnabled(true);
		}
		lStatus.setText("Zum Würfeln entspr. Button klicken!");
	}
	
	/**
	 * Setzt den Text für das Status-Label
	 * @param text der neue Text für das Satus-Label
	 */
	public void setStatus(String text) {
		lStatus.setText(text);
	}
}
