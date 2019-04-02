/**
 * 
 */
package nost191;

/**
 * @author wrafeiner
 *
 */
public class Zutat {
	private String name;
	private double menge;
	private String einheit;
	
	/**
	 * @param name
	 * @param menge
	 * @param einheit
	 */
	public Zutat(String name, double menge, String einheit) {
		this.name = name;
		this.menge = menge;
		this.einheit = einheit;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the menge
	 */
	public double getMenge() {
		return menge;
	}
	/**
	 * @param menge the menge to set
	 */
	public void setMenge(double menge) {
		this.menge = menge;
	}
	/**
	 * @return the einheit
	 */
	public String getEinheit() {
		return einheit;
	}
	/**
	 * @param einheit the einheit to set
	 */
	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}
	public void skalieren(double faktor) {
		this.menge *=faktor;
	}
	public String eintrag() {
		return ""+this.menge+" "+this.einheit+" "+this.name;
	}
}
