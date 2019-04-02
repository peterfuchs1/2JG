package test2;

public class Lernbuero {
	private String bezeichung;
	private int maxSchueler;
	private int anmeldungen;
	public Lernbuero(String bez, int maxSch) {
		this.bezeichung = bez;
		this.maxSchueler = maxSch;
		this.anmeldungen=0;
	}
	/**
	 * @return the bezeichung
	 */
	public String getBezeichung() {
		return bezeichung;
	}
	/**
	 * @return the maxSchueler
	 */
	public int getMaxSchueler() {
		return maxSchueler;
	}
	/**
	 * @return the anmeldungen
	 */
	public int getAnmeldungen() {
		return anmeldungen;
	}
	public boolean anmelden(int schuelerZahl) {
		boolean ret=false;
		if (this.anmeldungen+schuelerZahl>this.maxSchueler)
			return ret;
		else {
			this.anmeldungen +=schuelerZahl;
			return true;
		}
	}
	public boolean istVoll() {
		return (this.anmeldungen==this.maxSchueler);
	}
	public String status() {
		String s="";
		s+=this.bezeichung+"-"+this.anmeldungen+" von max. "+
		+this.maxSchueler;
		return s;
	}
}
