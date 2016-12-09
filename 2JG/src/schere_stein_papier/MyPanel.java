package schere_stein_papier;

import java.awt.*;
import javax.swing.*;

/**
 * Panel fuer Schere Stein Papier Spiel (mit buttons zur Eingabe und Textfeldern
 * und Textarea zum Ausgeben) und mit innerer Actionlistener klasse
 * 
 * @author Daniel May
 * @version 3.0 (attribute werden erst im konstruktor intialisiert, eine eigene
 *          klasse regelt den spielverlauf und farbaenderungen je nach ergebnis)
 * 
 */
public class MyPanel extends JPanel {
	public static Color[] MYCOLORS = { Color.YELLOW, Color.RED, Color.GREEN };
	private static final long serialVersionUID = 4581784888223628483L;
	private JButton schere;
	private JLabel pcschere;
	private JButton stein;
	private JLabel pcstein;
	private JButton papier;
	private JLabel pcpapier;
	private JTextField menschenpunkte;
	private JTextField computerpunkte;
	private JTextArea ergebnis;
	private JButton nochmal;
	private JButton beenden;
	private Smiley face;

	/**
	 * Standard Konstruktor setzt alle Komponenten ins Panel
	 */
	public MyPanel(MyController c, MyModel m) {
		this.setLayout(new GridLayout(6, 3, 10, 10));
		ImageIcon scherepic = new ImageIcon(getClass()
				.getResource("schere.png"));
		schere = new JButton(scherepic);
		pcschere = new JLabel(scherepic);
		pcschere.setOpaque(true);
		ImageIcon steinpic = new ImageIcon(getClass().getResource("stein.png"));
		stein = new JButton(steinpic);
		pcstein = new JLabel(steinpic);
		pcstein.setOpaque(true);
		ImageIcon papierpic = new ImageIcon(getClass()
				.getResource("papier.png"));
		papier = new JButton(papierpic);
		pcpapier = new JLabel(papierpic);
		pcpapier.setOpaque(true);
		menschenpunkte = new JTextField();
		computerpunkte = new JTextField();
		ergebnis = new JTextArea("");
		nochmal = new JButton("Nochmal");
		beenden = new JButton("Beenden");
		ergebnis.setEditable(false);
		menschenpunkte.setEditable(false);
		computerpunkte.setEditable(false);
		JLabel spieler = new JLabel("Spieler:");
		spieler.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(spieler);
		this.add(new JLabel("<html><body><center>Schere schneidet Papier.<br>"
				+ "Papier wickelt Stein ein.<br>"
				+ "Stein zerst&ouml;rt Schere.</center></body></html>"));
		JLabel computer = new JLabel("Computer:");
		computer.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(computer);
		this.add(schere);
		face = new Smiley();
		this.add(face);
		this.add(pcschere);
		this.add(stein);
		this.add(ergebnis);
		this.add(pcstein);
		this.add(papier);
		this.add(new JLabel());
		this.add(pcpapier);
		menschenpunkte.setHorizontalAlignment(SwingConstants.CENTER);
		computerpunkte.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(menschenpunkte);
		JLabel punkte = new JLabel("Punkte");
		punkte.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(punkte);
		this.add(computerpunkte);
		this.add(nochmal);
		this.add(new JLabel(
				"<html><body>Sieg: 2 Punkte<br>Unentschieden: 1 Punkt<br>Niederlage: 0 Punkte</body></html>"));
		this.add(beenden);

		schere.addActionListener(c);
		stein.addActionListener(c);
		papier.addActionListener(c);
		nochmal.addActionListener(c);
		beenden.addActionListener(c);
		initial();
	}

	public void initial() {
		schere.setBackground(null);
		stein.setBackground(null);
		papier.setBackground(null);
		pcschere.setBackground(null);
		pcstein.setBackground(null);
		pcpapier.setBackground(null);
		ergebnis.setText("noch kein Spiel");
		menschenpunkte.setText("noch kein Spiel");
		computerpunkte.setText("noch kein Spiel");
		face.setZustand(0);//unentschieden
	}

	/**
	 * aendern aller Komponenten
	 * 
	 * @param auswertung
	 *            Objekt mit allen aktuellen Inhalten
	 */

	public void display(Auswertung auswertung) {
		initial();
		Wahl menschzug = auswertung.getZugMensch();
		Wahl pczug = auswertung.getZugPC();
		int ausgewertet = auswertung.getAusgewertet();
		Color menschColor;
		Color pcColor;
		if (ausgewertet < 0) {
			menschColor = MYCOLORS[1];
			pcColor = MYCOLORS[2];
		} else if (ausgewertet > 0) {
			menschColor = MYCOLORS[2];
			pcColor = MYCOLORS[1];
		} else {
			menschColor = pcColor = MYCOLORS[0];
		}
		switch (menschzug) {
		case SCHERE:
			schere.setBackground(menschColor);
			break;
		case STEIN:
			stein.setBackground(menschColor);
			break;
		case PAPIER:
			papier.setBackground(menschColor);
			break;
		}
		switch (pczug) {
		case SCHERE:
			pcschere.setBackground(pcColor);
			break;
		case STEIN:
			pcstein.setBackground(pcColor);
			break;
		case PAPIER:
			pcpapier.setBackground(pcColor);
			break;
		}

		ergebnis.setText(auswertung.getText());
		menschenpunkte.setText("" + auswertung.getPunkteMensch());
		computerpunkte.setText("" + auswertung.getPunktePC());
		face.setZustand(auswertung.getAusgewertet());
	}

	// getter und setter

	/**
	 * @return the schere
	 */
	public JButton getSchere() {
		return schere;
	}

	/**
	 * @return the stein
	 */
	public JButton getStein() {
		return stein;
	}

	/**
	 * @return the papier
	 */
	public JButton getPapier() {
		return papier;
	}

	/**
	 * @return the nochmal
	 */
	public JButton getNochmal() {
		return nochmal;
	}

	/**
	 * @return the beenden
	 */
	public JButton getBeenden() {
		return beenden;
	}

}
