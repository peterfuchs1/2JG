package test5;

/**
 * 
 * @author wrafeiner
 * @version 1.0
 * 
 */
public class Bulgarisch {
	private Vokabeln[] v;	/* Vokabeln mit Loesung */
	private int size;		/* Anzahl der Vokabel-Aufgaben */
	private int versuche;	/* Anzahl der Versuche */
	private int korrekt;	/* Anzahl der korrekten Antworten */
	/**
	 * Konstruktor liest Demodaten von Vokabeln  Italienisch -> Deutsch ein
	 */
	public Bulgarisch() {
		v = Bulgarisch.demoVokabeln();
		this.size = v.length;
		init();
	}
	/**
	 * Uebung initialisieren
	 */
	public void init() {
		versuche = 0;
		korrekt = 0;
	}
	/**
	 * neue Aufgabe mit Loesung
	 * eine zufaellige Aufgabe wird berechnet
	 * @return Vokabel mit Loesung
	 */
	public String[] getAufgabe() {
		int i = (int) (Math.random() * size);
		String[] aufgabe = { v[i].getGesucht(), v[i].getS1(), v[i].getS2(), v[i].getS3() };
		versuche++;
		return aufgabe;
	}
	/**
	 * Vergleich Vokabel und korrekter Loesung
	 * 
	 * @param gesucht Vokabel
	 * @param loesung die Loesung
	 * @return korrekte Loesung
	 */
	public int vergleich(String gesucht, int loesung) {
		int ret = 0;
		/* Alle Vokabeln dursuchen */
		for (int i = 0; ret == 0 && i < size; ++i) {
			/* Haben wir den gesuchten Begriff bereits gefunden? */
			if (v[i].getGesucht().equals(gesucht)) {
				/* War die Loesung korrekt? */
				if ((v[i].getLoesung() == loesung)) {
					korrekt++;
				} 
				ret = v[i].getLoesung();
			}
		}
		
		return ret;
	}
	/**
	 * Demosammlung von italienischen Vokabeln
	 * @return Array von italienischen Vokablen
	 */
	public static Vokabeln[] demoVokabeln() {
		Vokabeln[] v={
				new Vokabeln("хотел","Hotel","Park","Gemüse",1),
				new Vokabeln("тиквички","Zucht","Zucker","Zuchini",3),
				new Vokabeln("захар","Zucht","Zucker","Zuchini",2),
				new Vokabeln("ябълка","Apfel","Melone","Melanzani",1),
				new Vokabeln("оранжев","gelb","orange","blau",2),
				new Vokabeln("лимон","Zitrone","Orange","Mandarine",1),
				new Vokabeln("хляб","Panne","Park","Brot",3),
				new Vokabeln("светлина","See","Bach","Licht",3),
				new Vokabeln("езеро","See","Bach","Licht",1),
				new Vokabeln("момиче","Mädchen","Dom","Tyrann",1),
				new Vokabeln("апартамент","Haus","Wohnung","Dom",2)
				};
		return v;
	}

	
	
	/************ GETTER ***************/
	/**
	 * @return the versuche
	 */
	public int getVersuche() {
		return versuche;
	}
	/**
	 * @return the korrekt
	 */
	public int getKorrekt() {
		return korrekt;
	}
}
