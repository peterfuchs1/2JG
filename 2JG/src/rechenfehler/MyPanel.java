package rechenfehler;


import javax.swing.*;

import java.awt.*;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2862750214979684554L;
	private JButton jbNeu, jbPruefen; // Buttons
	private JLabel aufgabe;
	private JTextField loesung;
	private JLabel fehlermeldung;
	private int indexAufgabe;
	private MyControl control;
	private MyModel model;
	@SuppressWarnings("unused")
	private int len;			// aktuelle Länge einer Kante
	@SuppressWarnings("unused")
	private Point lastPoint;	// letzter Punkt
	
	/**
	 * Übernimmt den Controller und initialisiert das Layout
	 * @param wControl der Controller für diese GUI
	 */
	public MyPanel(MyControl control,MyModel model) {
		//Button erstellen
		this.control = control;
		jbNeu=new JButton("neue Aufgabe");
		jbNeu.addActionListener(this.control);
		jbPruefen=new JButton("Lösung überprüfen");
		jbPruefen.addActionListener(this.control);

		this.model=model;
		indexAufgabe=model.getIndex();
		
		// Layout für unser Panel
		this.setLayout(new BorderLayout());
		// Im Norden wird ein Label erstellt
		JLabel jlnorth=new JLabel("Lösen Sie die gestellten Aufgaben!");
		this.add(jlnorth, BorderLayout.NORTH);
		// Im Zentrum wird das Bild erstellt
		JPanel center=new JPanel(new GridLayout(3,1));
		aufgabe=new JLabel();
		center.add(aufgabe);
		loesung=new JTextField(6);
		loesung.addActionListener(this.control);
		center.add(loesung);
		fehlermeldung=new JLabel();
		fehlermeldung.setForeground(Color.RED);
		center.add(fehlermeldung);
		this.add(center,BorderLayout.CENTER);
		// Im Süden wird der Neu-Button erzeugt
		JPanel south=new JPanel();
		
		south.add(jbNeu);
		south.add(jbPruefen);
		
		this.add(south,BorderLayout.SOUTH);
		init();
		}
	/**
	 * Panel initialisieren
	 */
	public void init(){
		indexAufgabe=model.getIndex();
		aufgabe.setText(model.getTask(indexAufgabe));
		fehlermeldung.setText("Derzeit keine Fehler!");
	}
	/**
	 * Überprüft den Lösungsvorschlag
	 * @param index
	 * @param result
	 */
	public void checkResult(int index, String result) {
		boolean correct=false;
		int iLoesung;
		try {
			iLoesung=Integer.parseInt(result);
			correct=model.check(index, iLoesung);
		} catch (NumberFormatException e){
			fehlermeldung.setText("Bitte einen ganzzahligen Wert eingeben!");
		} catch (ArrayIndexOutOfBoundsException e) {
			fehlermeldung.setText("Eine Aufgabe mit dem gesuchten Index nicht vorhanden!");
		} catch (WrongResultException e) {
			fehlermeldung.setText("Die Lösung der Aufgabe ist leider nicht korrekt!");
		}
		if(correct)
			fehlermeldung.setText("Derzeit keine Fehler!");
	}
	// SETTER UND GETTER
	

	
	/**
	 * @return the jbNeu
	 */
	public JButton getJbNeu() {
		return jbNeu;
	}
	/**
	 * @return the indexAufgabe
	 */
	public int getIndexAufgabe() {
		return indexAufgabe;
	}
	/**
	 * @return the loesung
	 */
	public JTextField getLoesung(){
		return loesung;
	}

	/**
	 * @return the loesung
	 */
	public String getLoesungText(){
		return loesung.getText();
	}
	/**
	 * @return the jbPruefen
	 */
	public JButton getJbPruefen() {
		return jbPruefen;
	}

}
