package raten;

import java.awt.*;
import javax.swing.*;

/**
 * Panel f�r Figuren mit �berschrift
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.0
 * 
 */
public class GewinnPanel extends JPanel {
	private static final long serialVersionUID = 4581784888223628483L;
	private JLabel jlPunkteGesamt, jLAktuellesErgebnis;
	private JLabel jLComputerZahl;
	private JTextField jTFSpielerZahl;
	private JButton jBNocheinmal;

	/**
	 * Standard Konstruktor setzt alle Komponenten ins Panel
	 */
	public GewinnPanel(GewinnController c) {
	
		this.setLayout(new BorderLayout());

		////////////////////////////////
		
		// NORTH
		JPanel north = new JPanel(new GridLayout(2,2));
		north.add(new JLabel("Punkte gesamt:"));
		north.add(new JLabel("Aktuelles Ergebnis:"));
		jlPunkteGesamt=new JLabel();
		jlPunkteGesamt.setOpaque(true);
		jlPunkteGesamt.setHorizontalAlignment(JLabel.CENTER);
		north.add(jlPunkteGesamt);
		jLAktuellesErgebnis=new JLabel();
		jLAktuellesErgebnis.setOpaque(true);
		jLAktuellesErgebnis.setHorizontalAlignment(JLabel.CENTER);
		north.add(jLAktuellesErgebnis);
		this.add(north, BorderLayout.NORTH);
		// CENTER
		JPanel center = new JPanel(new GridLayout(2,2));
		center.add(new JLabel("Zahl für nächste Runde:"));
		center.add(new JLabel("Computer Zahl:"));
		jTFSpielerZahl = new JTextField();
		jTFSpielerZahl.setHorizontalAlignment(JLabel.CENTER);
		jTFSpielerZahl.setActionCommand("enter");
		jTFSpielerZahl.addActionListener(c);
		center.add(jTFSpielerZahl);
		jLComputerZahl= new JLabel();
		jLComputerZahl.setHorizontalAlignment(JLabel.CENTER);
		center.add(jLComputerZahl);
		this.add(center, BorderLayout.CENTER);
		// SOUTH
		jBNocheinmal = new JButton("Noch einmal!");
		jBNocheinmal.setActionCommand("button");
		jBNocheinmal.addActionListener(c);
		jBNocheinmal.setEnabled(false);
		this.add(jBNocheinmal, BorderLayout.SOUTH);
		
		////////////////////////////////
	}
	public void init() {
		this.jLAktuellesErgebnis.setBackground(Color.WHITE);
		this.jlPunkteGesamt.setBackground(Color.WHITE);
		this.jLAktuellesErgebnis.setText("");
		this.jTFSpielerZahl.setText("");
		this.jLComputerZahl.setText("");
	}

	public void EnableButton(boolean b) {
		this.jBNocheinmal.setEnabled(b);
	}
	public void EnableTextField(boolean b) {
		this.jTFSpielerZahl.setEditable(b);
	}
	/**
	 * @return the jTFSpielerZahl
	 */
	public int getjTFSpielerZahl() {
		return Integer.parseInt(jTFSpielerZahl.getText());
	}
	public void setGesamtPunkte(int p) {

		if(p>=100) {
			this.setAktuellesErgebnis(p);
			this.jlPunkteGesamt.setText("GEWONNEN!");
			this.jlPunkteGesamt.setBackground(Color.GREEN);
		}
		else if(p<=0) {
			this.setAktuellesErgebnis(p);
			this.jlPunkteGesamt.setText("VERLOREN!");
			this.jlPunkteGesamt.setBackground(Color.RED);
		
		}else
			this.jlPunkteGesamt.setText(""+p);
	}
	public void setAktuellesErgebnis(int p) {
		if(p>0) 
			this.jLAktuellesErgebnis.setBackground(Color.GREEN);
		else
			this.jLAktuellesErgebnis.setBackground(Color.RED);
			
		this.jLAktuellesErgebnis.setText(""+p);
	}
	public void setComputerZahl(int p) {
		this.jLComputerZahl.setText(""+p);
	}
}
