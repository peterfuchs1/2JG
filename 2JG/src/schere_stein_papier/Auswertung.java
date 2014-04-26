package schere_stein_papier;

public class Auswertung {
	private Wahl zugMensch;
	private Wahl zugPC;
	private int ausgewertet;
	private int punkteMensch;
	private int punktePC;
	private String text;

	
	/**
	 * @param zugMensch
	 * @param zugPC
	 * @param ausgewertet
	 * @param punkteMensch
	 * @param punktePC
	 * @param text
	 */
	public Auswertung(Wahl zugMensch, Wahl zugPC, int ausgewertet,
			int punkteMensch, int punktePC, String text) {
		this.zugMensch = zugMensch;
		this.zugPC = zugPC;
		this.ausgewertet = ausgewertet;
		this.punkteMensch = punkteMensch;
		this.punktePC = punktePC;
		this.text = text;
	}
	/**
	 * @return the zugMensch
	 */
	public Wahl getZugMensch() {
		return zugMensch;
	}
	/**
	 * @return the zugPC
	 */
	public Wahl getZugPC() {
		return zugPC;
	}
	/**
	 * @return the ausgewertet
	 */
	public int getAusgewertet() {
		return ausgewertet;
	}
	/**
	 * @return the punkteMensch
	 */
	public int getPunkteMensch() {
		return punkteMensch;
	}
	/**
	 * @return the punktePC
	 */
	public int getPunktePC() {
		return punktePC;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}


}
