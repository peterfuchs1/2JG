package test5;

import javax.swing.*;
import java.awt.*;

public class ProphezeiungLayout extends JPanel {
	private JButton bCheck, bNeu;
	  private JLabel lSumme, lStatus;
	  private WuerfelPanel w1,w2;
	private JTextField jTF1;
	private JTextField jTF2;
	private JTextField jTF3;
	private JLabel msg;


	public ProphezeiungLayout(ProphezeiungController c, Prophezeiung myModel) {
		this.setLayout(new BorderLayout(10,20));
		/********************** oben Start ***********************/
		JPanel oben=new JPanel(new GridLayout(2,3,10,10));
		JLabel l1=new JLabel("1. Würfel");
		l1.setHorizontalAlignment(JLabel.CENTER);
		oben.add(l1);
		JLabel l2=new JLabel("2. Würfel");
		l1.setHorizontalAlignment(JLabel.CENTER);
		oben.add(l2);
		JLabel l3=new JLabel("Summe");
		l1.setHorizontalAlignment(JLabel.CENTER);
		oben.add(l3);

		jTF1 = new JTextField();
		jTF1.setHorizontalAlignment(JTextField.CENTER);
		oben.add(jTF1);
		jTF2 = new JTextField();
		jTF2.setHorizontalAlignment(JTextField.CENTER);
		oben.add(jTF2);
		jTF3 = new JTextField();
		jTF3.setHorizontalAlignment(JTextField.CENTER);
		jTF3.setEditable(false);
		oben.add(jTF3);
		/********************** oben fertig ***********************/
		
		/********************** center Start ***********************/
		JPanel center=new JPanel(new BorderLayout(10,20));
		//////// MITTE
		JPanel mitte =new JPanel(new GridLayout(1,2,20,20));
		w1=new WuerfelPanel();
		mitte.add(w1);
		w2=new WuerfelPanel();
		mitte.add(w2);
		//////// RECHTS
		JPanel rechts=new JPanel(new GridLayout(4,1,10,10));
		bCheck = new JButton("Prüfen");
		bCheck.addActionListener(c);
		rechts.add(bCheck);
		bNeu= new JButton("Neuer Versuch");
		bNeu.addActionListener(c);
		rechts.add(bNeu);
		JLabel lPunkteText=new JLabel("Punkte");
		lPunkteText.setHorizontalAlignment(JLabel.CENTER);
		rechts.add(lPunkteText);
		lSumme = new JLabel();
		lSumme.setHorizontalAlignment(JLabel.CENTER);
		rechts.add(lSumme);
		center.add(mitte,BorderLayout.CENTER);
		center.add(rechts,BorderLayout.LINE_END);
		/********************** CENTER fertig ***********************/
		msg=new JLabel();
		this.add(oben,BorderLayout.PAGE_START);
		this.add(center,BorderLayout.CENTER);
		this.add(msg,BorderLayout.PAGE_END);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		init();
	}

	public void init() {
		jTF1.setText("");
		jTF2.setText("");
		jTF3.setText("");
		setMsg("Bitte eine Prophezeiung eingeben");
	}

	public void setPunkte(int gewinnSumme) {
		this.lSumme.setText(""+gewinnSumme);
	}
	public void setAugensumme(int summe) {
		this.jTF3.setText(""+summe);
	}
	public void setMsg(String gewinnText) {
		this.msg.setText(gewinnText);
	}

	public int[] getSpielerTipps() {
		int w1=Integer.parseInt(jTF1.getText());
		int w2=Integer.parseInt(jTF2.getText());
		return new int[] {w1,w2};
	}

	/**
	 * @return the w1
	 */
	public WuerfelPanel getW1() {
		return w1;
	}

	/**
	 * @return the w2
	 */
	public WuerfelPanel getW2() {
		return w2;
	}
	
	

}
