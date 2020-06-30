package neubauer;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * Grafik Klasse
 * @author David Neubauer
 * @version 2019-05-29
 *
 */
public class Grafik extends JPanel{
	private static final long serialVersionUID = 1L;
	private Color c1;
	/**
	 * Konstruktor
	 */
	public Grafik() {
		this.c1 = Color.BLACK;
	}
	/**
	 * paintComponent
	 * @param g Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int mitteX = super.getWidth()/2;
		int mitteY = super.getHeight()/2;
		int xsize = super.getWidth();
		int ysize = super.getHeight();
		g.setColor(c1);
		g.fillOval(mitteX,mitteY,(int)(xsize*0.4),(int)(ysize*0.4));
	}
	/**
	 * Kreisfarbe setzen
	 * @param c Farbcode
	 */
	public void setKreis(int c) {
		if(c == 3) {
			this.c1 = Color.GREEN;
		}
		if(c == 2) {
			this.c1 = Color.RED;
		}
		if(c == 1) {
			this.c1 = Color.YELLOW;
		}
		System.out.println(c1);
		this.repaint();
	}
}
