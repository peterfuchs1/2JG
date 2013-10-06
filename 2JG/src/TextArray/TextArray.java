/**
 * Schreibe eine Klasse TextArray, die als einziges Attribut ein char-Array besitzt. 
 * Weiters soll die Klasse einen default Konstruktor besitzen, der dieses Array mit dem Alphabet (von a - z) 
 * befüllt und einen zweiten Konstruktor, der als Parameter einen Text als String übernehmen und 
 * diesen dann Zeichen für Zeichen in das Array kopiert. Das Array muss genau so viele Zeichen fassen können, 
 * wie Zeichen im Text vorhanden sind.

Weiters soll die Klasse neben einer getter-Methode für das Attribut noch folgende Methoden besitzen:

    * neuerText: diese Methode soll analog zum 2. Konstruktor einen Text als Parameter übernehmen und diesen Zeichen für Zeichen in das Array speichern.
    * dazuhaengen: übernimmt einen Text als Parameter und fügt dessen Zeichen zu den bereits bestehenden Zeichen dazu. 
     	Das Array muss dazu entsprechend vergrößert werden.
    * loeschen: diese Methode soll 2 Zahlen (vonIndex und bisIndex) als Parameter besitzen und aus dem Array 
     	alle Zeichen zwischen diesen beiden Indizes löschen. Das Array muss entsprechend verkleinert werden.
    * textForm: Diese Methode soll alle Zeichen, die gerade im Array sind, zu einem Text zusammenfassen und zurückgeben.
    * equals: Diese Methode soll ein anderes Objekt der Klasse TextArray übernehmen und überprüfen, 
    	ob dessen Zeichen im Array-Attribut mit den Zeichen im internen (this) Array-Attribut übereinstimmen. 
    	In diesem Fall soll true zurück gegeben werden, im anderen Fall false.


Schreibe auch eine Testklasse, mit der du alle Methoden der Klasse testest. 
Zu einem Test gehört auch, dass eventuelle Rückgabewerte gespeichert und ausgegeben werden. 
Nicht getestete Methoden werden nicht gewertet.
 */
package TextArray;

import java.util.Arrays;

/**
 * @author uhs374h
 *
 */
public class TextArray {
	char[] zeichen; 
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param input Eingabestring
	 */
	public TextArray(String input) {
		this.neuerText(input);
		
	}
	/**
	 * Standardkonstruktor
	 */
	public TextArray() {
		zeichen= new char[26];
		char a='a';
		for (int i=0;i<zeichen.length;i++) {
			zeichen[i]=(char) (a+i);
		}
	}
	/**
	 * Neuer Text ersetzt das Attribut
	 * @param input
	 */
	public void neuerText(String input) {
		zeichen=new char[input.length()];
		for (int i=0;i<zeichen.length;i++) {
			zeichen[i]=input.charAt(i);
		}
	}
	/**
	 * Attribut um input-String verlängern
	 * @param input eingabestring
	 */
	public void dazuhängen(String input) {
		char[] zeichen_temp=new char[zeichen.length+input.length()];
		int i=0;
		// Vorhandene Zeichen übernehmen
		for (;i<zeichen.length;i++) 
			zeichen_temp[i]=zeichen[i];
		// Input zeichenweise übernehmen
		for(int j=0;i<zeichen_temp.length;i++,j++)
			zeichen_temp[i]=input.charAt(j);
		// Temp_Array übernehmen
		zeichen=zeichen_temp;
	}
	/**
	 * Löschen von Teilen des Arrays
	 * @param vonIndex Startindex
	 * @param bisIndex Endeindex
	 */
	public void loeschen(int vonIndex, int bisIndex) {
		// neue Länge berechnen
		int neue_laenge=zeichen.length-(Math.abs(bisIndex-vonIndex)+1);
		char[] zeichen_temp=new char[neue_laenge];
		int i=0; // Index für OriginalArray
		int j=0; // Index für TempArray
		while(j<zeichen_temp.length) {      // Solange noch nicht am Ende 
			if(i<vonIndex || i>bisIndex) {  // Wenn nicht innerhalb des Index
				zeichen_temp[j]=zeichen[i]; // Zeichen übernehmen
				j++;						// ZielIndex erhöhen
			}
			i++;							// QuellIndex erhöhen
		}
		zeichen=zeichen_temp;				// Temp_Array übernehmen
	}
	/**
	 * Gibt Zeichen an beliebiger Stelle des Arrays zurück
	 * @param i Index
	 * @return Zeichen an der Stelle
	 */
	public char getZeichen(int i){
		return zeichen[i];
	}
	/**
	 * Gibt die Länge des Arrays zurück
	 * @return Länge
	 */
	public int length(){
		return zeichen.length;
	}
	/**
	 * Zeichenarray als String darstellen
	 * @return Stringrepräsentation
	 */
	public String textForm() {
		StringBuilder s=new StringBuilder();
		return s.append(zeichen).toString();
	}
	/**
	 * Vergleich von zwei Objekten von TextArray auf inhaltliche Gleichheit
	 * @param ta Objekt der Klasse TextArray
	 * @return bool
	 */
	public boolean equals(TextArray ta){
		boolean ret=true;
		for (int i=0;i<zeichen.length&& i<ta.length();i++){
			if(zeichen[i]!=ta.getZeichen(i)){
				ret=false;
				break;
			}
		}
		
		return ret;
	}
	
}
