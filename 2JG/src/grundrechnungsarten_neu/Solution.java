package grundrechnungsarten_neu;

import java.util.ArrayList;
/**
 * ArrayList vom Datentyp <T>
 * enthält eine komplette Lösung
 * 
 * @author Walter Rafeiner-Magor
 * @version 2.0
 *
 * @param <T> Datentyp einer Variablen
 */
public class Solution<T extends Number> {
	private int anzahl;
	private ArrayList<T> val;
	/**
	 * gibt Referenz  an stelle index zurück
	 * @param index
	 * @return Element <T>
	 */
	public T getVal(int index){
		return val.get(index);
	}
	/**
	 * fügt neuen Eintrag an stelle index hinzu
	 * @param index
	 * @param element
	 */
	public void setVal(int index, T element){
		this.val.add(index, element);
	}
	/**
	 * ersetzt vorhandenen Eintrag an stelle index
	 * @param index
	 * @param element
	 */
	public void changeVal(int index, T element){
		this.val.set(index, element);
	}
	/**
	 * gibt die Initialgröße zurück
	 * @return
	 */
	public int length(){
		return anzahl;
	}
	/**
	 * Allgemeiner Konstruktor
	 * erstellt eine ArrayList in
	 * angegebener Größe
	 * @param anzahl
	 */
	Solution(int anzahl){
		val=new ArrayList<T>(anzahl);
		this.anzahl=anzahl;
	}
	
}
