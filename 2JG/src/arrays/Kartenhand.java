package arrays;

/**
 * Verwaltet eine bestimmte maximale Anzahl an Spielkarten, um die in der Hand
 * gehaltenen Spielkarten in einem Spiel zu simulieren
 *
 * 
 * @author Lisa Vittori
 * 
 * @version 2017 - 12 - 13
 */
public class Kartenhand {
	private Spielkarte[] karten;

	/**
	 * Initialisert eine leere Kartenhand mit Platz für 5 Spielkarten
	 */
	public Kartenhand() {
		this.karten = new Spielkarte[5];
	}

	/**
	 * Initialisiert eine leere Kartenhand mit Platz für die angegebene Anzahl an
	 * Spielkarten oder für 5 Spielkarten falls die Anzahl 0 oder kleiner ist.
	 * 
	 * @param anzahl die maximale Anzahl an Spielkarten, die die Hand halten kann.
	 */
	public Kartenhand(int anzahl) {
		if (anzahl <= 0) {
			anzahl = 5;
		}
		this.karten = new Spielkarte[anzahl];
	}

	/**
	 * Initialisert die Kartenhand mit dem übergebenen Spielkarten - Array oder für
	 * 5 leere Plätze, falls null übergeben wird.
	 * 
	 * @param karten die Karten und Plätze, die intern zum Speichern der Karten
	 * 
	 *               verwendet werden.
	 */
	public Kartenhand(Spielkarte[] karten) {
		this.setKarten(karten);
	}

	/**
	 * Übernimmt ein Spielkarten - Array als neue Kartenhand oder erzeugt 5 leere
	 * Plätze, falls null übergeben wird.
	 * 
	 * @param karten die Karten und Plätze, die intern zum Speichern der Karten
	 * 
	 *               verwendet werden.
	 */
	public void setKarten(Spielkarte[] karten) {
		if (karten != null) {
			this.karten = karten;
		} else {
			this.karten = new Spielkarte[5];
		}
	}

	/**
	 * Gibt die Karten und freien Plätze der Kartenhand als Spielkarten - Array
	 * zurück
	 * 
	 * @return die Karten und freien Plätze der Kartenhand
	 */
	public Spielkarte[] getKarten() {
		return karten;
	}

	/**
	 * Übernimmt eine Spielkarte auf die Hand, wenn genug Platz auf der Hand
	 * vorhanden ist.
	 * 
	 * @param k die Spielkarte, die auf die Hand genommen werden soll
	 * 
	 * @return true, wenn das aufnehmen der Karte erfolgreich war, und false,
	 * 
	 *         wenn nicht mehr genug Platz auf der Hand ist.
	 */
	public boolean nimmKarte(Spielkarte k) {
		for (int i = 0; i < karten.length; i++) {
			if (karten[i] == null) {
// ein freier Platz wurde gefunden
				karten[i] = k;
				return true;

			}
		}
// Wenn das Programm hier ankommt, wurde zuvor kein freier Platz gefunden
		return false;
	}

	/**
	 * Löscht die Karte aus der Hand und gibt sie zurück
	 * 
	 * @param index der Index der Karte, die aus der Hand gelöscht werden soll
	 * 
	 * @return die Karte, die aus dem Array gelöscht wird od er null, wenn
	 * 
	 *         ein ungültiger Index übergeben wurde, oder am angegebenen Index
	 * 
	 *         keine Karte ist.
	 */
	public Spielkarte legeKarteAb(int index) {
		if (index >= 0 && index < karten.length) {
			Spielkarte k = karten[index];
// Merken der Karte in einer Hilfsvariablen 
			karten[index] = null;
// Löschen aus der entsprechenden Array - Stelle
			return k;
// zurückgeben der Karte
		}
		return null;
	}

	/**
	 * Sucht die Karte in der Kartenhand und löscht sie.
	 * 
	 * @param k die Ka rte, die aus der Kartenhand gelöscht wird
	 * 
	 * @return true, falls das Löschen erfolgreich war; false, wenn die Karte
	 * 
	 *         nicht gefunden wurde
	 */
	public boolean legeKarteAb(Spielkarte k) {
		for (int i = 0; i < karten.length; i++) {
			if (this.karten[i] != null && this.karten[i].equals(k)) {
// Karte wurde gefunden
				this.karten[i] = null;
// Löschen aus der entspr. Array-Stelle
				return true;
			}
		}
		return false;
	}

