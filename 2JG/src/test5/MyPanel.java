package test5;

import java.awt.*;
import javax.swing.*;

/**
 * Panel Rechentrainer
 *  * 
 * @author Walter Rafeiner-Magor
 * @version 1.0 
 * 
 */
public class MyPanel extends JPanel {
	private static final long serialVersionUID = 4581784888223628483L;
	private JButton plus, minus, divide, multiply;
	private JButton loesung, neueRechnung;
	private JLabel  op, gleich ;
	private JTextField zahl1,zahl2,ergebnis;
	private JLabel meldung;
	private Smiley sm;
	/**
	 * Standard Konstruktor setzt alle Komponenten ins Panel
	 */
	public MyPanel(MyController c, MyModel m) {
		this.setLayout(new BorderLayout());
		JPanel left=new JPanel(new GridLayout(4,1));
		JPanel center=new JPanel(new GridLayout(1,6));
		JPanel end=new JPanel();

		/*************** start left **********************/
		plus=new JButton("+");
		minus=new JButton("-");
		divide=new JButton(":");
		multiply=new JButton("*");
		plus.addActionListener(c);
		minus.addActionListener(c);
		divide.addActionListener(c);
		multiply.addActionListener(c);
		left.add(multiply);
		left.add(minus);
		left.add(plus);
		left.add(divide);
		/*************** left ready **********************/
		
		/*************** start center ********************/
		zahl1=new JTextField("  ");
		zahl1.setEditable(false);
		zahl1.setHorizontalAlignment(JTextField.CENTER);
		zahl1.setBackground(Color.WHITE);
		zahl2=new JTextField("  ");
		zahl2.setHorizontalAlignment(JTextField.CENTER);
		zahl2.setEditable(false);
		zahl2.setBackground(Color.WHITE);
		op=new JLabel("+");
		op.setHorizontalAlignment(JLabel.CENTER);
		zahl1.setEditable(false);
		gleich=new JLabel("=");
		gleich.setHorizontalAlignment(JLabel.CENTER);
		ergebnis=new JTextField();
		ergebnis.setHorizontalAlignment(JTextField.CENTER);
		ergebnis.addActionListener(c);
		center.add(zahl1);
		center.add(op);
		center.add(zahl2);
		center.add(gleich);
		center.add(ergebnis);
		sm=new Smiley();
		center.add(sm);
		/*************** center ready ********************/

		/*************** start end ********************/
		loesung=new JButton("Lösung");
		neueRechnung=new JButton("neue Rechnung");
		loesung.addActionListener(c);
		neueRechnung.addActionListener(c);
		meldung=new JLabel("");
		FlowLayout l=new FlowLayout();
		l.setAlignment(FlowLayout.TRAILING);
		end.setLayout(l);
		end.add(meldung);
		end.add(neueRechnung);
		end.add(loesung);

		/*************** end ready ********************/

		/*************** start this **********************/
		this.add(left,BorderLayout.LINE_START);
		this.add(center,BorderLayout.CENTER);
		this.add(end,BorderLayout.PAGE_END);
		/*************** start ready **********************/
	}
	/********** getter und setter **************/
	/**
	 * Setzt den aktuellen Status der Berechnung (Smiley)
	 * @param s
	 */
	public void setStatus(int s) {
		sm.setStatus(s);
	}
	/**
	 * Setzt eine sinnvolle Meldung
	 * @param s Meldung
	 */
	public void setMeldung(String s) {
		this.meldung.setText(s);
	}
	/**
	 * Setzt Zahl1
	 * @param s mit einem Wert
	 */
	public void setZahl1(String s) {
		this.zahl1.setText(s);
	}
	/**
	 * Setzt Zahl2
	 * @param s mit einem Wert
	 */
	public void setZahl2(String s) {
		this.zahl2.setText(s);
	}
	/**
	 * Setzt Ergebnis
	 * @param s mit einem Wert
	 */

	public void setErgebnis(String s) {
		this.ergebnis.setText(s);
	}
	/**
	 * @return the plus
	 */
	public JButton getPlus() {
		return plus;
	}
	/**
	 * @return the minus
	 */
	public JButton getMinus() {
		return minus;
	}
	/**
	 * @return the divide
	 */
	public JButton getDivide() {
		return divide;
	}
	/**
	 * @return the multiply
	 */
	public JButton getMultiply() {
		return multiply;
	}
	/**
	 * setzt den Operator
	 * @param c neuer Operator
	 */
	public void setOperator(char c) {
		this.op.setText(""+c);
	}
	/**
	 * @return the loesung
	 */
	public JButton getLoesung() {
		return loesung;
	}
	/**
	 * @return the neueRechnung
	 */
	public JButton getNeueRechnung() {
		return neueRechnung;
	}
	/**
	 * @return the ergebnis
	 */
	public JTextField getErgebnis() {
		return ergebnis;
	}
	
}
