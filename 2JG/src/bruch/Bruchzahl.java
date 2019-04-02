package bruch;

public class Bruchzahl {
	/** Zaehler des Bruches */
	private int zaehler;
	/** Nenner des Bruches */
	private int nenner;

	/**
	 * Standardkonstruktor
	 */
	public Bruchzahl() {
		this(0, 1);
	}

	/**
	 * Konstruktor fuer ganze Zahlen
	 * 
	 * @param zaehler des Bruches
	 */
	public Bruchzahl(int zaehler) {
		this(zaehler, 1);
	}

	/**
	 * allgemeiner Konstruktor
	 * 
	 * @param zaehler des Bruches
	 * @param nenner  des Bruches
	 */
	public Bruchzahl(int zaehler, int nenner) {
		if (nenner == 0)
			this.nenner = 1;
		else
			this.nenner = nenner;
		this.zaehler = zaehler;

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
	public void setNenner(int n) {
		if (n != 0) {
			this.nenner = n;
		} else {
			nenner = 1;
		}
	}

	/**
	 * erstellt eine Textform des Bruches
	 * 
	 * @return
	 */
	public String textForm() {
		String s = "" + zaehler + " / " + nenner;
		return s;
	}

	/**
	 * Berechnet den Dezimalwert des Bruches
	 * 
	 * @return Dezimalwert
	 */
	public double dezimalWert() {
		double d = (double) zaehler / nenner;
		return d;
	}

	/**
	 * Erweitert den Bruch um einen Faktor
	 * 
	 * @param zahl Faktor
	 */
	public void erweitern(int zahl) {
		zaehler = zaehler * zahl;
		nenner = nenner * zahl;
	}

	/**
	 * Kuerzt die Zahl
	 */
	public void kuerzen() {
		int k = Bruchzahl.ggT(zaehler, nenner);
		zaehler = zaehler / k;
		nenner = nenner / k;
	}

	/**
	 * ggt Berechnet den groessten gemeinsamen Teiler zweier Zahlen a, b
	 * 
	 * @param a erste Zahl
	 * @param b zweite Zahl
	 * @return ggt
	 */
	public static int ggT(int a, int b) {
		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	/**
	 * Addition Die Addition der Bruchzahl mit einer weiteren Bruchzahl b
	 * 
	 * @param b zweite Bruchzahl
	 * @return Ergebnis der Addition
	 */
	public Bruchzahl addiere(Bruchzahl b) {
		return new Bruchzahl(this.nenner * b.zaehler + this.zaehler * b.nenner, this.nenner * b.nenner);
	}

	/**
	 * Subtraktion Die Subtraktion der Bruchzahl mit einer weiteren Bruchzahl b
	 * 
	 * @param b zweite Bruchzahl
	 * @return Ergebnis der Subtraktion
	 */
	public Bruchzahl subtrahiere(Bruchzahl b) {
		return this.addiere(new Bruchzahl(-b.zaehler, b.nenner));
	}

	/**
	 * Multiplikation Die Multiplikation der Bruchzahl mit einer weiteren Bruchzahl
	 * b
	 * 
	 * @param b zweite Bruchzahl
	 * @return Ergebnis der Multiplikation
	 */
	public Bruchzahl multipliziere(Bruchzahl b) {
		return new Bruchzahl(this.zaehler * b.zaehler, this.nenner * b.nenner);
	}

	/**
	 * Division Die Division der Bruchzahl mit einer weiteren Bruchzahl b
	 * 
	 * @param b zweite Bruchzahl
	 * @return Ergebnis der Division
	 */
	public Bruchzahl dividiere(Bruchzahl b) {
		return this.multipliziere(b.invertiere());
	}

	/**
	 * Kehrwert Die Kehrwert der Bruchzahl wird ermittelt
	 * 
	 * @return Ergebnis des Kehrwertes
	 */

	public Bruchzahl invertiere() {
		return new Bruchzahl(this.nenner, this.zaehler);
	}

	/**
	 * Wertvergleich Der Wertvergleich der Bruchzahl mit einer weiteren Bruchzahl b
	 * 
	 * @param b zweite Bruchzahl
	 * @return Ergebnis des Wertvergleichs
	 */
	public boolean equals(Bruchzahl b) {
		boolean ret = false;
		if (b != null) {
			this.kuerzen();
			b.kuerzen();
			if (this.zaehler == b.zaehler && this.nenner == b.nenner)
				ret = true;
		}
		return ret;
	}

	/**
	 * Umdrehen Der Kehrwert eines Bruchs wird ermittelt
	 * 
	 * @param z Bruchzahl
	 * @return Kehrwert der Bruchzahl
	 */
	public static Bruchzahl umdrehen(Bruchzahl z) {
		return z.invertiere();
	}
	/**
	 * Addition mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neuer Bruch
	 */
	public Bruchzahl addiere(int i) {return this.addiere(new Bruchzahl(i));}
	/**
	 * Subtraktion mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public Bruchzahl subtrahiere(int i){return this.subtrahiere(new Bruchzahl(i));}
	/**
	 * Multiplikation mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public Bruchzahl multipliziere(int i){return this.multipliziere(new Bruchzahl(i));}
	/**
	 * Division mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public Bruchzahl dividiere(int i){return this.dividiere(new Bruchzahl(i));}
	
	/**
	 * Addition mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl addiere(Bruchzahl b, int i) {return b.addiere(new Bruchzahl(i));}
	/**
	 * Subtraktion mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl subtrahiere(Bruchzahl b, int i) {return b.subtrahiere(new Bruchzahl(i));}
	/**
	 * Multiplikation mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl multipliziere(Bruchzahl b, int i) {return b.multipliziere(new Bruchzahl(i));}
	/**
	 * Division mit einer Ganzzahl
	 * @param i Ganzzahl
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl dividiere(Bruchzahl b, int i) {return b.dividiere(new Bruchzahl(i));}
	/**
	 * Addition zweier Brueche
	 * @param b1 Bruchzahl1
	 * @param b2 Bruchzahl2
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl addiere(Bruchzahl b1, Bruchzahl b2){return b1.addiere(b2);}
	/**
	 * Subtraktion zweier Brueche
	 * @param b1 Bruchzahl1
	 * @param b2 Bruchzahl2
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl subtrahiere(Bruchzahl b1, Bruchzahl b2) {return b1.subtrahiere(b2);}
	/**
	 * Multiplikation zweier Brueche
	 * @param b1 Bruchzahl1
	 * @param b2 Bruchzahl2
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl multipliziere(Bruchzahl b1, Bruchzahl b2) {return b1.multipliziere(b2);}
	/**
	 * Division zweier Brueche
	 * @param b1 Bruchzahl1
	 * @param b2 Bruchzahl2
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl dividiere(Bruchzahl b1, Bruchzahl b2) {return b1.dividiere(b2);}
	
	/**
	 * Potenz eines Bruches mit einem Integer
	 * @param i Hochzahl
	 * @return neue Bruchzahl
	 */
	public Bruchzahl potenziere(int i) {
		return (i>=0)?
				new Bruchzahl((int)Math.pow(this.zaehler, i),(int)Math.pow(this.nenner, i)):
				new Bruchzahl((int)Math.pow(this.nenner, -i),(int)Math.pow(this.zaehler, -i));
	}
	/**
	 * Potenz eines Bruches mit einem Integer
	 * @param b Bruchzahl
	 * @param i Hochzahl
	 * @return neue Bruchzahl
	 */
	public static Bruchzahl potenziere(Bruchzahl b, int i) {
		return b.potenziere(i);
	}
}
