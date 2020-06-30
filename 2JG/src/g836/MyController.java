package g836;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyController implements ActionListener {
	private RateZahl myModel; /*Objekt der Modelklasse*/
	private MyPanel myPanel; /*Objekt von MyPanel*/
	int max; /*groesstmoegliche Zahl*/
	/**
	 * Konstruktor
	 */
	public MyController() {
		max = RateZahl.MAXIMUM;
		myModel = new RateZahl(max);
		myPanel = new MyPanel(this, max);
		new MyFrame(myPanel, "Zahlenspiel", 400, 200);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		switch (s) {
		case "Neu":
			myModel.neueZufallszahl(max);
			myPanel.init();
			break;
		case "Loese":
			int zufall = myModel.getZahl();
			myPanel.setZufallsZahl("" + zufall);
			myPanel.ende(myModel.getVersuche());
			break;
		case "Check":
			this.check();
		}

	}
	/**
	 * check: die eingegeben Zahl wird mit der Zufallszahl verglichen
	 * und dem Benutzer einen Hinweis (textuell und Farbe) gegeben
	 */
	public void check() {
		int zahl = Integer.parseInt(myPanel.getTfZahl());
		int vergleich =myModel.compare(zahl);
		vergleich= (int) Math.signum(vergleich);
		int versuche= myModel.getVersuche();
		myPanel.newMessage(vergleich, versuche);
	}
}
