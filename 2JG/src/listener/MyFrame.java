package listener;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Frame Klasse die ein MyPanel im Center anzeigt
 * hineingesetzt
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4162099282684131327L;

	/**
	 * Standard Konstruktor
	 * @param myPanel das darzustellen ist
	 */
	public MyFrame(JPanel myPanel) {
		this(myPanel,"");
	} 
	/**
	 * Standard Konstruktor
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 */
	public MyFrame(JPanel myPanel, String header) {
		standard(myPanel,"");
	} 

	/**
	 * Kostruktor mit veraenderlichem Frame
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resizable Soll das Fenster groessenveraenderbar sein?
	 */
	public MyFrame(JPanel myPanel,String header, boolean resizable) {
		standard(myPanel, header,resizable);
	}
	/**
	 * Konstruktor
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param width Breite des Frames
	 * @param height Hoehe des Frames
	 */
	public MyFrame(JPanel myPanel,String header, int width, int height) {
		this.setSize(width, height);
		standard(myPanel,header);
	}
	/**
	 * Konstruktor
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resize Soll das Fenster groessenveraenderbar sein?
	 * @param width Breite des Frames
	 * @param height Hoehe des Frames
	 */
	public MyFrame(JPanel myPanel,String header, boolean resize, int width, int height) {
		this.setSize(width, height);
		standard(myPanel,header,resize);
	}
	/**
	 * Stellt ein veraenderliches Frame da
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 * @param resizable Soll das Fenster groessenveraenderbar sein?
	 */
	private void standard(JPanel myPanel,String header, boolean resizable) {
		this.setResizable(resizable);
		standard(myPanel, header);
	}
	/**
	 * Stellt ein unveraenderliches Frame da
	 * @param myPanel das darzustellen ist
	 * @param header Titel des Frames
	 * 
	 */
	private void standard(JPanel myPanel,String header) {
		this.setTitle(header);
		this.add(myPanel, BorderLayout.CENTER);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

}
