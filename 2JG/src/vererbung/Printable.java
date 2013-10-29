/**
 * 
 */
package vererbung;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface Printable {
	/**
	 * Print-Methode für die Konsole
	 * @param newLine soll eine neue Zeile danach ausgegeben werden?
	 */
	public void print(boolean newLine);
	/**
	 * Gibt den Name der Klasse zurueck
	 * @return Name als String
	 */
	public String getKlassenName();
	public final static boolean WAHR=true; // Klassenkonstanten
	public final static boolean FALSCH=false; // Klassenkonstanten
}
