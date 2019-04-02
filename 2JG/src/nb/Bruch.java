package nb;

public class Bruch {
	private int zaehler;
	private int nenner;
	
	
	/**
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}


	/**
	 * @param zaehler
	 */
	public Bruch(int zaehler) {
		this(zaehler,1);
	}


	/**
	 * 
	 */
	public Bruch() {
		this(0,1);
	}
	
	public Bruch add(Bruch b) {
		return Bruch.add(this, b);
		
	}
	public Bruch sub(Bruch b) {
		return Bruch.sub(this, b);
	}
	public static Bruch add(Bruch a, Bruch b) {
		return new Bruch(a.zaehler*b.nenner+b.zaehler*a.nenner,
				a.nenner*b.nenner);
	}
	public static Bruch sub(Bruch a, Bruch b) {
		return Bruch.add(a,Bruch.negation(b));
	}
	public static  Bruch negation(Bruch a) {
		return new Bruch(-a.zaehler,a.nenner);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		return "Bruch [zaehler=" + zaehler + ", nenner=" + nenner + "]";
	}


	public static void main(String[] args) {
		int zaehler=17;
		Bruch b=new Bruch(zaehler);
		
		System.out.println(b.toString());
	}


	/**
	 * @return the zaehler
	 */
	public int getZaehler() {
		return zaehler;
	}


	/**
	 * @param zaehler the zaehler to set
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}


	/**
	 * @return the nenner
	 */
	public int getNenner() {
		return nenner;
	}


	/**
	 * @param nenner the nenner to set
	 */
	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
}
