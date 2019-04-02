package test4;

public class Quadrat {
	private double seite;
	public Quadrat() {
		this(1.0);
	}
	public Quadrat(double d) {
		this.setSeite(d);
	}
	public static boolean istSeiteGueltig(double s) {
		return (s>0 && s<=1000000);
	}
	/**
	 * @return the seite
	 */
	public double getSeite() {
		return seite;
	}
	/**
	 * @param seite the seite to set
	 */
	public void setSeite(double seite) {
		if(Quadrat.istSeiteGueltig(seite))
			this.seite = seite;
		else
			throw new UngueltigeSeiteException();
	}
	public double flaechenInhalt() {
		return this.seite*this.seite;
	}
	public boolean vergroessern(double f) {
		boolean ret=Quadrat.istSeiteGueltig(this.seite*f);
		if (ret) {
			this.seite *= f;
		}
		else
			throw new UngueltigeSeiteException();
		return ret;
	}
	public String text() {
		return "s = "+this.seite+" cm, A = "+this.flaechenInhalt()
				+" cm2"; 
	}
	public boolean istKleiner(Quadrat q) {
		return this.flaechenInhalt()< q.flaechenInhalt();
	}
}
