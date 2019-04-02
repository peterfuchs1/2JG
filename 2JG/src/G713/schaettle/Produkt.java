package G713.schaettle;

import java.util.Objects;

/**
 * In diesem Programm werden Daten f�r ein Produkt gespeichert
 *
 * @author Zoleta Allysha Amber, Sch�ttle Georg
 * @version 14-02-19
 */
public class Produkt {
    private long produktID;
    private String bezeichnung;
    private String beschreibung;
    private double preis;

    /**
     * Produkt Konstruktor
     */
    public Produkt() {
        this.produktID = 27423987;
        this.bezeichnung = "Kugelschreiber blau";
        this.beschreibung = "Dieser langlebige und formsch�ne Kugelschreiber wird mit einer blauen Mine ausgeliefert";
        this.preis = 0.47;
    }

    /**
     * Produkt Konstruktor
     *
     * @param produktID    Identifikationsnummer des Produktes
     * @param bezeichnung  Bezeichnung des Produktes
     * @param beschreibung Beschreibung des Produktes
     * @param preis        Preis des Produktes
     */
    public Produkt(long produktID, String bezeichnung, String beschreibung, double preis) {
        this.produktID = produktID;
        this.bezeichnung = bezeichnung;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }

    /**
     * gibt eine eindeutige Identifikationsnummer zur�ck
     *
     * @return die Produkt ID
     */
    public long getProduktID() {
        return produktID;
    }

    /**
     * Setter-Methode f�r die Produkt ID
     *
     * @param produktID
     */
    public void setProduktID(long produktID) {
        if (produktID <= 999999999999999.0 && produktID > 0.0) {
            this.produktID = produktID;
        }
    }

    /**
     * gibt die Bezeichnung des Produktes zur�ck
     *
     * @return Bezeichnung des Produktes
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setter-Methode f�r die Bezeichnung des Produktes
     *
     * @param bezeichnung Bezeichnung des Produktes
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * gibt die Beschreibung des Produktes zur�ck
     *
     * @return Beschreibung des Produktes
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Setter-Methode f�r die Beschreibung des Produktes
     *
     * @param beschreibung Beschreibung des Produktes
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * gibt den Preis des Produktes zur�ck
     *
     * @return Produktpreis
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Setter-Methode f�r den Preis des Produktes
     *
     * @param preis
     */
    public void setPreis(double preis) {
        if (preis != 0) {
            this.preis = preis;
        }
    }

    /**
     * berechnet und gibt den Gesamtpreis zur�ck
     *
     * @param stueckZahl Anzahl an Produkten
     * @return berechneter Gesamtpreis
     */
    public double gesamtPreis(int stueckZahl) {
        double sz = (double) stueckZahl;
        return sz * this.preis;
    }

    /**
     * gibt die Daten des Produktes als String zur�ck/
     * es wird die methode toString aus der Objekt Klasse überschrieben
     *
     * @return Daten des Produktes
     */
    @Override
    public String toString() {
        return getProduktID() + " - " + getBezeichnung() + ": " + getBeschreibung() + " - " + getPreis() + " Euro";
    }

    /**
     * Generiert einen Hashcode für jedes Attribut
     * @return Der hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(produktID, bezeichnung, beschreibung, preis);
    }

    /**
     * gibt true zurück, wenn alle attribute des this objektes mit denen des object parameters übereinstimmen
     *
     * @param produkt
     * @return
     */
    public boolean equals(Produkt produkt){
        return(this.produktID==produkt.getProduktID() && this.bezeichnung.equals(getBezeichnung()) && this.beschreibung.equals(produkt.getBeschreibung())
        && this.preis==produkt.getPreis());
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
        Produkt produkt = (Produkt) o;
        return produktID == produkt.produktID &&
                Double.compare(produkt.preis, preis) == 0 &&
                Objects.equals(bezeichnung, produkt.bezeichnung) &&
                Objects.equals(beschreibung, produkt.beschreibung);
    }
}

