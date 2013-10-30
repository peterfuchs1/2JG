/**
 * 
 */
package abstrakt;

import java.io.Serializable;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface Printable extends Serializable{
	/**
	 * Print-Methode für die Konsole
	 * @param newLine soll eine neue Zeile danach ausgegeben werden?
	 */
	public void print(boolean newLine);
	/**
	 * Gibt den Namen der Klasse zurueck
	 * @return Name als String
	 */
	public String getKlassenName();
	public final static boolean NEUE_ZEILE=true; // Klassenkonstante
	public final static boolean KEINE_NEUE_ZEILE=false; // Klassenkonstante
}
