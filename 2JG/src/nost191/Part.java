package nost191;

import java.security.InvalidParameterException;

public class Part {
	private String lagerort;
	private int stueckzahl;
	public String namen;
	/**
	 * @param lagerort
	 * @param namen
	 */
	public Part(String lagerort, String namen) {
		if(lagerort.length()!=4)
			throw new InvalidParameterException("nur Lagerorte mit 4 Stellen moeglich");
		this.lagerort = lagerort;
		this.namen = namen;
	}
	/**
	 * @return the stueckzahl
	 */
	public int getStueckzahl() {
		return stueckzahl;
	}
	/**
	 * @param stueckzahl the stueckzahl to set
	 */
	public void setStueckzahl(int stueckzahl) {
		if(stueckzahl>=0 )
			this.stueckzahl = stueckzahl;
	}
	/**
	 * @return the lagerort
	 */
	public String getLagerort() {
		return lagerort;
	}
	public boolean entnehmen(int p) {
		boolean ret=false;
		if (p<=1)
			return ret;
		if (this.stueckzahl-p>=0) {
			this.stueckzahl -=p;
			ret=true;
		}
		return ret;
		
	}
	public boolean istLeer() {
		return this.stueckzahl==0;
	}
	public String partInfo() {
		return this.namen+", Lageort: "+this.lagerort+
				", Stueck: "+this.stueckzahl+
				", Leer: "+this.istLeer();
	}
	public boolean istMehr(Part p) {
		return (this.stueckzahl>p.stueckzahl);
	}
}
