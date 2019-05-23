package test5;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class TextUebernahme extends JFrame {

	private JSlider sTeilen;
	private JTextField tfEin;
	private JLabel lAus;
	public static String titel = "Textübernahme"; // Titel des Spiels
	public static int height = 180; // Hoehe des Frames
	public static int width = 580; // Breite des Frames

	/**
	 * Konstruktor erstellt die Objekte nach MVC
	 */
	public TextUebernahme() {
		super(titel);
		Listener l = new Listener();
		JPanel pan = new JPanel(new GridLayout(3, 1, 10, 10));
		this.setSize(width, height);
		/********** pan start ******************/
		tfEin = new JTextField("Kurzer Beispieltext");
		lAus = new JLabel("");

		sTeilen = new JSlider();
		sTeilen.setMaximum(2);
		sTeilen.addChangeListener(l);
		sTeilen.setValue(1);
		pan.add(sTeilen);
		pan.add(tfEin);
		pan.add(lAus);
		/********** pan ready ******************/
		/********** frame start ****************/
		this.add(pan);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		/********** frame ready ****************/
	}
	/**
	 * Listener Klasse für ChangeListener
	 * @author wrafeiner
	 *
	 */
	private class Listener implements ChangeListener {
		/**
		 * Alle Events abfangen und darauf reagieren
		 * @param e Slider wurde veraendert
		 */
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider s = (JSlider) e.getSource();
			int value = s.getValue();
			String t = tfEin.getText();
			int l = t.length();
			switch (value) {
			case 2:
				t = t.substring(l / 2);
				break;
			case 0:
				t = t.substring(0, l / 2);
			}
			lAus.setText(t);
		}
		
	}

	/**
	 * Start der Textuebernahme
	 * 
	 * @param args Commandline Argumente
	 */
	public static void main(String[] args) {
		new TextUebernahme();
	}

}
