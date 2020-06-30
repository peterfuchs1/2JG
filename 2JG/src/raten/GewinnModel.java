package raten;

public class GewinnModel {
	private int gesamtPunkte, spielerZahl, computerZahl, rundenErgebnis;

	/**
	 * 
	 */
	public GewinnModel() {
		spielerZahl = computerZahl = rundenErgebnis = 0;
		gesamtPunkte = 30;
	}

	/**
	 * @return the gesamtPunkte
	 */
	public int getGesamtPunkte() {
		return gesamtPunkte;
	}

	/**
	 * @return the computerZahl
	 */
	public int getComputerZahl() {
		return computerZahl;
	}

	/**
	 * @return the rundenErgebnis
	 */
	public int getRundenErgebnis() {
		return rundenErgebnis;
	}

	public void berechneComputerZahl() {
		this.computerZahl = (int) (Math.random() * 9 + 1);
	}

	public void berechneRunde(int sz) {
		this.spielerZahl=sz;
		this.rundenErgebnis = -10;
		if (sz == this.computerZahl) {
			this.rundenErgebnis = 20;
		} else if (Math.abs(this.computerZahl - sz) == 1) {
			this.rundenErgebnis = 5;
		}
		this.gesamtPunkte += this.rundenErgebnis;
	}
}
