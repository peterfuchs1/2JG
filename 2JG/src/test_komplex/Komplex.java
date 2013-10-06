package test_komplex;

/**
 * Komplexe Zahlen
 * 
 * @author uhs374h
 * @version 05.10.2013
 * 
 */
public class Komplex implements Comparable<Komplex> {
	private double r; // Realteil
	private double i; // Imaginaerteil

	/**
	 * Konstruktor mit zwei Paramtern
	 * 
	 * @param r
	 * @param i
	 */
	public Komplex(double r, double i) {
		this.r = r;
		this.i = i;
	}

	/**
	 * Konstruktor mit Realteil
	 * 
	 * @param r
	 */
	public Komplex(double r) {
		this(r, 0.0);
	}

	/**
	 * standard constructor
	 */
	public Komplex() {
		this(0.0, 0.0);
	}

	/**
	 * Konstruktor für Polar Notation
	 * 
	 * @param betrag
	 * @param phi
	 * @param polar
	 */
	public Komplex(double betrag, double phi, boolean polar) {
		this.r = betrag;
		this.i = phi;
		if (polar) {
			this.r = betrag * Math.cos(phi);
			this.i = betrag * Math.sin(phi);
		} 
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @param r
	 *            the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}

	/**
	 * @return the i
	 */
	public double getI() {
		return i;
	}

	/**
	 * @param i
	 *            the i to set
	 */
	public void setI(double i) {
		this.i = i;
	}

	/**
	 * Subtraktion mit komplexer Zahl
	 * 
	 * @param k
	 * @return eigene Referenz
	 */
	public Komplex minus(Komplex k) {
		return plus(-k.getR(), -k.getI());

	}

	/**
	 * Addition mit komplexer Zahl
	 * 
	 * @param k
	 * @return eigene Referenz
	 */
	public Komplex plus(Komplex k) {
		return plus(k.getR(), k.getI());

	}

	/**
	 * Subtraktion mit realer Zahl
	 * 
	 * @param r
	 * @return eigene Referenz
	 */
	public Komplex minus(double r) {
		this.r -= r;
		return this;
	}

	/**
	 * Addition mit realer Zahl
	 * 
	 * @param r
	 * @return eigene Referenz
	 */
	public Komplex plus(double r) {
		this.r += r;
		return this;
	}

	/**
	 * Subtraktion mit realen und imaginaeren Teil
	 * 
	 * @param r
	 * @param i
	 * @return eigene Referenz
	 */
	public Komplex minus(double r, double i) {
		this.r -= r;
		this.i -= i;
		return this;
	}

	/**
	 * Addition mit realen und imaginaeren Teil
	 * 
	 * @param r
	 * @param i
	 * @return eigene Referenz
	 */
	public Komplex plus(double r, double i) {
		this.r += r;
		this.i += i;
		return this;
	}

	/**
	 * Addition zweier komplexer Zahlen
	 * 
	 * @param left
	 * @param right
	 * @return neue komplexe Zahl
	 */
	public static Komplex plus(Komplex left, Komplex right) {
		return new Komplex(left.getR() + right.getR(), left.getI()
				+ right.getI());
	}

	/**
	 * Multiplikation mit reeller Zahl
	 * 
	 * @param d
	 * @return eigene Referenz
	 */
	public Komplex multiply(double d) {
		this.r *= d;
		this.i *= d;
		return this;
	}

	/**
	 * Multiplikation mit komplexer Zahl
	 * 
	 * @param r
	 * @param i
	 * @return eigene Referenz
	 */
	public Komplex multiply(double r, double i) {
		double real = this.r * r - this.i * i;
		double imag = this.r * i + this.i * r;
		this.r = real;
		this.i = imag;
		return this;
	}

	/**
	 * Multiplikation mit komplexer Zahl
	 * 
	 * @param r
	 * @param i
	 * @return eigene Referenz
	 */
	public Komplex multiply(Komplex k) {
		return multiply(k.getR(), k.getI());
	}

	/**
	 * Multiplikation zweier komplexer Zahlen
	 * 
	 * @param left
	 * @param right
	 * @return neue komplexe Zahl
	 */
	public static Komplex multiply(Komplex left, Komplex right) {
		double real = left.r * right.r - left.i * right.i;
		double imag = left.r * right.i + left.i * right.r;
		return new Komplex(real, imag);
	}

	/**
	 * Subtraktion zweier komplexer Zahlen
	 * 
	 * @param left
	 * @param right
	 * @return neue komplexe Zahl
	 */
	public static Komplex minus(Komplex left, Komplex right) {
		return plus(left, right.multiply(-1));
	}

