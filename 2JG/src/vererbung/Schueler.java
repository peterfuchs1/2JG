package vererbung;

public class Schueler extends Person {
	private int katalogNr;
	private String jahrgang;
	/**
	 * 
	 */
	public Schueler() {
		this("NN",1,"1xHIT");		
	}
	/**
	 * @param katalogNr
	 * @param jahrgang
	 */
	public Schueler(String n, int katalogNr, String jahrgang) {
		super(n);
		this.katalogNr = katalogNr;
		this.jahrgang = jahrgang;
	}
	/**
	 * @return the katalogNr
	 */
	public int getKatalogNr() {
		return katalogNr;
	}
	/**
	 * @param katalogNr the katalogNr to set
	 */
	public void setKatalogNr(int katalogNr) {
		this.katalogNr = katalogNr;
	}
	/**
	 * @return the jahrgang
	 */
	public String getJahrgang() {
		return jahrgang;
	}
	/**
	 * @param jahrgang the jahrgang to set
	 */
	public void setJahrgang(String jahrgang) {
		this.jahrgang = jahrgang;
	}
	/**
	 * @return String-Repräsentation
	 */
	@Override
	public String toString() {
		return "Jahrgang: "+
		super.toString()+this.jahrgang+
		" KatalogNummer: "+this.katalogNr;
	}
}
