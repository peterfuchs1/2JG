package abstrakt;
/**
 * Klasse Lehrer 
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class Lehrer extends Person {
	private String kurzz;
	private String abteilung;
	/**
	 * Standardkonstruktor
	 */
	public Lehrer() {
		this("NN","NN","NN","NN");		
	}
	
	/**
	 * Konstruktor mit 2 Parameter
	 * @param nachName
	 * @param vorName
	 */
	public Lehrer(String nachName, String vorName) {
		this(nachName,vorName,"NN","NN");
	}

	/**
	 * Konstruktor mit 4 Parameter
	 * @param name
	 * @param vorname
	 * @param kurzz
	 * @param abteilung
	 */
	public Lehrer(String name, String vorname, String kurzz, String abteilung) {
		super(name,vorname);
		this.kurzz = kurzz;
		this.abteilung = abteilung;
	}
/////////////////////// SETTER & GETTER
	/**
	 * @return the kurzz
	 */
	public String getKurzz() {
		return kurzz;
	}
	/**
	 * @param kurzz the kurzz to set
	 */
	public void setKurzz(String kurzz) {
		this.kurzz = kurzz;
	}
	/**
	 * @return the abteilung
	 */
	public String getAbteilung() {
		return abteilung;
	}
	/**
	 * @param abteilung the abteilung to set
	 */
	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
/////////////////////// SETTER & GETTER
	/**
	 * {@link Person#toString()}
	 * @return String-Repräsentation
	 */
	@Override
	public String toString() {
		return super.toString()+", Abteilung: "+this.abteilung+
		", Kurzzeichen: "+this.kurzz;
	}
	/**
	 * {@link Printable#getKlassenName()}
	 */
	@Override
	public String getKlassenName(){
		return "Lehrer ";
	}
		
}
 	