package bsp.mvc;

/**
 *	Enthält die relevante Logik für ein einfaches Würfelspiel, bei dem beliebig
 *  viele Spieler würfeln können. Derjenige mit dem höchsten Würfelwurf gewinnt
 *  sofern schon ein Spieler gewürfelt hat.
 *
 * @author Lisa Vittori
 * @version 05.05.2014
 */
public class WuerfelSpiel {
	private int[] wuerfel;
	
	/**
	 * Erstellt ein Wuerfel-Spiel für eine beliebige Anzahl an Spielern
	 * @param anzahlSpieler die Anzahl an Spielern, wenn eine Anzahl weniger als
	 * 		2 übergeben wird, dann wird das Spiel für 2 Spieler erzeugt.
	 */
	public WuerfelSpiel(int anzahlSpieler)  {
		if(anzahlSpieler < 2) {
			anzahlSpieler = 2;
		}
		wuerfel = new int[anzahlSpieler];
		for(int i = 0; i < wuerfel.length; i++) {
			wuerfel[i] = -1;
		}
	}
	
	/**
	 * Gibt zurück, ob schon alle Spieler gewürfelt haben. 
	 * @return true, wenn alle Spieler bereits einen Würfelwurf gemacht haben,
	 * 		im anderen Fall false.
	 */
	public boolean alleGewuerfelt() {
		boolean alleGewuerfelt = true;
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] < 0) {
				alleGewuerfelt = false;
			}
		}
		return alleGewuerfelt;
	}
	
	/**
	 * Gibt die Anzahl der Spieler im Würfelspiel zurück
	 * @return die Anzahl der Spieler
	 */
	public int getSpielerAnzahl() {
		return wuerfel.length;
	}
	
	/**
	 * Gibt den gewürfelten Wert des Spielers mit dem Index spielerNr zurück
	 * @param spielerNr die Nummer des Spielers als Index (von 0 beginnend)
	 * @return den gewürfelten Wert des Spieler mit dem Index spielerNr oder -1
	 * 		falls der Spieler noch nicht gewürfelt hat oder der Spieler nicht existiert
	 */
	public int getWuerfelWert(int spielerNr) {
		if(spielerNr >= 0 && spielerNr < wuerfel.length) {
			return wuerfel[spielerNr];
		} else {
			return -1;
		}
	}
	
	/**
	 * Setzt alle Spieler auf den Status "Noch nicht gewürfelt" zurück
	 */
	public void reset() {
		for(int i = 0; i < wuerfel.length; i++) {
			wuerfel[i] = -1;
		}
	}
	
	/**
	 * Gibt die Indizes jener Spieler zurück, die gewonnen haben.
	 * @return die Indizes der Spieler mit dem höchsten Würfelergebnis oder 
	 * 		null, wenn noch kein Spieler gewürfelt hat.
	 */
	public int[] spielerGewonnen() {
		int max = -1;
		int anzahl = 0;
		int[] indizesGewonnen = null;
		for(int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] > max) {
				max = wuerfel[i];
			}
		}
		if(max > -1) {
			// Zählen wieviele Maximal-Werte es gibt
			for(int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == max) {
					anzahl++;
				}
			}
			// Speichern der Spieler-Indizes
			indizesGewonnen = new int[anzahl];
			int indexErgebnis = 0;
			for(int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == max) {
					indizesGewonnen[indexErgebnis++] = i;
				}
			}
		}
		return indizesGewonnen;
	}
	
	/**
	 * Erstellt einen Würfelwurf für den Spieler mit der angegebenen Spieler-Nummer
	 * @param spielerNr die Nummer des Spielers als Index (von 0 beginnend)
	 * @return -1, wenn der Spieler schon an der Reihe war und nicht würfeln darf
	 * 		bzw. wenn die SpielerNr nicht existiert, sonst den gewürfelten Wert
	 */
	public int wuerfeln(int spielerNr) {
		int ergebnis = -1;
		if(spielerNr >= 0 && spielerNr < wuerfel.length && wuerfel[spielerNr] < 0) {
			ergebnis = (int)(Math.random()*6 +1);
			wuerfel[spielerNr] = ergebnis ;
		}
		return ergebnis;
	}
}
