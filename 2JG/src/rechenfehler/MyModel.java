package rechenfehler;

public class MyModel {
	private String[] aufgaben;
	private int[] loesungen;
	/**
	 * Konstruktor
	 * Ein neues Aufgabenmodell wird erstellt
	 */
	public MyModel(){
		aufgaben=new String[]{"3+3","4x3","2+2+4+4","2x5-3x3-4x4","3^2+4^2","9^2-8^2","8^2-7^2","1x1+1x1+1x1","25^2","81x81"};
		loesungen=new int[]{6,12,12,-15,25,17,15,3,625,6561};
	}
	/**
	 * Die Lösung der Aufgabe für den mitgegebenen Index wird überprüft
	 * @param index
	 * @param result
	 * @return true/false
	 * @throws WrongResultException falls Berechnung falsch
	 * @throws ArrayIndexOutOfBoundsException falls der Index nicht verfügbar ist
	 */
	public boolean check(int index,int result) throws WrongResultException, ArrayIndexOutOfBoundsException
	{
		boolean ret=loesungen[index]==result;
		if(!ret) throw new WrongResultException();
		return ret;
	}
	/**
	 * Ermittelt einen Index einer zufälligen Aufgabe
	 * @return
	 */
	public int getIndex(){
		return (int)(aufgaben.length*Math.random());
	}
	/**
	 * Liefert die Aufgabe für den Index
	 * @param index
	 * @return Aufgabe
	 * @throws ArrayIndexOutOfBoundsException falls der Index nicht vorhanden ist
	 */
	public String getTask(int index) throws ArrayIndexOutOfBoundsException{
		return aufgaben[index];
	}
}
