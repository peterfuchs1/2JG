package sw;

import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 * Gui mittels Swing-Komponenten
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class MySecondSwingFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8481542959809384L;
	public MySecondSwingFrame() {
		// Einen JPanel erzeugen
		MySecondJPanel jp= new MySecondJPanel("Bitte für A und B reele Werte eingeben");
		// und im CENTER des JFrames verankern
		this.add(jp,BorderLayout.CENTER);
		this.pack();
		this.setResizable(false);		// Größe nicht veränderbar
		this.setLocationRelativeTo(null);	// Darstellung mittig am Bildschirm
		// Standardmethode beim Schließen des Fensters
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		// JFrame ist nun sichtbar
	}
	public static void main(String[] args) {
		new MySecondSwingFrame();
	}
}
