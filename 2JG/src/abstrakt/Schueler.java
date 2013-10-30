package abstrakt;
/**
 * Klasse Schueler 
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class Schueler extends Person {
	private int katalogNr;
	private String jahrgang;
	/**
	 * 
	 */
	public Schueler() {
		this("NN","NN",1,"1xHIT");		
	}
	/**
	 * @param katalogNr
	 * @param jahrgang
	 */
	public Schueler(String name, String vorname, int katalogNr, String jahrgang) {
		super(name,vorname);
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
	 * {@link Person#toString()}
	 * @return String-Repräsentation
	 */
	@Override
	public String toString() {
		return super.toString()+", Jahrgang: "+this.jahrgang+
		", KatalogNummer: "+this.katalogNr;
	}
	/**
	 * {@link Printable#getKlassenName()}
	 */
	@Override
	public String getKlassenName(){
		return "Schueler ";
	}
		
}
 	