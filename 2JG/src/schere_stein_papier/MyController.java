package schere_stein_papier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyController implements ActionListener {
	private MyFrame myFrame; // My standard JFrame
	private MyPanel myPanel; // My JPanel
	private MyModel myModel; // My Model for this game

	public MyController() {
		myModel = new MyModel();
		myPanel = new MyPanel(this, myModel);
		myFrame = new MyFrame(myPanel, "Schere Stein Papier!");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		Auswertung auswertung;

		/*
		 * Wenn nochmal gedrueckt wird und temp != 0 und 4 ist, also schon eine
		 * Auswahl getroffen wurde und nicht auf Beenden gedrueckt wurde, wird
		 * temp, ergebnis und die Farben zurueckgesetzt.
		 */
		if (jb.equals(myPanel.getNochmal())) {
			myModel.reset();
			myPanel.initial();
		}

		/*
		 * Beendet
		 */
		else if (jb.equals(myPanel.getBeenden())) {
			System.exit(0);
		}

		else {

			/*
			 * Schere, Stein und Papier koennen nur bei temp==0 gedrueckt
			 * werden, also wenn noch keine Auswahl getroffen wurde
			 */
			if (jb.equals(myPanel.getSchere())) {
				myModel.setMenschzug(Wahl.SCHERE);
			}
			if (jb.equals(myPanel.getStein())) {
				myModel.setMenschzug(Wahl.STEIN);
			}
			if (jb.equals(myPanel.getPapier())) {
				myModel.setMenschzug(Wahl.PAPIER);
			}
			// erstelle ein neues Auswertungsobjekt
			auswertung = new Auswertung(myModel.getMenschzug(),
					myModel.pczug(), myModel.check(),
					myModel.getMenschcounter(), myModel.getPccounter(),
					myModel.getAktuellerText());
			// aktualisiere Display
			myPanel.display(auswertung);

		}
	}

}