	/**
	 * Division durch reelle Zahl
	 * 
	 * @param d
	 * @return
	 * @throws ArithmeticException
	 */
	public Komplex divide(double d) throws ArithmeticException {
		if (d == 0.0)
			throw new ArithmeticException("divide by zero");
		r /= d;
		i /= d;
		return this;
	}

	/**
	 * Division durch eine komplexe Zahl
	 * 
	 * @param k
	 * @return eigene Referenz
	 * @throws ArithmeticException
	 */
	public Komplex divide(Komplex k) throws ArithmeticException {
		return divide(k.getR(), k.getI());
	}

	/**
	 * Ist die komplexe Zahl null?
	 * 
	 * @return
	 */
	public boolean isNull() {
		return (r == 0.0 && i == 0.0);
	}

	/**
	 * Division durch eine komplexe Zahl
	 * 
	 * @param k
	 * @return eigene Referenz
	 * @throws ArithmeticException
	 */
	public Komplex divide(double r, double i) throws ArithmeticException {
		double c = r;
		double d = i;
		if (c == 0.0 && d == 0.0)
			throw new ArithmeticException("divide by zero");
		double nenner = c * c + d * d;
		double a = this.r;
		double b = this.i;
		this.r = (a * c + b * d) / nenner;
		this.i = (b * c - a * d) / nenner;
		return this;
	}

	/**
	 * Division zweier komplexer Zahlen
	 * 
	 * @param left
	 * @param right
	 * @return neue kopmlexe Zahl
	 */
	public static Komplex divide(Komplex left, Komplex right)
			throws ArithmeticException {
		double c = right.getR();
		double d = right.getI();
		if (right.isNull())
			throw new ArithmeticException("divide by zero");
		double nenner = c * c + d * d;
		double a = left.r;
		double b = left.i;
		double r = (a * c + b * d) / nenner;
		double i = (b * c - a * d) / nenner;
		return new Komplex(r, i);
	}

	/**
	 * Betrag der komplexen Zahl
	 * 
	 * @return
	 */
	public double betrag() {
		return Math.sqrt(r * r + i * i);
	}

	/**
	 * winkel phi
	 * 
	 * @return
	 */
	public double phi() {
		if (isNull())
			return 0.0;
		double vektor = betrag();
		double ret = Math.acos(this.r / vektor);
		if (i < 0)
			ret *= -1;
		return ret;
	}

	/**
	 * Konjugation der komplexen Zahl
	 * 
	 * @return
	 */
	public Komplex konjugation() {
		i = -i;
		return this;
	}

	/**
	 * Konjugation der komplexen Zahl
	 * 
	 * @param k
	 * @return
	 */
	public static Komplex konjugation(Komplex k) {
		k.setI(k.getI() * -1);
		return k;
	}

	/**
	 * @return Normalform der komplexen Zahl
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.r);
		if (this.i != 0.0) {
			if (this.i > 0.0)
				sb.append('+');
			sb.append(this.i);
			sb.append('i');
		}
		return sb.toString();
	}

	/**
	 * 
	 * @return Polarform
	 */
	public String toPolar() {
		StringBuffer sb = new StringBuffer();
		sb.append(betrag());
		if (i != 0.0) {
			sb.append("^ei*");
			sb.append(phi());
		}
		return sb.toString();
	}

	/**
	 * 
	 * @return trigonometric form
	 */
	public String toTrigonometric() {
		StringBuffer sb = new StringBuffer();
		sb.append(betrag());
		if (i != 0.0) {
			sb.append("*(");
			double p = phi();
			sb.append(Math.cos(p));
			double s = Math.sin(p);
			if (s > 0.0)
				sb.append('+');
			sb.append(s);
			sb.append("i)");
		}
		return sb.toString();
	}

	/**
	 * equals Komplex {@link java.lang.equals(Object)}
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if (obj instanceof Komplex) {
			Komplex k = (Komplex) obj;
			if (this.compareTo(k) == 0)
				ret = true;
		}
		return ret;
	}

	/**
	 * compareTo another Komplex {@link java.lang.Comparable<T>#compareTo(T)}
	 */
	@Override
	public int compareTo(Komplex k) {
		double real = r - k.getR();
		double imag = i - k.getI();
		if (real == 0.0 && imag == 0.0)
			return 0;
		if (real > 0.0)
			return 1;
		if (real == 0.0)
			if (imag > 0.0)
				return 1;
		return -1;
	}
}
