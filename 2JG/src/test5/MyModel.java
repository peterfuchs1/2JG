/**
 * 
 */
package test5;

import java.util.Random;

/**
 * Klasse zum Regeln des Spielverlaufs
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class MyModel {

	private int zahl1; /* Zahl1 */
	private int zahl2; /* Zahl2 */
	private int ergebnis; /* Ergebnis der Berechnung */
	private char operator; /* gewaehlter Operator */

	/**
	 * Standard konstruktor
	 */
	public MyModel() {
		reset();
		neueZahlen();
	}
	/**
	 * gestartet wird mit der Addition
	 */
	private void reset() {
		operator = '+';
	}
	/**
	 * es werden auf Basis des Operators 
	 * neue Zahlen erstellt
	 */
	public void neueZahlen() {
		Random r = new Random();
		switch (this.operator) {
		case '*':
			zahl1 = r.nextInt(5);
			zahl2 = r.nextInt(9 - zahl1);
			this.ergebnis=zahl1*zahl2;
			break;
		case '-':
			zahl1 = r.nextInt(20);
			zahl2 = zahl1==0?zahl1:r.nextInt(zahl1);
			this.ergebnis=zahl1-zahl2;
			break;
		case ':':
			zahl1 = r.nextInt(20);
			zahl2 = zahl1 <= 1 ? 1:r.nextInt(zahl1);
			zahl2 = zahl2==0 ? 1: zahl2;
			this.ergebnis=zahl1/zahl2;
			break;
		case '+':
			zahl1 = r.nextInt(20);
			zahl2 = r.nextInt(20-zahl1);
			this.ergebnis=zahl1+zahl2;
			break;
			
		}
		
	}
	/**
	 * Ergebnis als String
	 * @return ergebnis
	 */
	public String rechnenString() {
		return ""+this.ergebnis;
	}
	/**
	 * Testet das Ergebnis mit dem berechnetem Wert 
	 * @param ergebnis uebergebener Wert
	 * @return passt das Ergebnis
	 */
	public boolean check(int ergebnis) {
		return this.ergebnis==ergebnis;
	}
	/**
	 * Gibt die Loesung der Berechnung zurueck
	 * @return erwarteter Wert
	 */
	public int loesung() {
		return this.ergebnis;
	}

	/**
	 * @return the operator
	 */
	public char getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(char operator) {
		this.operator = operator;
	}

	/**
	 * @return the zahl1
	 */
	public int getZahl1() {
		return zahl1;
	}

	/**
	 * @return the zahl2
	 */
	public int getZahl2() {
		return zahl2;
	}
	
}
