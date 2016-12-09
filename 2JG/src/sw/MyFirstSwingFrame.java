package sw;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Gui mittels Swing-Komponenten
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class MyFirstSwingFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6489022419720860017L;
	public MyFirstSwingFrame() {
		// Einen JPanel erzeugen
		MyFirstJPanel jp= new MyFirstJPanel();
		// und im CENTER des JFrames verankern
		this.add(jp,BorderLayout.CENTER);
		// Im Norden wird die Erkl�rung erstellt
		JPanel north=new JPanel();
		JLabel desc=new JLabel("Bitte f�r A und B reele Werte eingeben");
		// label zum JPanel hinzuf�gen
		north.add(desc);
		// JPanel im Norden des JFrames verankern
		this.add(north,BorderLayout.NORTH);
		// Im S�den wird die zweite Erkl�rung verankert
		JPanel south=new JPanel();
		JLabel desc2=new JLabel("Mit ENTER wird die Summe ermittelt!");
		south.add(desc2);
		this.add(south,BorderLayout.SOUTH);
		
		this.setSize(320, 120);			// Gr��e 320x160 Pixel
		this.setResizable(false);		// Gr��e nicht ver�nderbar
		this.setLocationRelativeTo(null);	// Darstellung mittig am Bildschirm
		// Standardmethode beim Schlie�en des Fensters
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		// JFrame ist nun sichtbar
	}
	public static void main(String[] args) {
		new MyFirstSwingFrame();
	}

}
