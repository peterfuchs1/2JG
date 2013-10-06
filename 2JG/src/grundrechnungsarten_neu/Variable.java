package grundrechnungsarten_neu;
/**
 * 
 * @author Walter Rafeiner-Magor
 * @version 2.0
 *
 * @param <T> Datentyp einer Variablen
 */
public class Variable<T extends Number> {
	
	private T start; // niedrigster Wert = start-wert
	private T stopp; // höchstmöglicher Wert= stopp-wert
	private T value; // Initialwert
	private boolean fix; // handelt es sich um eine Konstante? = Fixwert?

	/**
	 * Konstuktor für Konstante
	 * @param value Wert
	 * @param fix	Variable ist fix!
	 */
	public Variable(T value, boolean fix){
		this(value,value,value,fix);
	}
	
	/**
	 * Allgemeiner Konstruktor
	 * @param start	niedrigster Wert = start-wert
	 * @param stopp höchstmöglicher Wert= stopp-wert
	 * @param value Initialwert
	 * @param fix handelt es sich um eine Konstante? = Fixwert?
	 */
	public Variable(T start, T stopp, T value, boolean fix) {
		this.start = start;
		this.stopp = stopp;
		this.value = value;
		this.fix = fix;
	}
	//
	//GETTER und SETTER
	//
	/**
	 * @return the start
	 */
	public T getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(T start) {
		this.start = start;
	}
	/**
	 * @return the stopp
	 */
	public T getStopp() {
		return stopp;
	}
	/**
	 * @param stopp the stopp to set
	 */
	public void setStopp(T stopp) {
		this.stopp = stopp;
	}
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	/**
	 * @return the fix
	 */
	public boolean isFix() {
		return fix;
	}
	/**
	 * @param fix the fix to set
	 */
	public void setFix(boolean fix) {
		this.fix = fix;
	}

}