	/**
	 * Löscht alle Karten aus der Kartenhand
	 */
	public void legeAlleAb() {
		for (int i = 0; i < karten.length; i++) {
			this.karten[i] = null;
		}
	}

	/**
	 * Liefert die Karte mit dem angegebenen Index zurück
	 * 
	 * @param index der Index der gewünschten Karte
	 * 
	 * @return das Spielkarte - Objekt mit dem angegebenen Index oder null, wenn
	 * 
	 *         am angegebenen Index kein entsprechendes Objekt steht bzw. wenn
	 * 
	 *         ein ungültiger Index angegeben wurde
	 */
	public Spielkarte getKarte(int index) {

		if (index >= 0 && index < karten.length) {
			return this.karten[index];
		}
		return null;
	}

	/**
	 * Erzeugt eine neue leere Hand mit der angegebenen Anzahl an Plätzen.
	 * 
	 * @param anzahl die Anzahl der leeren Plätze in der Hand
	 * 
	 * @return true, falls das Erzeugen der Plätze erfolgreich war; false,
	 * 
	 *         falls eine ungültige Anzahl übergeben wurde
	 */
	public boolean neueHand(int anzahl) {
		if (anzahl > 0) {
			this.karten = new Spielkarte[anzahl];
			return true;
		}
		return false;
	}

	/**
	 * Vergleicht diese Hand mit der als Parameter übergebenen Hand und gibt true
	 * zurück, wenn die übergebene Hand die gleichen Karten an der gleichen Position
	 * enthält.
	 * 
	 * @param kh die Kartenhand, die verglichen werden soll.
	 * 
	 * @return true, wenn alle Karten dieses Kartenhand - Objekts mit den
	 * 
	 *         K arten des übergebenen Kartenhand - Objekts übereinstimmen
	 */
	public boolean equals(Kartenhand kh) {
		if (kh == null) {
// Falls der Wert null übergeben wurde
			return false;
		}
		Spielkarte[] ks = kh.getKarten();
		if (ks == karten) {
// das selbe Objekt im Speicher oder beide null
			return true;
		}
// entweder ist eine der beiden Array-Variablen null (sollte eigentlich
// nicht möglich sein) oder die Länge ist unterschiedlich
		if (ks == null || this.karten == null || ks.length != this.karten.length) {
			return false;
		}
// Hier wird überprüft, ob eine der Karten NICHT übereinstimmt.
		for (int i = 0; i < this.karten.length; i++) {
// es handelt sich nicht um das selbe Objekt (oder beide sind null)
			if (karten[i] != ks[i]) {
// nur eine der beiden Karten ist null, die andere Karte nicht
				if (karten[i] == null || ks[i] == null) {
					return false;
				}
// Die Karten stimmen inhaltlich nicht überein
				if (!karten[i].equals(ks[i])) {
					return false;
				}
			}
		}
// Wenn das Programm bis hierher gekommen ist, stimmen alle Karten überein
		return true;

	}

	/**
	 * Listet alle Karten in ihrer Textdarstellung mit Beistrichen getrennt auf
	 * 
	 * @return alle Karten mit ihrer Textdarstellung
	 * 
	 * @see Spielkarte#textDarstellung()
	 */
	public String textDarstellung() {
		String aus = "Kartenhand: ";
		for (int i = 0; i < karten.length; i++) {
			if (i < karten.length - 1) {
				aus += (i + 1) + ". " + (this.karten[i] == null ? "<leer>" : this.karten[i].textDarstellung()) + ", ";
			} else {
				aus += (i + 1) + ". " + (this.karten[i] == null ? "<leer>" : this.karten[i].textDarstellung());
			}
		}
		return aus;
	}

	/**
	 * Gibt eine Kopie des aktuellen Objekts zurück
	 * 
	 * @return eine Kopie dieses Objekts
	 */
	public Kartenhand clone() {
		Spielkarte[] k = new Spielkarte[this.karten.length];
		for (int i = 0; i < k.length; i++) {
			if (this.karten[i] != null) {
				k[i] = this.karten[i].clone();
			}
		}
		return new Kartenhand(k);
	}
}