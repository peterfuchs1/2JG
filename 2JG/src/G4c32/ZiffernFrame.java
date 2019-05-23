package G4c32;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Frame Klasse die ein ZiffernPanel im Center anzeigt
 * hineingesetzt
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class ZiffernFrame extends JFrame {

	private static final long serialVersionUID = 4162099282684131327L;

	/**
	 * Standard Konstruktor
	 * @param ziffernPanel das darzustellen ist
	 */
	public ZiffernFrame(ZiffernPanel ziffernPanel) {
		this(ziffernPanel,"");
	} 
	/**
	 * Standard Konstruktor
	 * @param ZiffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 */
	public ZiffernFrame(ZiffernPanel ziffernPanel, String header) {
		super(header);
		this.standard(ziffernPanel);

	} 

	/**
	 * Kostruktor mit veraenderlichem Frame
	 * @param ziffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resizable Soll das Fenster groessenveraenderbar sein?
	 */
	public ZiffernFrame(ZiffernPanel ziffernPanel,String header, boolean resizable) {
		super(header);
		standard(ziffernPanel,resizable);
	}
	/**
	 * Konstruktor
	 * @param ziffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param width Breite des Frames
	 * @param height Hoehe des Frames
	 */
	public ZiffernFrame(ZiffernPanel ziffernPanel,String header, int width, int height) {
		super(header);
		this.setSize(width, height);
		standard(ziffernPanel);
	}
	/**
	 * Konstruktor
	 * @param ziffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resize Soll das Fenster groessenveraenderbar sein?
	 * @param width Breite des Frames
	 * @param height Hoehe des Frames
	 */
	public ZiffernFrame(ZiffernPanel ziffernPanel,String header, boolean resize, int width, int height) {
		this.setSize(width, height);
		standard(ziffernPanel,resize);
	}
	/**
	 * Stellt ein veraenderliches Frame da
	 * @param ZiffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resizable Soll das Fenster groessenveraenderbar sein?
	 */
	private void standard(ZiffernPanel ziffernPanel, boolean resizable) {
		this.setResizable(resizable);
		standard(ziffernPanel);
	}
	/**
	 * Stellt ein unveraenderliches Frame da
	 * @param ZiffernPanel das darzustellen ist
	 * @param header Titel des Frames
	 * 
	 */
	private void standard(ZiffernPanel ziffernPanel) {
		this.add(ziffernPanel, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

}
