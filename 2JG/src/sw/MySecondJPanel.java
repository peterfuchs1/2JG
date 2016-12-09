package sw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Einfacher JPanel mit ActionListener
 * @author Walter Rafeiner-Magor
 *
 */
public class MySecondJPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1020410610878176801L;
	private JTextField jtfa,jtfb;	// Eingabefelder
	private JButton jb;				// Button zur Berechnung
	private JLabel jle;				// Ergebnisfeld
	/**
	 * JPanel mit Button
	 * @param t
	 */
	public MySecondJPanel(String t) {
		this.setLayout(new BorderLayout(0,5));
		this.setBackground(new Color(240, 230, 140));
		// Im Norden
		JPanel north=new JPanel();
		north.setBackground(null); //JPanel ist durchsichtig
		JLabel jlt=new JLabel(t);
		north.add(jlt);
		this.add(north,BorderLayout.NORTH);
		
		//Im Center
		JPanel center=new JPanel();
		center.setBackground(null); //JPanel ist durchsichtig
		// GridLayout mit 2 Zeilen und 5 Spalten 
		center.setLayout(new GridLayout(2,5,10,10));
		jtfa=new JTextField(4);
		jtfa.addActionListener(this); // unsere Klasse k�mmert sich um ENTER
		jtfb=new JTextField(4);
		jtfb.addActionListener(this); // unsere Klasse k�mmert sich um ENTER
		// Labels erstellen
		JLabel jla=new JLabel("A");
		JLabel jlb=new JLabel("B");
		JLabel jlp=new JLabel(" + ");
		JLabel jlg=new JLabel(" = ");
		jle=new JLabel("");
		// Elemente im GridLayout verankern
		// Erste Zeile
		center.add(jla);			// A
		center.add(new JLabel()); //Dummy
		center.add(jlb);			// B
		center.add(new JLabel()); //Dummy
		center.add(new JLabel("Ergebnis"));
		// Zweite Zeile
		center.add(jtfa);	// Eingabefeld f�r A
		center.add(jlp);	// +
		center.add(jtfb);	// Eingabefeld f�r B
		center.add(jlg);	// =
		center.add(jle);	// Ergebnisfeld
		this.add(center, BorderLayout.CENTER);
		
		// Im S�den
		JPanel south=new JPanel();
		south.setBackground(null); //JPanel ist durchsichtig
		jb=new JButton("Berechnen");
		jb.addActionListener(this); // unsere Klasse k�mmert sich um ENTER
		south.add(jb);
		this.add(south, BorderLayout.SOUTH);
	}
	/**
	 * Falls Enter oder Button gedr�ckt wurde
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Werte auslesen und in double-Werte umwandeln
		double a=Double.parseDouble(jtfa.getText());
		double b=Double.parseDouble(jtfb.getText());
		jle.setText(""+(a+b));	// Ergebnis als String setzen
	}	
}
