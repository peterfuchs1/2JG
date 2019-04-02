package G623;

public class Musikstueck {

	private String titel;

	private String interpret;

	private int dauer;

	public Musikstueck(String titel, String interpret, int dauer) {
		this.titel=titel;
		this.interpret=interpret;
		this.dauer=dauer;
	}

	public Musikstueck(String titel, String interpret) {
		this(titel,interpret,200);

	}


	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * @param titel the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * @return the interpret
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * @param interpret the interpret to set
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	/**
	 * @return the dauer
	 */
	public int getDauer() {
		return dauer;
	}

	/**
	 * @param dauer the dauer to set
	 */
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public String zeigeDauer() {
		int min=this.dauer/60;
		int sec=this.dauer-min*60;
		return zweiStellen(min)+":"+zweiStellen(sec);
	}
	private String zweiStellen(int wert) {
		String ret;
		if(wert<9)
			ret ="0";
		else
			ret ="";
		return ret+wert;
	}
	public String zeigeDaten() {
		return "Der Titel "+this.titel+"mit dem Interpret:"
				+this.interpret+" hat eine Laenge von "+this.zeigeDauer();
	}

}
