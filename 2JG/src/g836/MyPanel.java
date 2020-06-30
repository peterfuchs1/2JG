/**
 * 
 */
package g836;

import javax.swing.*;
import java.awt.*;

/**
 * @author wrafeiner
 *
 */
public class MyPanel extends JPanel {
	private JLabel title;
	private JLabel lAktuell;
	private JTextField tfZahl;
	private JPanel top;
	private JButton check;
	private JButton neu;
	private JLabel message;
	private JLabel lZufall;
	private JButton loese;
	private int max;
	private JPanel bottom;
	private JPanel left;
	private JPanel right;
	private JLabel lLeft;
	private JLabel lRight;
	
	public final static Color[] COLORS= {Color.YELLOW, Color.GREEN,Color.RED};
	public final static String[] MESSAGES= {
			"Die gewaehlte Zahl ist noch zu klein!",
			"Gratulation die gesuchte Zahl ist korrekt!",
			"Die gewaehlte Zahl ist noch zu gross!"
	};
	public MyPanel(MyController c,  int max) {
		this.max=max;
		left = new JPanel();
		lLeft = new JLabel(" ");
		left.add(lLeft);
		right= new JPanel();
		lRight = new JLabel(" ");
		right.add(lRight);
		JPanel upper=new JPanel(new BorderLayout());
		bottom=new JPanel (new BorderLayout());
		/************ upper start ********************/
		title = new JLabel("");
		upper.add(title,BorderLayout.PAGE_START);
		/************ upper ready ********************/
		
		/************ center start ********************/
		JPanel center = new JPanel(new GridLayout(2,3,5,5));
		JLabel leer =new JLabel();
		center.add(leer);
		JLabel lEingabe=new JLabel("Eingabe");
		lEingabe.setHorizontalAlignment(JLabel.CENTER);
		center.add(lEingabe);
		JLabel lGesucht=new JLabel("Gesucht");
		lGesucht.setHorizontalAlignment(JLabel.CENTER);
		center.add(lGesucht);
		lAktuell = new JLabel("Die aktuelle Zahl: ");
		center.add(lAktuell);
		tfZahl= new JTextField("");
		tfZahl.setHorizontalAlignment(JTextField.CENTER);
		center.add(tfZahl);
		lZufall=new JLabel("");
		lZufall.setHorizontalAlignment(JLabel.CENTER);
		center.add(lZufall);
		upper.add(center,BorderLayout.CENTER);
		/************ center ready ********************/
		
		/************ bottom start ********************/
		top=new JPanel();	
		check=new JButton("Check");
		check.addActionListener(c);
		top.add(check);
		neu=new JButton("Neu");
		neu.addActionListener(c);
		top.add(neu);
		loese=new JButton("Loese");
		loese.addActionListener(c);
		top.add(loese);
		bottom.add(top,BorderLayout.CENTER);
		message=new JLabel("Bitte eine Zahl eingeben:");
		bottom.add(message,BorderLayout.PAGE_END);

		lLeft = new JLabel(" ");
		left.add(lLeft);
		lRight = new JLabel(" ");
		right.add(lRight);
		
		bottom.add(left,BorderLayout.LINE_START);
		bottom.add(right,BorderLayout.LINE_END);

		/************ bottom ready ********************/
		this.add(upper, BorderLayout.PAGE_START);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.PAGE_END);
		init();
	}
	public void setMessage(String m) {
		this.message.setText(m);
	}
	public void setZufallsZahl(String m) {
		this.lZufall.setText(m);
	}
	/**
	 * Ein neues Spiel initialisieren
	 */
	public void init() {
		title.setText("Die gesuchte Zahl liegt zwischen 1 und "+max );
		tfZahl.setEnabled(true);
		check.setEnabled(true);
		loese.setEnabled(true);
		this.setZufallsZahl("?");
		this.setBG(Color.LIGHT_GRAY);
		this.setMessage("Bitte eine Zahl eingeben. Versuche 0");
	}
	/**
	 * Ende eines Spiels
	 * @param v Anzahl der Versuche
	 */
	public void ende(int v) {
		tfZahl.setEnabled(false);
		check.setEnabled(false);
		loese.setEnabled(false);
		this.setMessage("Das Spiel ist zu ende. Versuche: "+v+" Starte ein neues Spiel!");
	}
	/**
	 * @return the tfZahl
	 */
	public String getTfZahl() {
		return tfZahl.getText();
	}
	/**
	 * Setzt die Hintergrundfarbe zur Message
	 * @param c Farbe, die gesetzt wird
	 */
	public void setBG(Color c) {
		if( bottom!=null) {
			left.setBackground(c);
			right.setBackground(c);
		}
	}
	/**
	 * Neue Ausgabe nach dem Vergleich, der aktuellen Zahl
	 * @param vergleich Ergebnis des Vergleichs [-1,0,1]
	 * @param versuche Anzahl der Versuche
	 */
	public void newMessage(int vergleich, int versuche) {
		// Vergleich muss um 1 erhoeht werden, da der Index
		// im Array bei 0 beginnt!
		vergleich++;
		this.setBG(COLORS[vergleich]);
		String m= MESSAGES[vergleich]+" Versuche "+versuche;
		this.setMessage(m);
	}
	
	
}
