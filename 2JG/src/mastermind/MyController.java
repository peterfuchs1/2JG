/**
 * 
 */
package mastermind;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Controller f�r Zeichenbrett Actionlistener: JMenuItems im Frame MouseAdapter:
 * View
 * 
 * @author Walter Rafeiner-Magor
 * @version 3.0
 */
public class MyController implements ActionListener
		{
//	Konstanten
	private final static int MAX_VALUE=10;
	private final static int MIN_VALUE=1;
//	Attribute	
	private MyPanel view; // MyJPanel
	private MyFrame frame; // MyFrame

	private int attempts; // Versuche
	private int[] loesung; //Computerl�sung
	
	public MyController() {

		view = new MyPanel(this); // Mit MyJPanel verkn�pft
		frame = new MyFrame(view, this); // Mit MyFrame verkn�pft
		this.newMasterMind(); // initialisieren
	}

	/*
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o instanceof AbstractButton) { // Falls Objekt der Klasse JMenuItem
			AbstractButton item = (AbstractButton) o; // Cast to JMenuItem
			
			if (item == frame.getItemNew() || item== view.getJbNew())
				// Neues Mastermind
				this.newMasterMind();
			else if (item == frame.getItemAbout())
				// Info der Applikation anzeigen
				this.about();
			else if (item == frame.getItemHelp())
				// Hilfe der Applikation anzeigen
				this.showHelp();
			else if (item == frame.getItemSolve() || item==view.getJbSolve()) 
				// Spiel l�sen
				this.solve();
			else if (item == frame.getItemTest() || item==view.getJbCheck()) 
				// File speichern
				this.check();
		}
	}

	private void check() {
		int used=0;
		int correct=0;
		int[] input=view.getInput();
		for(int i=0;i<MyPanel.INPUT_FIELDS;i++){
			if(input[i]==loesung[i])
				correct++;
		}
		//Versuche erh�hen
		attempts++;
		for(int i=0;i<MyPanel.INPUT_FIELDS;i++){
			//inputs evaluieren
			for(int j=0;j<MyPanel.INPUT_FIELDS;j++){
				//mit den l�sungen vergleichen
				if(input[i]==loesung[j])
					used++;
			}
		}
		
		used-=correct;
		
		StringBuilder sb= new StringBuilder();
		sb.append("Versuch ");
		sb.append(attempts);
		sb.append(": ");
		sb.append(correct);
		sb.append(" Zahlen an der richtigen Position. ");
		if(correct!=MyPanel.INPUT_FIELDS){
			sb.append(used);
			sb.append(" richtig aber an falscher Stelle");			
		}
		view.addComment(sb.toString());
		view.refreshKreise(correct, used);
	}

	private void solve() {
		StringBuilder sb=new StringBuilder();
		sb.append("Die L�sung lautet: [");
		for(int i=0;i<MyPanel.INPUT_FIELDS;i++){
			sb.append(loesung[i]);
			if(i<MyPanel.INPUT_FIELDS-1)
				sb.append(", ");
		}
		sb.append("]");
		view.addComment(sb.toString());
		
	}

	/**
	 * About
	 */
	private void about() {
		JOptionPane.showMessageDialog(frame,
				"Mastermind v1.0\n(c) Walter Rafeiner-Magor", "Info",
				JOptionPane.OK_OPTION);
	}



	/**
	 * Neues Mastermind erstellen
	 */
	private void newMasterMind() {
		view.initialize();
		attempts=0;
		this.loesung=new int[MyPanel.INPUT_FIELDS];
		for(int i=0;i<MyPanel.INPUT_FIELDS;i++){
			boolean valueSet=false;
			while (!valueSet){
				int value=(int)(Math.random()*MAX_VALUE+MIN_VALUE);
				boolean used=false;
				for(int j=0;!used&&j<MyPanel.INPUT_FIELDS;j++){
					used=(loesung[j]==value);
				}
				if(!used){
					loesung[i]=value;
					valueSet=true;
				}
					
			}
		}

	}

	/**
	 * Zeigt die Hilfe als Dialog an
	 */
	private void showHelp() {
		JOptionPane
				.showMessageDialog(
						frame,
						"Men� Datei: Mit Neu kann ein neues Zeichenbrett erstellt werden\n\n"
								+ "Men� Bearbeiten: Einzelne Elemente l�schen oder wiederherstellen\n\n"
								+ "Zeichen: Verschieden Zeichenmethoden\n\n"
								+ "Erweiterte M�glichkeiten Tastatur:\n"
								+ "Elemente k�nnen mit Pfeiltaste  um 5 Pixel verschoben werden.\n"
								+ "Elemente k�nnen mit Pfeiltasten und ALT un 1 Pixel verschoben werden.\n"
								+ "Elemente k�nnen mit Pfeiltasten und SHIFT vergr��ert und verkleinert werden.\n",
						"Hilfe", JOptionPane.OK_OPTION);
	}

	
	private void notImplementedYet() {
		JOptionPane.showMessageDialog(frame, "Not implemented yet!", "Info",
				JOptionPane.OK_OPTION);
	}

}
