package buch;

public class Buch {
	private String name;
	private String autor;
	private int seitenzahl;

	public Buch(String name, String autor, int seitenzahl) {
		this.name=name;
		this.autor=autor;
		this.seitenzahl=seitenzahl;
		
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
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the seitenzahl
	 */
	public int getSeitenzahl() {
		return seitenzahl;
	}

	/**
	 * @param seitenzahl the seitenzahl to set
	 */
	public void setSeitenzahl(int seitenzahl) {
		this.seitenzahl = seitenzahl;
	}
	public String buchDaten() {
		return this.name+" ("+this.autor+") - "+this.seitenzahl+" Seiten";
	}
}
