package g836;

/**
 * 
 * @author wrafeiner
 * @version 1.1
 */
public class RateZahl {
	private int zahl; /*Die Zufallszahl */
	private int versuche; /*Anzahl der Versuche*/
	public final static int MAXIMUM = 20; // Falls keine Zahl gewaehlt wurde
	/**
	 * Konstruktor ohne Vorgabe der maximalen Zahl
	 */
	public RateZahl() {
		this(MAXIMUM);
	}
	/**
	 * Konstruktor mit vorgegebener Maximalzahl 
	 * @param zahl
	 */
	public RateZahl (int zahl) {
		this.neueZufallszahl(zahl);

	}
	/**
	 * Testet die uebergebene Zahl mit der Zufallszahl
	 * @param z uebergebene Zahl
	 * @return Differenz
	 */
	public int compare(int z) {
		versuche++;
		return z-this.zahl;
	}
	/**
	 * neue Zufallszahl ermitteln
	 */
	public void neueZufallszahl() {
		this.neueZufallszahl(MAXIMUM);
	}
	/**
	 * Ermittelt eine neue Zufallszahl
	 * @param zahl maximale Zahl
	 */
	public void neueZufallszahl(int zahl) {
		this.zahl = (int) (Math.random() * zahl + 1);
		this.versuche=0;
	}
	/**
	 * @return the zahl
	 */
	public int getZahl() {
		return zahl;
	}
	/**
	 * @return the versuche
	 */
	public int getVersuche() {
		return versuche;
	}
}
