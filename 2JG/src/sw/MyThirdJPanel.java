package sw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Einfacher JPanel mit ActionListener
 * @author Walter Rafeiner-Magor
 *
 */
public class MyThirdJPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1960845176375171801L;
	private JTextField jtfa,jtfb;	// Eingabefelder
	private JButton jb;				// Button zur Berechnung
	private JLabel jle;				// Ergebnisfeld
	private JComboBox<String> jcb;
	/**
	 * JPanel mit Button
	 * @param t
	 */
	public MyThirdJPanel(String t) {
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
		jtfa.addActionListener(this); // unsere Klasse kümmert sich um ENTER
		jtfb=new JTextField(4);
		jtfb.addActionListener(this); // unsere Klasse kümmert sich um ENTER
		// Labels erstellen
		JLabel jla=new JLabel("A");
		JLabel jlb=new JLabel("B");
		JLabel jlg=new JLabel(" = ");
		jle=new JLabel("");
		// JComboBox erstellen
		jcb=new JComboBox<String>(new String[]{"+","-","*","/"});
		jcb.addActionListener(this);
		// Elemente im GridLayout verankern
		// Erste Zeile
		center.add(jla);			// A
		center.add(new JLabel()); //Dummy
		center.add(jlb);			// B
		center.add(new JLabel()); //Dummy
		center.add(new JLabel("Ergebnis"));
		// Zweite Zeile
		center.add(jtfa);	// Eingabefeld für A
		center.add(jcb);
		center.add(jtfb);	// Eingabefeld für B
		center.add(jlg);	// =
		center.add(jle);	// Ergebnisfeld
		this.add(center, BorderLayout.CENTER);
		
		// Im Süden
		JPanel south=new JPanel();
		south.setBackground(null); //JPanel ist durchsichtig
		jb=new JButton("Berechnen");
		jb.addActionListener(this); // unsere Klasse kümmert sich um ENTER
		south.add(jb);
		this.add(south, BorderLayout.SOUTH);
	}
	/**
	 * Falls Enter oder Button gedrückt wurde
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Werte auslesen und in double-Werte umwandeln
		String eval=(String)jcb.getSelectedItem();		
		double a=Double.parseDouble(jtfa.getText());
		double b=Double.parseDouble(jtfb.getText());
		double result=0.0;
		switch(eval){
		case "+": result=a+b;break;
		case "-": result=a-b;break;
		case "*": result=a*b;break;
		case "/": result=a/b;break;
		}
		jle.setText(""+(result));	// Ergebnis als String setzen
	}	
}
