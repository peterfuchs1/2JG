package enumberation;
/**
 * Planeten des Sonnensystems
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public enum Planet {
    MERKUR (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    ERDE   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUN (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    private Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    // Gravitationskonstante  (m3 kg-1 s-2)
    public static final double G = 6.67384E-11;

    public double surfaceGravity() {
        return G * mass / (getRadius() * getRadius());
    }
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

}