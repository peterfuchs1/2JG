package ueberschreiben;

public class Oberklasse {
	private int a, b;

	/**
	 * @param a
	 * @param b
	 */
	public Oberklasse(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	public void pubMethode() {

	}

	protected void proMethode() {

	}

	private void priMethode() {

	}

}
