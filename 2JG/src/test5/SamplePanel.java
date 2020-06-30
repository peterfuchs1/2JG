package test5;

import java.awt.*;

import javax.swing.*;

public class SamplePanel extends JPanel {

	/**
	 * 
	 */
	public SamplePanel() {
		this.setLayout(new BorderLayout(10,20));
		JPanel center=new JPanel(new GridLayout(3,1,10,10));
		JPanel rechts=new JPanel();
		BoxLayout bl=new BoxLayout(rechts, BoxLayout.Y_AXIS);
		rechts.setLayout(bl);
		JLabel lMasg=new JLabel ("my label");
		JButton b1=new JButton("Button1");
		JButton b2=new JButton("Button1");
		JButton b3=new JButton("Button1");
		JButton b4=new JButton("Button1");
		JButton b5=new JButton("Button1");
		JButton b6=new JButton("Button1");
		center.add(b1);
		center.add(b2);
		center.add(b3);
		rechts.add(b4);
		rechts.add(b5);
		rechts.add(b6);
		this.add(center,BorderLayout.CENTER);
		this.add(rechts,BorderLayout.LINE_END);
		this.add(lMasg,BorderLayout.PAGE_END);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	public static void main(String[] args) {
		SamplePanel p=new SamplePanel();
		JFrame f=new JFrame("MyLayout");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.pack();
		f.setVisible(true);
	}
	
}
