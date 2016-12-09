package sw;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Einfacher JPanel mit ActionListener
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFirstJPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886442535682607719L;
	private JTextField jtfa,jtfb;	// Eingabefelder
	private JLabel jle;				// Ergebnisfeld
	public MyFirstJPanel() {
		// GridLayout mit 2 Zeilen und 5 Spalten 
		this.setLayout(new GridLayout(2,5,10,10));
		jtfa=new JTextField(4);
		jtfa.addActionListener(this); // unsere Klasse kümmert sich um ENTER
		jtfb=new JTextField(4);
		jtfb.addActionListener(this); // unsere Klasse kümmert sich um ENTER
		// Labels erstellen
		JLabel jla=new JLabel("A");
		JLabel jlb=new JLabel("B");
		JLabel jlp=new JLabel(" + ");
		JLabel jlg=new JLabel(" = ");
		jle=new JLabel("");
		// Elemente im GridLayout verankern
		// Erste Zeile
		this.add(jla);			// A
		this.add(new JLabel()); //Dummy
		this.add(jlb);			// B
		this.add(new JLabel()); //Dummy
		this.add(new JLabel("Ergebnis"));
		// Zweite Zeile
		this.add(jtfa);	// Eingabefeld für A
		this.add(jlp);	// +
		this.add(jtfb);	// Eingabefeld für B
		this.add(jlg);	// =
		this.add(jle);	// Ergebnisfeld
	}
	/**
	 * Falls Enter gedrückt wurde
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Werte auslesen und in double-Werte umwandeln
		double a=Double.parseDouble(jtfa.getText());
		double b=Double.parseDouble(jtfb.getText());
		jle.setText(""+(a+b));	// Ergebnis als String setzen
	}	
}
