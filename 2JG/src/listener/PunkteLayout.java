package listener;

import javax.swing.*;
import java.awt.*;
/**
 * View-Klasse 
 * @author wrafeiner
 *
 */
public class PunkteLayout extends JPanel {
    private PunkteGrafik grafik; /*Grafik zur Darstellung des Punktes*/
    private JLabel beschreibung; /*Beschreibung der Punktfarbe*/
    private Color farbe; /*Farbe des Punktes*/
    /**
     * Konstruktor
     */
    public PunkteLayout() {
        this.setLayout(new BorderLayout());
        this.grafik=new PunkteGrafik();
        this.add(grafik,BorderLayout.CENTER);
        this.beschreibung = new JLabel("Drücke R, G oder B, um eine Farbe zu wählen");
        this.add(beschreibung, BorderLayout.PAGE_START);

        farbe = Color.RED;
    }
    /**
     * Setter: Setzt Farbe und Text
     * @param farbe aktuelle Farbe
     * @param text textuelle Beschreibung der aktuellen Farbe
     */
    public void setFarbe(Color farbe, String text) {
        this.farbe = farbe;
        beschreibung.setText("Die aktuelle Farbe ist: " + text);
    }
    /**
     * SETTER Punkt: standardgemaess wird die Groesse 50 verwendet
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
	public void setPunkt(int x, int y) {
        Punkt p = new Punkt(x, y, 50);
        this.grafik.setPunkt(p, this.farbe);
    }

}