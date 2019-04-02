package G713.schaettle;

import java.util.Objects;

/**
 * erbt von Produkt und hat Methoden zur Berrechnung des Rabatts.
 * 
 * @author Georg Sch?ttle
 * @version 2019-02-22
 *
 */

public class RabattProdukt extends Produkt {
	private int rabatt;
	
	/**
	 * Konstruktor mit Parameter
	 * 
	 * @param produktID Die ProduktID
	 * @param bezeichnung Die Bezeichnung
	 * @param beschreibung Die Beschreibung
	 * @param preis Der Preis
	 * @param rabatt Der Rabatt
	 */
	
	public RabattProdukt(long produktID, String bezeichnung, String beschreibung, double preis, int rabatt) {
		super.setProduktID(produktID);			// Rufe Methode auf
		super.setBezeichnung(bezeichnung);		// Rufe Methode auf
		super.setBeschreibung(beschreibung);	// Rufe Methode auf
		super.setPreis(preis);					// Rufe Methode auf
		this.rabatt = rabatt;					// Intialisier
	}
	
	/**
	 * Standart-Konstruktor
	 */
	
	public RabattProdukt() {
		this(123, "StandardBezeichnung", "StandardBeschreibung",12.30, 50);		// Intialsier
	}
	
	/**
	 * Getter fuer Rabatt
	 * @return den Rabatt
	 */

	public int getRabatt() {
		return this.rabatt;									// Gibr zur?ck
	}
	/**
	 * Setter Methode f?r Rabatt
	 * @param rabatt Der Rabatt
	 */
	public void setRabatt(int rabatt) {
		if((rabatt >= 0) && (rabatt <= 100)) {			
			this.rabatt = rabatt;							// Intialisier
		}
	
	}
	
	/**
	 * Gibt den ermaessigten preis zur?ck
	 * 
	 * @return Den ermaessigten Preis
	 */
	
	public double ermaessigterPreis() {
		return super.getPreis()-(super.getPreis()*this.rabatt /100 );		// Gib zur?ck
	}
	
	/**
	 * Gibt den Gesamtpreis plus Rabatt zur?ck
	 * 
	 * @param stueckZahl
	 * @return
	 */
	@Override
	public double gesamtPreis(int stueckZahl) {
		return super.gesamtPreis(stueckZahl) -(super.gesamtPreis(stueckZahl)*this.rabatt / 100);	// Gib zur?ck
		
	}
	
	/**
	 * Gibt die Produktdaten zur?ck  mit Rabatt
	 * 
	 * @return Die Produktdaten
	 */
	@Override
	public String toString() {
		return (""+super.toString()+" ("+this.ermaessigterPreis()+" Euro mit "+this.getRabatt()+"% Erm?ssignung");		// Gib zur?ck
	}
	public boolean equals(RabattProdukt rprodukt){
		return(super.equals(rprodukt) && this.rabatt==rprodukt.getRabatt());
	}

	/**
	 * gibt true zurück, wenn alle attribute des this objektes mit denen des object parameters übereinstimmen
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		RabattProdukt that = (RabattProdukt) o;
		return rabatt == that.rabatt;
	}

	/**
	 * Generiert einen Hashcode für jedes Attribut
	 * @return Der hashCode
	 * @return
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), rabatt);
	}
}
