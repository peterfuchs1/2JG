package grundrechnungsarten_rekursiv;

public class Variable<T extends Number> {
	
	
	private T start;
	private T stopp;
	private T value;
	private boolean fix;
	/**
	 * Standard-Konstruktor
	 */
	public Variable(){

	}
	/**
	 * Konstruktor fix
	 */
	public Variable(T value, boolean fix){
		this(value,value,value,fix);
	}
	
	/**
	 * @param start
	 * @param stopp
	 * @param value
	 * @param fix
	 */
	public Variable(T start, T stopp, T value, boolean fix) {
		this.start = start;
		this.stopp = stopp;
		this.value = value;
		this.fix = fix;
	}
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
