package test4;

public class Batterie {

	private String bez;
	private double kapazitaet;
	/**
	 * 
	 */
	public Batterie() {
		// TODO Auto-generated constructor stub
	}
	public Batterie(String bez, double kapazitaet) {
		this.bez=bez;
		this.kapazitaet=kapazitaet;
	}
	public double getKapazitaet() {
		return kapazitaet;
	}
	public void entladen(double prozent) {
		this.kapazitaet = kapazitaet*prozent/100;
	}
	public String info() {
		return bez+" - "+this.kapazitaet+" Ah";
	}
	public boolean istLeer() {
		return this.kapazitaet<0.05;
	}
	public void setKapazitaet(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

}
