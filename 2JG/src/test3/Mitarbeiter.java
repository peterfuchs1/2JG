package test3;

public class Mitarbeiter {
	private String name;
	private double stundenzahl;
	
	public Mitarbeiter(String name, double stundenzahl) {
		this.name = name;
		this.stundenzahl = stundenzahl;
	}
	public void arbeiten(double s) {
		this.stundenzahl +=s;
	}
	public String status() {
		String s=name+" - "+this.stundenzahl;
		return s;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the stundenzahl
	 */
	public double getStundenzahl() {
		return stundenzahl;
	}
	
}
