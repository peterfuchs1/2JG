package test5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyController implements ActionListener {
	private MyPanel myPanel; // My JPanel
	private MyModel myModel; // My Model for this game
	public static String titel = "Rechentrainer"; // Titel des Spiels
	public static int height = 150; // Hohe des Frames
	public static int width = 580; // Breite des Frames
	// Konstanten für den Vergleich in actionPerformed
	private final static String oPlus = "+";
	private final static String oMinus = "-";
	private final static String oMultiply = "*";
	private final static String oDivide = ":";
	private final static String bNeueRechnung = "neue Rechnung";
	private final static String bLoesung = "Lösung";

	/**
	 * Konstruktor erstellt die Objekte nach MVC
	 */
	public MyController() {
		myModel = new MyModel();
		myPanel = new MyPanel(this, myModel);
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
		if (ac.equals(bNeueRechnung)) {
			this.neueRechnung();
		} else if (ac.contentEquals(oPlus) || ac.contentEquals(oMultiply) || ac.contentEquals(oMinus)
				|| ac.contentEquals(oDivide)) {
			this.operatoren(ac);
		} else if (ac.contentEquals(bLoesung)) {
			this.loesung();
		} else {
			verifizieren();
		}

	}

	private void verifizieren() {
		int delivered = Integer.parseInt(myPanel.getErgebnis().getText());
		boolean correct = myModel.check(delivered);
		if (correct) {
			myPanel.setStatus(1);
			myPanel.setMeldung("Gratulation - gut gemacht!");
		} else {
			myPanel.setStatus(2);
			myPanel.setMeldung("Passt leider nicht [" + myModel.rechnenString() + "] !");
		}
	}

	private void loesung() {
		myPanel.setErgebnis(myModel.rechnenString());

	}

	/**
	 * erstellt eine neue Rechnung und stellt die Zahlen dar
	 */
	private void neueRechnung() {
		myModel.neueZahlen();
		myPanel.setZahl1("" + myModel.getZahl1());
		myPanel.setZahl2("" + myModel.getZahl2());
		myPanel.setMeldung("");
		myPanel.setErgebnis("");
		myPanel.setStatus(0);
	}

	/**
	 * Operatoren verarbeiten
	 * 
	 * @param ac gewaehlter Operator
	 */
	private void operatoren(String ac) {
		char op;
		switch (ac) {
		case oMinus:
			op = '-';
			break;
		case oMultiply:
			op = '*';
			break;
		case oDivide:
			op = ':';
			break;
		default:
			op = '+';
		}

		myPanel.setOperator(op);
		myModel.setOperator(op);
		this.neueRechnung();

	}
}
