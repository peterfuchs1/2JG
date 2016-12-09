package bsp.mvc;

import javax.swing.*;

public class WuerfelFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3149850066183329387L;

	public WuerfelFrame(JPanel layoutPanel, String title) {

		super(title);
		this.add(layoutPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
