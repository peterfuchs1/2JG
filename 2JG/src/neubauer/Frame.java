package neubauer;

import javax.swing.JFrame;
/**
 * Frame Klasse
 * @author David Neubauer
 * @version 2019-05-29
 *
 */
public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 * @param name Name
	 * @param a Breite
	 * @param b Höhe
	 * @param p1 PanelObjekt
	 */
	public Frame(String name, int a, int b, MyPanel p1) {
		super(name);
		//p1 = new MyPanel();
		this.add(p1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(a, b);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

}
