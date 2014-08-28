package paint_figures;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Panel für Figuren mit Überschrift
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class MyPanel extends JPanel {
	private static final long serialVersionUID = 4581784888223628483L;
	private JRadioButton qTrue;
	private JRadioButton qFalse;
	private JRadioButton kTrue;
	private JRadioButton kFalse;
	private JRadioButton dTrue;
	private JRadioButton dFalse;
	private Zeichnung[] figuren;



	/**
	 * Standard Konstruktor setzt alle Komponenten ins Panel
	 */
	public MyPanel(MyController c) {
		// Drei Figuren erstellen
		figuren = new Zeichnung[3];
		int i = 0;
		figuren[i++] = new Zeichnung(Figur.PFEIL_UNTEN, true);
		figuren[i++] = new Zeichnung(Figur.DOPPEL_PFEIL, true);
		figuren[i] = new Zeichnung(Figur.PFEIL_OBEN, true);

		this.setLayout(new BorderLayout());
		// Header
		JPanel north = new JPanel();
		JLabel header = new JLabel("Wähle für jede Figur mit oder ohne Füllung aus");
		north.add(header);
		this.add(north,BorderLayout.NORTH);
		
		////////////////////////////////
		// Center 3 SPalten eine Zeile
		JPanel center = new JPanel(new GridLayout(1, 3));
		////
		//// erste Spalte Quadrat
		JPanel quadrat = new JPanel(new BorderLayout());
		// North
		JPanel qNorth = new JPanel();
		JLabel qLabel = new JLabel("Pfeil nach unten");
		qNorth.add(qLabel);
		quadrat.add(qNorth, BorderLayout.NORTH);
		// Center
		quadrat.add(figuren[0], BorderLayout.CENTER);

		// South
		JPanel qSouth = new JPanel(new GridLayout(1, 2));
		ButtonGroup qrbg = new ButtonGroup();
		qTrue = new JRadioButton("mit Füllung", true);
		qTrue.addActionListener(c);
		qrbg.add(qTrue);
		qSouth.add(qTrue);
		qFalse = new JRadioButton("ohne Füllung", false);
		qFalse.addActionListener(c);
		qrbg.add(qFalse);
		qSouth.add(qFalse);
		quadrat.add(qSouth, BorderLayout.SOUTH);
		////
		center.add(quadrat);
		
		//// zweite Spalte Kreis
		JPanel kreis = new JPanel(new BorderLayout());
		// North
		JPanel kNorth = new JPanel();
		JLabel kLabel = new JLabel("Doppelpfeil");
		kNorth.add(kLabel);
		kreis.add(kNorth, BorderLayout.NORTH);
		// Center
		kreis.add(figuren[1], BorderLayout.CENTER);

		// South
		JPanel kSouth = new JPanel(new GridLayout(1, 2));
		ButtonGroup krbg = new ButtonGroup();
		kTrue = new JRadioButton("mit Füllung", true);
		kTrue.addActionListener(c);
		krbg.add(kTrue);
		kSouth.add(kTrue);
		kFalse = new JRadioButton("ohne Füllung", false);
		kFalse.addActionListener(c);
		krbg.add(kFalse);
		kSouth.add(kFalse);
		kreis.add(kSouth, BorderLayout.SOUTH);
		////
		center.add(kreis);
		
		//// dritte Spalte Dreieck
		JPanel dreieck = new JPanel(new BorderLayout());
		// North
		JPanel dNorth = new JPanel();
		JLabel dLabel = new JLabel("Pfeil nach oben");
		dNorth.add(dLabel);
		dreieck.add(dNorth, BorderLayout.NORTH);
		// Center
		dreieck.add(figuren[2], BorderLayout.CENTER);

		// South
		JPanel dSouth = new JPanel(new GridLayout(1, 2));
		ButtonGroup drbg = new ButtonGroup();
		dTrue = new JRadioButton("mit Füllung", true);
		dTrue.addActionListener(c);
		drbg.add(dTrue);
		dSouth.add(dTrue);
		dFalse = new JRadioButton("ohne Füllung", false);
		dFalse.addActionListener(c);
		drbg.add(dFalse);
		dSouth.add(dFalse);
		dreieck.add(dSouth, BorderLayout.SOUTH);
		////
		center.add(dreieck);
		this.add(center,BorderLayout.CENTER);		
	}
	
	// GETTERS
	/**
	 * @return the figuren
	 */
	public Zeichnung[] getFiguren() {
		return figuren;
	}

	/**
	 * @return the qTrue
	 */
	public JRadioButton getqTrue() {
		return qTrue;
	}

	/**
	 * @return the qFalse
	 */
	public JRadioButton getqFalse() {
		return qFalse;
	}

	/**
	 * @return the kTrue
	 */
	public JRadioButton getkTrue() {
		return kTrue;
	}

	/**
	 * @return the kFalse
	 */
	public JRadioButton getkFalse() {
		return kFalse;
	}

	/**
	 * @return the dTrue
	 */
	public JRadioButton getdTrue() {
		return dTrue;
	}

	/**
	 * @return the dFalse
	 */
	public JRadioButton getdFalse() {
		return dFalse;
	}
	
}
