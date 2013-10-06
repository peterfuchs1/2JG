package grundrechnungsarten;

public class Variable {
	private static int START=0;
	private static int STOPP=9;
	private static int VALUE=0;
	
	public static void setStaticValues(int start, int stopp, int value){
		START=start;
		STOPP=stopp;
		VALUE=value;
	}
	public static void setStaticValues(int start, int stopp){
		Variable.setStaticValues(start,stopp,0);
	}
	/**
	 * @return the sTART
	 */
	public static int getSTART() {
		return START;
	}
	/**
	 * @param start the sTART to set
	 */
	public static void setSTART(int start) {
		START = start;
	}
	/**
	 * @return the sTOPP
	 */
	public static int getSTOPP() {
		return STOPP;
	}
	/**
	 * @param stopp the sTOPP to set
	 */
	public static void setSTOPP(int stopp) {
		STOPP = stopp;
	}
	/**
	 * @return the vALUE
	 */
	public static int getVALUE() {
		return VALUE;
	}
	/**
	 * @param value the vALUE to set
	 */
	public static void setVALUE(int value) {
		VALUE = value;
	}
	private int start;
	private int stopp;
	private int value;
	private boolean fix;
	/**
	 * Standard-Konstruktor
	 */
	public Variable(){
		start=START;
		stopp=STOPP;
		value=VALUE;
		fix=false;
	}
	/**
	 * Konstruktor fix
	 */
	public Variable(int value, boolean fix){
		this(value,value,value,true);
	}
	
	/**
	 * @param start
	 * @param stopp
	 * @param value
	 * @param fix
	 */
	public Variable(int start, int stopp, int value, boolean fix) {
		this.start = start;
		this.stopp = stopp;
		this.value = value;
		this.fix = fix;
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the stopp
	 */
	public int getStopp() {
		return stopp;
	}
	/**
	 * @param stopp the stopp to set
	 */
	public void setStopp(int stopp) {
		this.stopp = stopp;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
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
