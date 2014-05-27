package bsp.mvc;

import javax.swing.*;

public class WuerfelFrame extends JFrame {
	
	public WuerfelFrame(JPanel layoutPanel, String title) {

		super(title);
		this.add(layoutPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}