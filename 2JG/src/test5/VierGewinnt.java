package test5;

/**
 * Klasse zum Regeln des Spielverlaufs
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class VierGewinnt {

	private int[][] spielfeld; /* Spielfeld */
	private int aktiverSpieler; /* Spieler (1 oder 2) */

	/**
	 * @return the aktiverSpieler
	 */
	public int getAktiverSpieler() {
		return aktiverSpieler;
	}

	/**
	 * Standard konstruktor
	 */
	public VierGewinnt(int zeilen, int spalten) {
		spielfeld = new int[zeilen][spalten];
		init();
	}

	/**
	 * Spieler waehlt eine Spalte aus
	 * 
	 * @param spalte gewaehlte Spalte
	 * @return Zeile oder -1, falls kein Platz vorhanden
	 */
	public int spielerWahl(int spalte) {
		int zeile = -1;
		for (int i = 0; i < spielfeld.length; ++i) {
			if (spielfeld[i][spalte] == 0) {
				spielfeld[i][spalte] = aktiverSpieler;
				return i;
			}
		}
		return zeile;
	}

	/**
	 * Das Spiel wird initialisiert
	 */
	public void init() {
		aktiverSpieler = 1;
		for (int i = 0; i < this.spielfeld.length; ++i)
			for (int j = 0; j < this.spielfeld[i].length; ++j)
				this.spielfeld[i][j] = 0;
	}

	/**
	 *  Der naechste Spieler wird ermittelt und gesetzt
	 */
	public void naechsterSpieler() {
		this.aktiverSpieler = (aktiverSpieler == 1) ? 2 : 1;
	}

	/**
	 * Gibt es bereits einen Sieger?
	 * 
	 * @return Spieler (Nummer) Falls es noch keinen Sieger gibt : -1
	 */
	public int spielerGewonnen() {
		int sum = 0;
		// Sieg in Zeile
		for (int i = 0; i < this.spielfeld.length; ++i) {
			sum = 0;
			for (int j = 0; j < this.spielfeld[0].length; ++j) {
				if (this.spielfeld[i][j] == aktiverSpieler)
					sum++;
				else
					break;
			}
			if (sum > 3)
				return aktiverSpieler;
		}
		// Sieg in Spalte
		for (int j = 0; j < this.spielfeld[0].length; ++j) {
			sum = 0;
			for (int i = 0; i < this.spielfeld.length; ++i) {
				if (this.spielfeld[i][j] == aktiverSpieler)
					sum++;
				else
					break;
			}
			if (sum > 3)
				return aktiverSpieler;
		}
		// Sieg von links nach rechts

		for (int s = 0; s < this.spielfeld[0].length; ++s) {
			sum = 0;
			for (int i = 0; i < this.spielfeld.length && (i+s) < this.spielfeld[0].length; ++i) {
				if (this.spielfeld[i][i+s] == aktiverSpieler)
					sum++;
				else
					break;
			}
			if (sum > 3)
				return aktiverSpieler;

		}
		// Sieg von rechts nach links

				for (int s = this.spielfeld[0].length-1;s>=0; --s) {
					sum = 0;
					for (int i = 0; i < this.spielfeld.length && (s-i)>=0; ++i) {
						if (this.spielfeld[i][s-i] == aktiverSpieler)
							sum++;
						else
							break;
					}
					if (sum > 3)
						return aktiverSpieler;

				}
		return -1;
	}
}
