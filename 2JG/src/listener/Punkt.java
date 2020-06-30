package listener;
/**
 * Model Klasse Punkt
 * @author wrafeiner
 *
 */
public class Punkt {
    private int x; /*x-Koordinate*/
    private int y; /*y-Koordinate*/
    private int d; /*Durchmesser*/
    /**
     * Konstruktor
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param d Durchmesser
     */
    public Punkt(int x, int y, int d) {
        super();
        this.x = x;
        this.y = y;
        this.d = d;
    }
    // GETTER and SETTER
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the d
	 */
	public int getD() {
		return d;
	}
	/**
	 * @param d the d to set
	 */
	public void setD(int d) {
		this.d = d;
	}

}