package neubauer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
/**
 * Panel Klasse
 * @author David Neubauer
 * @version 2019-05-29
 *
 */
public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Grafik g;
	/**
	 * Konstruktor
	 */
	public MyPanel() {
		this.setLayout(new BorderLayout());
		g = new Grafik();
		this.add(g, BorderLayout.CENTER);
	}
	/**
	 * Kreisfarbe setzen
	 * @param a Farbcode
	 */
	public void setKreis(int a) {
		g.setKreis(a);
	}
}
