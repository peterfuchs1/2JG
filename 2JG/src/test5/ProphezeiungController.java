package test5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ProphezeiungController implements ActionListener {
	private ProphezeiungLayout myPanel; /* My JPanel */
	private Prophezeiung myModel; /* My Model for this game */
	private int index;
	public static String titel = "Prophezeiung"; /* Titel des Spiels */
	public static int height = 280; /* Hohe des Frames */
	public static int width = 410; /* Breite des Frames */

	/**
	 * Konstruktor erstellt die Objekte nach MVC
	 */
	public ProphezeiungController() {
		myModel = new Prophezeiung();
		myPanel = new ProphezeiungLayout(this, myModel);
		new MyFrame(myPanel, titel, width, height);
		init();
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
		case "Neuer Versuch":
			init();
			break;
		case "Prüfen":
			pruefen();
			myPanel.setPunkte(myModel.gewinnSumme());
			myPanel.setMsg(myModel.gewinnText());

			break;
		}
	}

	/**
	 * Es wurde die Taste Weiter gedrueckt
	 */
	public void pruefen() {
		// Werte holen
		int[] tipps = myPanel.getSpielerTipps();
		myPanel.setAugensumme(tipps[0] + tipps[1]);
		myModel.setSpielerTipp(tipps);
		myModel.wuerfeln();
		myPanel.getW1().setAugen(this.index, myModel.getCompWuerfel(this.index));
		this.index++;
		myModel.wuerfeln();
		myPanel.getW2().setAugen(this.index, myModel.getCompWuerfel(this.index));

	}

	public void init() {
		this.index = 0;
		myModel.init();
		myPanel.init();
		myPanel.getW1().setAugen(this.index, myModel.getCompWuerfel(this.index));
		myPanel.getW2().setAugen(this.index, myModel.getCompWuerfel(this.index));

	}

	/**
	 * Start der Uebung
	 * 
	 * @param args Commandline Argumente
	 */
	public static void main(String[] args) {
		new ProphezeiungController();
	}
}
