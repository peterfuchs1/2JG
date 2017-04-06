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
	public default void print(boolean newLine){
		System.out.print("Leider keine Implementierung vorhanden");
		if(newLine) 
			System.out.println();
	}
	/**
	 * Methode testet den Parameter auf null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str == null ? true : "".equals(str) ? true : false;
	}
	/**
	 * Gibt den Namen der Klasse zurueck
	 * @return Name als String
	 */
	public String getKlassenName();
	public final static boolean NEUE_ZEILE=true; // Klassenkonstante
	public final static boolean KEINE_NEUE_ZEILE=false; // Klassenkonstante
}
