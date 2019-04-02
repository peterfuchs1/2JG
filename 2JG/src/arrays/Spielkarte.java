package arrays;

/**
 * Diese Klasse dient als Vorlage für S pielkarten - Objekte. Sie speichert dazu
 * die Farbe (Herz, Pik, Karo oder Kreuz) und den Kartenwert (1 - 13, wobei die
 * Werte 11 - 13 eigentlich den Karten Bube, Dame und König entsprechen)
 *
 * 
 * @author Lisa Vittori
 * 
 * @version 2017 - 09 - 25
 */
public class Spielkarte {
	private String farbe;
	private int wert;

	/**
	 * Initialisiert das Spielkarten - Objekt mit der Farbe Herz und dem Wert 1,
	 * also dem Äquivalent von Herz - As
	 */
	public Spielkarte() {
		this.farbe = "Herz";
		this.wert = 1;
	}

	/**
	 *
	 * Erzeugt eine neue Spielkarte mit der angegebenen Farbe und dem angegebenen
	 * Spielkartenwert, wenn diese im gültigen Bereich liegen. Falls eine ungültige
	 * Farbe übergeben wird, wird Herz als Farbe gesetzt und bei einem ungültigen
	 * Wert wird 1 verw endet.
	 * 
	 * @param farbe die Anfangsfarbe, wobei nur Herz, Pik, Karo oder
	 *
	 *              Kreuz erlaubt sind.
	 * 
	 * @param wert  der initiale Kartenwert im Bereich 1 - 13
	 */
	public Spielkarte(String farbe, int wert) {
		this.farbe = "Herz";
		this.wert = 1;
		this.setFarbe(farbe);
		this.setWert(wert);
	}

	/**
	 * Ändert den Wert von Farbe auf den Wert des Parameters, so lange die Farbe
	 * einem gültigen Wert entspricht.
	 * 
	 * @param f die neue Farbe, wobei nur Herz, Pik, Karo oder
	 *
	 *          Kreuz erl aubt sind.
	 */
	public void setFarbe(String farbe) {
		if (farbe.equals("Herz") || farbe.equals("Pik") || farbe.equals("Karo") || farbe.equals("Kreuz")) {
			this.farbe = farbe;
		}
	}

	/**
	 * Gibt die aktuelle Kartenfarbe zurück
	 * 
	 * @return die Far be des Spielkarten - Objekts
	 */

	public String getFarbe() {
		return farbe;
	}

	/**
	 * Ändert den Kartenwert wert auf den übergebenen Kartenwert, wenn dieser dem
	 * gültigen Bereich entspricht
	 * 
	 * @param w der neue Kartenwert im Bereich 1 - 13
	 */
	public void setWert(int wert) {
		if (wert >= 1 && wert <= 13) {
			this.wert = wert;
		}
	}

	/**
	 * Gibt den aktuellen Kartenwert zurück
	 * 
	 * @return den Kartenwert des Spielkarten - Objekts
	 */
	public int getWert() {
		return wert;
	}

	/**
	 * Gibt den dem Kartenwert entsprechenden Text zurück
	 * 
	 * @return der dem Kartenwert entsprechenden Text, d.h. As statt 1, Bube statt
	 * 
	 *         11, Dame statt 12 und König statt 13. In allen anderen Fällen wird
	 * 
	 *         der Zahlenwert als String zurückgegeben.
	 */
	public String getTextwert() {
		String t;
		switch (this.wert) {
		case 1:
			t = "As";
			break;
		case 11:
			t = "Bube";
			break;
		case 12:
			t = "Dame";
			break;
		case 13:
			t = "König";
			break;
		default:
			t = String.valueOf(this.wert);
		}
		return t;
	}

	/**
	 * Gibt entweder rot oder schwarz je nach Kartenfarbe zurück
	 * 
	 * @return rot bei den Farben Herz und Karo, schwarz bei Pik und Kreuz
	 */
	public String rotOderSchwarz() {
		if (this.farbe.equals("Herz") || this.farbe.equals("Karo")) {
			return "rot";

		}
		return "schwarz";
	}

	/**
	 * Gibt den Objektzustand in der Form <em> Farbe Textwert </em> zurück
	 * 
	 * @return die Werte Spielkarte in der Form <em> Farbe Textwert </em>
	 */
	public String textDarstellung() {
		String t = this.getTextwert();
		return this.farbe + " " + t;
	}

	/**
	 * Vergleicht farbe und wert von diesem Objekt mit farbe und wert vom über -
	 * gebenen Objekt und gibt true zurück, wenn beide Attribute übereinstimmen.
	 * 
	 * @param karte die Vergleichskarte
	 * 
	 * @return tr ue, wenn alle Attribute des übergebenen Objekts mit den Attributen
	 * 
	 *         dieses Objekts inhaltlich übereinstimmen.
	 */
	public boolean equals(Spielkarte karte) {
		boolean vergleich = false;
		if (karte != null && this.farbe.equals(karte.getFarbe()) && this.wert == karte.getWert()) {
			vergleich = true;
		}
		return vergleich;
	}

	/**
	 * Gibt ein neues Spielkarten - Objekt zurück, dessen Zustand gleich diesem
	 * Spielkarten - Objekt ist.
	 * 
	 * @return eine Kopie dieses Spielkarten - Objekts
	 */
	public Spielkarte clone() {
		Spielkarte k = new Spielkarte(this.farbe, this.wert);
		return k;
	}
}